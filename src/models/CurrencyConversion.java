package models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

public class CurrencyConversion {

    public float getConvertedValue(String currentCurrency, String newCurrency, float currentMoney) {
        Gson gson = new Gson();

        String API_KEY = "Change to your API Key";

        try {
            URI url = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + currentCurrency);

            HttpResponse<String> response;
            try (HttpClient client = newHttpClient()) {

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(url)
                        .build();

                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            }
            JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
            JsonObject currencies = jsonObject.getAsJsonObject("conversion_rates");
            float currencyPrice = currencies.get(newCurrency).getAsFloat();

            return currencyPrice * currentMoney;
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro");
            return 1;
        }
    }
}
