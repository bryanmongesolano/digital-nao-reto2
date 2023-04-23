/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Modelo {
    
    private String busqueda;
    private String respuesta;

    public String getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public void buscar() throws MalformedURLException, IOException{
       URL url = new URL("https://serpapi.com/search?api_key=29a7dc05177d29d6d869ac00ad169c22c0e1c7e1fbee75e666040b65b0fa5e0d&engine=google_scholar&q=mi_busqueda");
       HttpURLConnection con = (HttpURLConnection) url.openConnection();
       con.setRequestMethod("GET");
       int status = con.getResponseCode();
       BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
       String inputLine;
       StringBuffer content = new StringBuffer();
       while ((inputLine = in.readLine()) != null) {
           content.append(inputLine);
       }
       in.close();
       con.disconnect();
       this.respuesta = content.toString();
       
       String uglyJson = "{\"_id\":\"613215d0899cb431ba05722d\",\"index\":0,\"guid\":\"000f4832-57b3-4489-8b69-1b69d3b74af5\",\"isActive\":false,\"balance\":\"$3,266.13\",\"age\":27,\"eyeColor\":\"blue\",\"name\":\"Franks Hoffman\"}";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(uglyJson);
        String prettyJson = gson.toJson(jsonElement);
        System.out.println(prettyJson);
    }
}
