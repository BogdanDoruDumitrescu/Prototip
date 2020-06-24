package org.fis.maven.Services;


import org.fis.maven.Models.Admin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminService {
    private static ArrayList<Admin> p = new ArrayList<>();

    public static void loadPrice() {
        try {
            p = new ArrayList<>();
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/Admin.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for (Object price : ja) {
                JSONObject jo = (JSONObject) price;
                p.add(new Admin(Integer.parseInt(jo.get("price").toString())));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ArrayList<Admin> getP() {
        return  p;
    }

    public static void WritePrice() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("src/main/resources/Admin.json");

            JSONArray ja = new JSONArray();

            for (Admin i : p) {
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
}
