import com.google.gson.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * This class creates a JsonObject from a specified URL and grabs the data from it.
 */

public class ParseJSON
{
    public static void main(String[] args) throws Exception
    {
        URL sURL = new URL("http://truetime.portauthority.org/bustime/api/v2/getstops?key=N4Y5aCtURdGtkMmbMF2R36PYj&rt=54&dir=INBOUND&format=json");

        // Print keys as a String array
        List keys = getKeysFromJson(sURL);
        System.out.println(keys.size());

        int i = 0;

        /*
        for(Object elem : keys)
        {
            System.out.println(keys.get(i));
            i++;
        }
        */
    }

    static List getKeysFromJson(URL url) throws Exception
    {
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        request.getInputStream()));

        Object things = new Gson().fromJson(in, Object.class);

        List keys = new ArrayList();

        collectAllTheKeys(keys, things);

        request.disconnect();

        return keys;
    }

    static void collectAllTheKeys(List keys, Object o)
    {
        Collection values = null;

        if (o instanceof Map)
        {
            Map map = (Map) o;
            keys.addAll(map.keySet()); // collect keys at current level in hierarchy
            values = map.values();

            System.out.println(o);
        }
        else if (o instanceof Collection)
            values = (Collection) o;

        else // nothing further to collect keys from
            return;

        for (Object value : values)
            collectAllTheKeys(keys, value);
    }
}
