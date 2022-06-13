package de.spaffel.clans.commands.utils;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;
import java.io.IOException;
import org.json.simple.JSONObject;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.Math;

public class jsonutil extends JavaPlugin{
    private static String datafolder;

    public void setDatafolder(){
        datafolder = getDataFolder().getAbsolutePath();

    }
    public void jsonutil(){
        setDatafolder();

    }


    public static String getPass(String Clanid){
        String path = "plugins/Clans/clandata/" + Clanid + ".json";
        String ans = checkFile(path);
        if (ans == "exists"){
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                String password = (String) jsonObject.get("password");
                System.out.println("`" + password + "`");
                return password;

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return "ne diggi";
    }


    public static String getClanName(String ClanId) {
        String path = "plugins/Clans/clandata/" + ClanId + ".json";
        String ans = checkFile(path);
        if (ans == "exists") {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                String clanname = (String) jsonObject.get("name");


                return clanname;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return "nix";
    }

    public static String getPrefix(String uuid) {
        String path = "plugins/Clans/playerdata/" + uuid + ".json";
        String ans = checkFile(path);
        if (ans == "exists") {
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                String Clanid = (String) jsonObject.get("ClanId");

                if (Clanid.equals("0")){

                    String prefix = "";
                    return prefix;
                }else{
                    String Clanname = getClanName(Clanid);
                    String prefix = "§a§l[" + Clanname + "-Clan] §f§r";
                    return prefix;
                }



            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return "knecht";
    }

    public static String JoinClan(String clanname, String Password, String UUID){
        String Clanid = getClanId(clanname);
        String Orgpass = getPass(Clanid);
        System.out.println("`"+ Password +"`");
        if (Orgpass.equals(Password)){
            setClanId(UUID,Clanid);
            return "done";
        }else{

            return "incorrect";
        }
    }
    public static void createFile(String path){
        String ans = checkFile(path);
        if (ans == "not"){
            JSONObject jsonObject = new JSONObject();
            try {
                File myObj = new File(path);
                if (myObj.createNewFile()) {
                    FileWriter file = new FileWriter(path);
                    file.write(jsonObject.toJSONString());
                    file.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static String checkFile(String filePathString) {

        File f = new File(filePathString);
        if (f.exists() && !f.isDirectory()) {
            return "exists";
        } else {

            return "not";
        }
    }
    public static void setClanId(String uuid, String Clanid){
        String path = "plugins/Clans/playerdata/" + uuid + ".json";
        String ans = checkFile(path);
        if (ans == "exists"){

            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                jsonObject.put("ClanId", Clanid);
                FileWriter file = new FileWriter(path);
                file.write(jsonObject.toJSONString());
                file.close();
                System.out.println("Saved ClanId");

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }




        }else{
            System.out.println("Couldnt save Clan id because file does not exist");

        }
    }


    public static void createPlayer(String uuid){
        String path = "plugins/Clans/playerdata/" + uuid + ".json";
        String ans = checkFile(path);
        if (ans == "not"){

            createFile(path);
            setClanId(uuid, "0");

        }

    }

    public static void setClanParams(String name, String Clanid, String password, String leaderuuid){
        String path = "plugins/Clans/clandata/" + Clanid + ".json";
        String ans = checkFile(path);
        if (ans == "exists"){

            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                jsonObject.put("ClanId", Clanid);
                jsonObject.put("name", name);
                jsonObject.put("password", password);
                jsonObject.put("leader", leaderuuid);
                FileWriter file = new FileWriter(path);
                file.write(jsonObject.toJSONString());
                file.close();
                System.out.println("Saved ClanParams");

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }



        }else{
            System.out.println("Couldnt save ClanParams id because file does not exist");

        }


    }

    public static void saveClanName(String Clanname, String ClanId){
        String path = "plugins/Clans/clannames/" + Clanname + ".json";
        String ans = checkFile(path);
        if (ans == "not"){

            createFile(path);
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                jsonObject.put("Clanid", ClanId);
                FileWriter file = new FileWriter(path);
                file.write(jsonObject.toJSONString());
                file.close();
                System.out.println("Saved Clanid");

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }


    }

    public static String getClanId(String Clanname){
        String path = "plugins/Clans/clannames/" + Clanname + ".json";
        String ans = checkFile(path);
        if (ans == "exists"){
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                String Clanid = (String) jsonObject.get("Clanid");

                return Clanid;

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return "0";
    }



    public static String createClan(String name, String password, String leaderuuid){
        System.out.println("createclan läuft");
        Random rand = new Random();
        String Clanid = String.valueOf(rand.nextInt(999999999));
        String path1 = "plugins/Clans/clandata/" + Clanid + ".json";
        String ans = checkFile(path1);
        if (ans == "not"){
            String path = "plugins/Clans/clannames/" + name + ".json";
            ans = checkFile(path);
            if (ans == "not") {
                createFile(path1);
                setClanParams(name, Clanid, password, leaderuuid);
                setClanId(leaderuuid, Clanid);
                saveClanName(name, Clanid);
                System.out.println("kurz davor done zu returnen");
                return "done";
            } else {

                return "already";
            }

        }
        return "error";
    }
    public static void createuuidentry(String uuid, String playername){
        String path = "plugins/Clans/uuids/" + playername + ".json";
        String ans = checkFile(path);
        if (ans == "not"){

            createFile(path);
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                jsonObject.put("uuid", uuid);
                FileWriter file = new FileWriter(path);
                file.write(jsonObject.toJSONString());
                file.close();
                System.out.println("Saved UUID");

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }

    }

    public static String getUUID(String playername){
        String path = "plugins/Clans/uuids/" + playername + ".json";
        String ans = checkFile(path);
        if (ans == "exists"){
            JSONParser jsonParser = new JSONParser();
            try {
                JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(path));
                String uuid = (String) jsonObject.get("uuid");

                return uuid;

            }catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


        }
        return "ne diggi";
    }

}

