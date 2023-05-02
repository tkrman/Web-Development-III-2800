/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans1;

/**
 *
 * @author idont
 */
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonString;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;

import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import static javax.json.Json.createWriter;

@Named(value = "test")
@SessionScoped
public class Test implements Serializable {

    ArrayList< LinkedHashMap<String, String>> suppliers;
    String output = "yello";

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
    
    

    public Test() {

    }
    
    public void buildSuppliersMap() throws SQLException {
        suppliers = Database.getAllSuppliers();

        for (int i = 0; i < suppliers.size(); i++) {
            System.out.println("ROW " + i + ":");
            for (Map.Entry<String, String> mapElement : suppliers.get(i).entrySet()) {
                String key = mapElement.getKey();
                String value = mapElement.getValue();
                System.out.print(key + " : " + value + " ");
            }
            System.out.println("");
        }

    }

    public static JsonObject createJsonObjectForSuppliers(ArrayList< LinkedHashMap<String, String>> suppliers) {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (int i = 0; i < suppliers.size(); i++) // row
        {
            System.out.println("ROW " + i + ":");
            JsonObjectBuilder job = Json.createObjectBuilder();

            for (Map.Entry<String, String> mapElement : suppliers.get(i).entrySet()) // col
            {
                String key = mapElement.getKey();
                String value = mapElement.getValue();
                job.add(key, value);
                //System.out.println("job: " + job.toString());
                System.out.print(key + " : " + value + " ");
            }
            jab.add(job.build());
            System.out.println("");
        }

//        for (LinkedHashMap<String, String> index : suppliers) 
//        {
//            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
//            for (String key : index.keySet()) 
//            {
//                jsonObjectBuilder.add(key, index.get(key));
//            }
//            jab.add(jsonObjectBuilder.build());
//        }
        JsonObjectBuilder jasonBuilder = Json.createObjectBuilder();
        jasonBuilder.add("suppliers", jab);
        return jasonBuilder.build();
        //System.out.println(jason.toString());

    }

    public static String getJasonString(JsonObject jason) {
        StringWriter stringWriter = new StringWriter();
        try ( JsonWriter jsonWriter = Json.createWriter(stringWriter)) {
            jsonWriter.writeObject(jason);
        }
        return stringWriter.toString();
    }

    public static String parseObject(JsonObject jasonObj) {
        JsonParser parser;
        parser = Json.createParser(new StringReader(jasonObj.toString()));
        String s = "";
        while (parser.hasNext()) {
            JsonParser.Event event = parser.next();
            switch (event) {
                case START_ARRAY:
                     s += "\n===============";
                    break;
                case END_OBJECT:
                     s += "\n----------------";
                    break;
                case KEY_NAME:
                    s += "\n" + parser.getString() + " - ";
                    break;
                case VALUE_STRING:
                case VALUE_NUMBER:
                    s += parser.getString() + " ";
                    break;
            }
        }
        return s;
    }
    
    public static String suppliersBean() throws SQLException
    {
        Test test = new Test();
        //ArrayList< LinkedHashMap<String, String>> list = new ArrayList<>();
        test.buildSuppliersMap();
        //System.out.println(suppliers.toString());
        JsonObject testJason = createJsonObjectForSuppliers(test.suppliers);
        //String s = getJasonString(testJason);
        //System.out.println(s);
        return parseObject(testJason);
    }

    public static void main(String[] args) throws SQLException {
        Test test = new Test();
        ArrayList< LinkedHashMap<String, String>> list = new ArrayList<>();
        test.buildSuppliersMap();
        //System.out.println(suppliers.toString());
        JsonObject testJason = createJsonObjectForSuppliers(test.suppliers);
        //String s = getJasonString(testJason);
        //System.out.println(s);
        System.out.println(parseObject(testJason));
        test.setOutput(parseObject(testJason));
    }

}
