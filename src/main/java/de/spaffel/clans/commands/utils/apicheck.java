package de.spaffel.clans.commands.utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class apicheck {


    static public boolean doGet() {
        try {
            HttpURLConnection http = (HttpURLConnection)
                    new URL("http://spaffel.de/clans").openConnection();
            http.setRequestProperty("Accept-Charset", "UTF-8");
            http.setRequestMethod("GET");
            // InputStream aus Verbindung bauen
            InputStream inStream = http.getInputStream();
            // Input-Stream könnte per read in ein Array gelesen
            // werden. Eleganter ist allerdings ein BufferedReader
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inStream));
            // In antwort werden die eingelesenen Zeilen gesammelt
            StringBuffer antwort = new StringBuffer();
            String empfangeneZeile; // für jede Zeile
            // Lese zeilenweise ..,
            while ((empfangeneZeile = in.readLine()) != null) {
                antwort.append(empfangeneZeile + "\n");
            }
            in.close(); // Stream schließen und damit die Verbindung
            System.out.println("antwort:" + antwort.toString());
            if(antwort.toString().contains("yes")){
                System.out.println("antwort:" + antwort.toString());
                return true;
            }else{
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
