//AIzaSyD-7_FcMTcs08fnMGMy_MVEsBdNUej9JP8
package com.example;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.*;
import java.io.PrintWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import clojure.lang.Var;


public class getdistancesAPI {
    private static final String API_KEY="AIzaSyD-7_FcMTcs08fnMGMy_MVEsBdNUej9JP8";
    public static float[][] distances;
    public static String[] cities={"NewYorkCity","NigaraFalls","Albany","Buffalo","Rochester","Syracuse","Yonkers","Utica",
"Ithaca","NewRochelle","MountVernon","WhitePlains","AuburnSt","Newburgh","Binghamton"};
    public static final int n= cities.length;

    //descargar datos
    public static String getdata(String source,String destination) throws Exception{
        String url="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+source+"&destinations="+destination+"&key="+API_KEY;
        HttpRequest request= HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client=HttpClient.newBuilder().build();
        String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        //System.out.println(response);
        return response;
    
    }



    public static String parse(String response) {
        String distance="";
        try {
            JSONParser jp = new JSONParser();
            JSONObject jo = (JSONObject) jp.parse(response);
            JSONArray ja = (JSONArray) jo.get("rows");
            jo = (JSONObject) ja.get(0);
            ja = (JSONArray) jo.get("elements");
            jo = (JSONObject) ja.get(0);
            JSONObject je = (JSONObject) jo.get("distance");
            distance = (String) je.get("text");
        } catch (Exception e) {
            
    }
    return distance;     
}
public static void main(String[] args)throws Exception {
    for (int i = 0; i < n; i++){
        System.out.println("to "+cities[i]+": "+parse(getdata("AuburnSt", cities[i])));
    }

}
/*       
    public static void main(String[] args) throws Exception {
        distances = new float[n][n];
        String parse;
        String string="";
        PrintWriter out =new PrintWriter("distanceMatrix0.csv");
        for (int i = 0; i < n; i++){
            string=string+cities[i]+";";
        }
        string=string+"\n";
        out.print(string);
        string="";
        for (int i = 0; i < n; i++){
            string=string+cities[i]+";";
            for (int j = 0; j < n; j++) {

                if (i != j) {
                   String response = getdata(cities[i], cities[j]);
                   parse=parse(response);
                   string=string+parse+";";
                   //System.out.println("from "+cities[i]+" to "+cities[j]+": "+parse);
                }
                else {
                    distances[i][j] = 0;
                    string=string+"0;";
                }
            }
            System.out.println(i);
            string=string+"\n";
            out.print(string);
            string="";
        }out.close();
        System.out.println("done");
    }*/
}
