# Conversor de Moedas em Java

Este projeto consiste em um conversor de moedas simples desenvolvido em Java que pode ser executado no terminal. Ele utiliza a ExchangeRate-API para obter taxas de câmbio em tempo real.

## Funcionalidades

- Conversão entre as seguintes moedas:
    1. USD para EUR
    2. EUR para USD
    3. USD para BRL
    4. BRL para USD
    5. EUR para BRL
    6. BRL para EUR

## Requisitos

- JDK (Java Development Kit) 11 ou superior instalado no sistema.
- Conexão com a internet para acessar a ExchangeRate-API.

## Configuração

### Passos para Configuração

1. **Obtenha uma chave de API da ExchangeRate-API:**
    - Vá para [ExchangeRate-API](https://www.exchangerate-api.com/) e registre-se para obter uma chave de API gratuita.

2. **Baixe a biblioteca JSON:**
    - Baixe a biblioteca `org.json` do Maven Central:
      [json-20210307.jar](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)
    - Coloque o arquivo `json-20210307.jar` no diretório raiz do projeto.

## Compilação e Execução

### Compilar o Projeto

No diretório raiz do projeto, execute o seguinte comando para compilar:

```bash
javac -cp .:json-20210307.jar ConversorDeMoedas.java
