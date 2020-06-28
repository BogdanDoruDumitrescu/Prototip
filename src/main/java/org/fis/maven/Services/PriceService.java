package org.fis.maven.Services;

import org.fis.maven.Models.Admin;

import org.fis.maven.Models.Price;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PriceService {
    private static ArrayList<Price> p = new ArrayList<>();
    private static String path;

    public static void loadPrice() {
        try {
            p = new ArrayList<>();
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/Price.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for (Object price : ja) {
                JSONObject jo = (JSONObject) price;
                p.add(new Price(Integer.parseInt(jo.get("price").toString())));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Price> getP() {
        return  p;
    }

    public static void WritePrice() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/main/resources/Price.json");

            JSONArray ja = new JSONArray();

            for (Price i : p) {
                JSONObject jo = new JSONObject();
                jo.put("price", String.valueOf(i.getPrice()));

                ja.add(jo);
            }

            fw.write(ja.toJSONString());
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            try{
                fw.flush();
                fw.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void setPath(String path) {
        PriceService.path = path;
    }

}
