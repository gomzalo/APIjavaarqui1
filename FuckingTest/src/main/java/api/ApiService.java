package api;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ApiService {
//	ApplicationClass appC = new ApplicationClass();
	
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 @Path("{estadoPiscina}")
 public String estadoPiscina(@PathParam("estadoPiscina") int estadoPiscina) throws IOException {
	 String fcmNotification;
	 String estadoPiscinaS = null;
	 
	 if(estadoPiscina == 1) 
		{
			estadoPiscinaS = "La piscina se lleno.";
		}
		else if(estadoPiscina == 0) 
		{
			estadoPiscinaS = "La piscina se vacio.";
		}
		else
		{
			estadoPiscinaS = "Estado desconocido.";
		}
	 
	 fcmNotification = ApplicationClass.fcm(estadoPiscinaS);
	 return "El estado es: " +  estadoPiscina + ". \nSe envio a FCM: \n" + fcmNotification;
 }
}