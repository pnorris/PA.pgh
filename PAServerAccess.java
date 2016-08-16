import com.google.gson.*;
import java.net.URL;
import java.util.Scanner;

public class PAServerAccess extends ParseJSON
{
    final static Scanner input = new Scanner(System.in);

    public void getServerTime() throws Exception
    {
        String sURL = "http://truetime.portauthority.org/bustime/api/v2/gettime?key=N4Y5aCtURdGtkMmbMF2R36PYj&format=json";
        JsonObject json = parseJson(sURL);
        JsonObject bustimeResponse = json.get("bustime-response").getAsJsonObject();

        System.out.println("\nServer Time: " + bustimeResponse.get("tm").getAsString() + "\n");
    }

    public void getRouteInformation() throws Exception
    {
        String sURL = "http://truetime.portauthority.org/bustime/api/v2/getroutes?key=N4Y5aCtURdGtkMmbMF2R36PYj&format=json";
        JsonObject json = parseJson(sURL);
        JsonObject bustimeResponse = json.get("bustime-response").getAsJsonObject();
        JsonArray routes = bustimeResponse.get("routes").getAsJsonArray();

        int i = 0;

        for (JsonElement e : routes)
        {
            JsonObject o = e.getAsJsonObject();

            System.out.println("Index Key: " + i);
            System.out.println("Route Number: " + o.get("rt").getAsString());
            System.out.println("Route Name: " + o.get("rtnm").getAsString());
            System.out.println("Route Color: " + o.get("rtclr").getAsString() + "\n");

            i++;
        }

        int rtSelect;

        System.out.println("Please enter the Index Number for the route requested.");

        rtSelect = input.nextInt();

        int select;

        switch (rtSelect)
        {
            case 0:
                System.out.println("\nYou have selected Route 1: Freeport Road.\n");
                System.out.println("Bulletins in effect: \n"); // call getServiceBulletins()
                System.out.println("What would you like to do?");
                System.out.println("1. Request Stops"); // call getStops()
                System.out.println("2. Request Vehicles"); // call getVehicles()
                System.out.println("3. Request Route Variations");
                System.out.println("4. Main Menu");
                System.out.println("5. Quit");

                select = input.nextInt();

                switch (select)
                {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.exit(0);
                }
                break;
            case 1:
                System.out.println("You have selected Route 2: Mount Royal.");
                break;
            case 2:
        }

    }

    public void getRouteDirections()
    {

    }

    public void getStops()
    {

    }

    public void getVehicles()
    {

    }

    public void getRouteVariations()
    {

    }

    public void getPredictions()
    {

    }

    public void getServiceBulletins()
    {

    }
}
