package org.fis.maven.Services;

import org.fis.maven.Models.Race;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RaceService {
    private static ArrayList<Race> r = new ArrayList<>();
    private static String path;

    public static void loadRaces() {
        r.clear();

        try {
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader(path);
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for (Object race : ja) {
                JSONObject o = (JSONObject) race;
                String driverUserName = o.get("driverUserName").toString();
                String clientUserName = o.get("clientUserName").toString();
                int pricePerKm = Integer.parseInt(o.get("pricePerKm").toString());
                int totalPrice = Integer.parseInt(o.get("totalPrice").toString());
                int km = Integer.parseInt(o.get("km").toString());
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeRace(){
        FileWriter fw = null;
        try{
            fw = new FileWriter(path);
            JSONArray ja = new JSONArray();

            for(Race i:r){
                JSONObject jo = new JSONObject();
                jo.put("driverUserName", i.getDriverUserName());
                jo.put("clientUserName", i.getClientUserName());
                jo.put("pricePerKm", i.getPricePerKm());
                jo.put("km", i.getKm());
                jo.put("totalPrice", i.getKm());
            }
        }catch{

        }
    }

    public static void setPath(String path) {
        RaceService.path = path;
    }
}
