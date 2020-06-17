package org.fis.maven.Services;

import org.fis.maven.Models.Admin;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdminService{
    private static ArrayList <Admin> admin = new ArrayList<>();
    Admin admin2;

    public static void loadAdmin(){
        try {
            JSONParser jsonParser= new JSONParser();
            FileReader fileReader = new FileReader("src/main/resources/Admin.json");
            Object objAdminParser = jsonParser.parse(fileReader);
            JSONArray  jsonArray= (JSONArray)objAdminParser;

            JSONObject o = (JSONObject) jsonArray;

            String user = o.get("username").toString();
            String pass = o.get("password").toString();
            int price = (int) o.get("price");

            admin.add(new Admin(user,pass, price));
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean checkCredentials(String user, String pass){
        boolean check = false;

        for(Admin i : admin){
            if ((i.getUsername().equals(user)) && (i.getPassword().equals(pass)))
                check = true;
                break;
        }

        return check;
    }

    public static ArrayList<Admin> getAdmin(){return admin;}
}