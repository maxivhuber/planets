import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;


public class RestController {

    public static ArrayList<Planet> getJson(String s) {
        try {
            //setup https connection

            String base_url = "https://exoplanetarchive.ipac.caltech.edu/cgi-bin/nstedAPI/nph-nstedAPI?";
            s = base_url + s;

            URL url = new URL(s);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                //read GET request
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuffer response = new StringBuffer();
                String output;

                while ((output = in.readLine()) != null) {
                    response.append(output);
                }
                in.close();

                //convert GET request in JSON
                Type planetList = new TypeToken<ArrayList<Planet>>() {
                }.getType();
                ArrayList<Planet> planets = new Gson().fromJson(response.toString(), planetList);
                return new Gson().fromJson(response.toString(), planetList);
            } else
                System.err.println(responseCode);

        } catch (IOException e) {
            System.err.println("Somethin went wrong");
            e.printStackTrace();
        }


        return null;
    }
}
