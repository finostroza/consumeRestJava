/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumerest;
import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;

import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 *
 * @author Nobel TI
 */
public class ConsumeRest {

    
    public static void main(String[] args) {
        String response= callWS();
        System.out.println("La respuesta del servidor: "+response);
    }
    
    
    public static String callWS() {

		try {

			Client client = Client.create();
                        
                        //Seteo de URL que se consumira (Se recomienda hacer encoding a UTF-8)
			WebResource webResource = client
					.resource("https://swapi.dev/api/people/5/");
			
                        ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}

			String output = response.getEntity(String.class);
			return output;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
