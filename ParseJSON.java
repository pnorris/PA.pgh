import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.*;
import com.oracle.javafx.jmx.json.JSONException;

public class ParseJSON
{
    public static JsonObject parseJson(String sURL) throws IOException, JSONException
    {
        JsonObject json = readJsonFromUrl(sURL);

        /*
        System.out.println(json.toString());

        JsonObject bustimeResponse = json.get("bustime-response").getAsJsonObject();
        JsonArray stops = bustimeResponse.get("stops").getAsJsonArray();
        JsonObject stop0 = stops.get(0).getAsJsonObject();

        System.out.println(bustimeResponse.get("stops"));
        System.out.println(stops.get(0));
        System.out.println(stop0);
        System.out.println(stop0.get("stpid").getAsString());
        System.out.println(stop0.get("stpnm").getAsString());
        System.out.println(stop0.get("lat").getAsDouble());
        System.out.println(stop0.get("lon").getAsDouble());
        */

        return json;
    }

    private static JsonObject readJsonFromUrl(String sURL) throws IOException, JSONException {

        URL url = new URL(sURL);
        URLConnection myURLConnection = url.openConnection();
        myURLConnection.connect();
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        String jsonText = readAll(reader);
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonText).getAsJsonObject();

        return json;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}
