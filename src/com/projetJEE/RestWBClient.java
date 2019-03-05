package com.projetJEE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class RestWBClient {

    public static void getInfo() {
        try {
            URL url = new URL("https://stormy-lowlands-39083.herokuapp.com/etudiants/");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String str = "";
            while (null != (str = br.readLine())) {
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}