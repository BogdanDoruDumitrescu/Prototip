package org.fis.maven.Services;


import org.fis.maven.Models.User;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;

public class UserService {
    private static ArrayList<User> u = new ArrayList<>();

    public static void loadUser(){
        u.clear();

        try{
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/User.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray)obj;

            for(Object user:ja){
                JSONObject o = (JSONObject) user;

                String name = o.get("name").toString();
                String username = o.get("username").toString();
                String password = o.get("password").toString();
                String mail = o.get("mail").toString();
                String role = o.get("role").toString();
                int credit = Integer.parseInt(o.get("credit").toString());

                u.add(new User(name,username,password,mail,role,credit));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static boolean checkCredentials(String id, String pass){
        boolean found = false;

        for(User i:u){
            if(i.getUsername().equals(id) && i.getPassword().equals(pass)){
                found=true;
                break;
            }
        }


        return found;
    }

    public static String encodePassword(String password){
        String result = Base64.getEncoder().encodeToString(password.getBytes());

        return result;
    }

    public static ArrayList<User> getU() {return u;}

    public static void writeUser() {
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/User.json");

            JSONArray ja = new JSONArray();

            for(User i:u){
                JSONObject jo = new JSONObject();
                jo.put("name",i.getName());
                jo.put("username",i.getUsername());
                jo.put("password",encodePassword(i.getPassword()));
                jo.put("mail",i.getMail());
                jo.put("role",i.getRole());
                jo.put("credit",String.valueOf(i.getCredit()));

                ja.add(jo);
            }

            fw.write(ja.toJSONString());

        }catch (Exception e){

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
