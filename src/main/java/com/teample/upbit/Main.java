package com.teample.upbit;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApiClient api = new ApiClient();

        try {
            List<TickerVo> listTickerVo = api.ticker("KRW-VET");
            for (TickerVo v : listTickerVo) {
                System.out.println("[" + v.getMarket() + "][" + v.getTrade_date() + "][" + v.getTrade_price() + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
