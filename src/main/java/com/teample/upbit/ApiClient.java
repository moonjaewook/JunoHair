package com.teample.upbit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.List;

public class ApiClient {

    public List<TickerVo> ticker(String markets) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.upbit.com/v1/ticker?markets=" + markets)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        String responseBody = response.body().string();
        System.out.println("API Response: " + responseBody);

        return new Gson().fromJson(responseBody, new TypeToken<List<TickerVo>>() {}.getType());
    }
}
