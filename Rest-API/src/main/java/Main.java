import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //documentation https://exoplanetarchive.ipac.caltech.edu/docs/program_interfaces.html#data
        String data_table = "table=exoplanets";
        String data_columns = "&select=pl_name,pl_hostname,ra,dec";
        String order_parameter = "&order=dec";
        String outputfile = "&format=json";

        String requestURL = data_table + data_columns + order_parameter + outputfile;

        ArrayList<Planet> planets = RestController.getJson(requestURL);
        for (Planet p : planets
        ) {
            System.out.println(p.toString());
        }
    }
}
