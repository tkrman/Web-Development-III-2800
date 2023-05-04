


import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

public class JasonFinalExam
{
/** Creates a JsonObject by traversing the arralyList of LinkedHashMap
 * 
 * @param trips ArrayList of LinkedHashMap
 * @return JsonObject
 */
    public static JsonObject createJsonObjectForTrips(ArrayList< LinkedHashMap<String, String>> trips)
    {    
        JsonObjectBuilder jasonBuilder = Json.createObjectBuilder();
        
        for (int i = 0; i < trips.size(); i++) // row
        {
            JsonArrayBuilder jab = Json.createArrayBuilder();
            //System.out.println("ROW " + i + ":");
            JsonObjectBuilder job = Json.createObjectBuilder();

            for (Map.Entry<String, String> mapElement : trips.get(i).entrySet()) // col
            {
                String key = mapElement.getKey();
                String value = mapElement.getValue();
                job.add(key, value);
                //System.out.println("job: " + job.toString());
                //System.out.print(key + " : " + value + " ");
            }
            jab.add(job.build());
            jasonBuilder.add("+" + (i + 1), jab);
            System.out.println("");
        }
        
        
        return jasonBuilder.build();
    }
    public static JsonObject createJsonObjectForTrips(String jsonData)
    {
        JsonReader jsonReader = Json.createReader(new StringReader(jsonData));
        JsonObject o = jsonReader.readObject();
        return o;
    }

    public static LinkedHashMap<String, String> createMapOfTrip(String trip_id, String passenger_name_AM_route, String AM,
            String origination, String destination, String odometer_start, String odometer_end, String trip_time_start,
            String trip_time_end, String type_of_outing, String fare_amount, String fare_amount_collected
    )
    {
        LinkedHashMap<String, String> mapOfTip = new LinkedHashMap<String, String>();
        mapOfTip.put("trip_id", trip_id);
        mapOfTip.put("passenger_name_AM_route", passenger_name_AM_route);
        mapOfTip.put("AM", AM);
        mapOfTip.put("origination", origination);
        mapOfTip.put("destination", destination);
        mapOfTip.put("odometer_start", odometer_start);
        mapOfTip.put("odometer_end", odometer_end);
        mapOfTip.put("trip_time_start", trip_time_start);
        mapOfTip.put("trip_time_end", trip_time_end);
        mapOfTip.put("type_of_outing", type_of_outing);
        mapOfTip.put("trip_time_start", trip_time_start);
        mapOfTip.put("fare_amount", fare_amount);
        mapOfTip.put("fare_amount_collected", fare_amount_collected);

        return mapOfTip;
    }
    public static void main(String a[])
    {
        ArrayList< LinkedHashMap<String, String>> trips = new ArrayList();
        for (int i = 0; i < 2; ++i)
          {
            LinkedHashMap<String, String> oneTrip
                    = createMapOfTrip(
                            Integer.toString(333100 + i + 1),
                            "John Wayne",
                            Boolean.toString(true),
                            "123 Main Street, Lafayette LA",
                            "456 London Street, Lafayette LA",
                            Integer.toString(100),
                            Integer.toString(120),
                            new Date().toString(),
                            new Date().toString(),
                            Integer.toString(1),
                            Integer.toString(10),
                            Integer.toString(10));
            trips.add(oneTrip);
          }
        JsonObject j = createJsonObjectForTrips(trips);
        StringWriter strWtr = new StringWriter();
        JsonWriter jsonWtr = Json.createWriter(strWtr);
        jsonWtr.writeObject(j);
        jsonWtr.close();

        JSONobj.readJASONdataUsingParser(strWtr.toString());
        JsonObject o = createJsonObjectForTrips(strWtr.toString());
        System.out.println("----------------");
        JSONobj.writeObjectModelToStream(o);
    }
}
