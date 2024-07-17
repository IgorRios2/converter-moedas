import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorDeMoedas {

    private static final String API_KEY = "8e88820676d5f0a91b02e26f";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bem-vindo ao Conversor de Moedas!");
            System.out.println("Escolha uma das opções abaixo para converter:");
            System.out.println("1. USD para EUR");
            System.out.println("2. EUR para USD");
            System.out.println("3. USD para BRL");
            System.out.println("4. BRL para USD");
            System.out.println("5. EUR para BRL");
            System.out.println("6. BRL para EUR");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();
            if (choice == 7) {
                System.out.println("Saindo...");
                break;
            }

            String fromCurrency = "";
            String toCurrency = "";

            switch (choice) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "EUR";
                    break;
                case 2:
                    fromCurrency = "EUR";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case 4:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    break;
                case 5:
                    fromCurrency = "EUR";
                    toCurrency = "BRL";
                    break;
                case 6:
                    fromCurrency = "BRL";
                    toCurrency = "EUR";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println("Digite a quantia em " + fromCurrency + ": ");
            double amount = scanner.nextDouble();

            try {
                double rate = getExchangeRate(fromCurrency, toCurrency);
                double convertedAmount = amount * rate;
                System.out.println(amount + " " + fromCurrency + " é igual a " + convertedAmount + " " + toCurrency);
            } catch (IOException | InterruptedException e) {
                System.out.println("Não foi possível obter a taxa de câmbio. Tente novamente mais tarde.");
            }
        }
        scanner.close();
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        String url = API_URL + fromCurrency + "/" + toCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject jsonObject = new JSONObject(response.body());
        if (jsonObject.getString("result").equals("success")) {
            return jsonObject.getDouble("conversion_rate");
        } else {
            throw new IOException("Erro ao obter a taxa de câmbio.");
        }
    }
}
