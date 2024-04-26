package models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConversion {

    public float getConvertedValue(String currentCurrency, String newCurrency, float currentMoney) {
        Gson gson = new Gson();

        String API_KEY = "bad9403ebfb19e33788d79d4";

        try {
            URI url = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + currentCurrency);

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
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
