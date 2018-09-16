package api;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import twitter.twitter4j;

@Path("/")
public class ApiService {
//	ApplicationClass appC = new ApplicationClass();
	
 @GET
 @Produces(MediaType.TEXT_PLAIN)
 @Path("{estadoPiscina}")
 public String estadoPiscina(@PathParam("estadoPiscina") int estadoPiscina) throws IOException {
	 String fcmNotification;
	 String estadoPublicacionTweet;
	 String estadoPiscinaS;
	 
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
	 System.out.println(estadoPiscinaS);
	 estadoPublicacionTweet = twitter4j.publicarTweet(estadoPiscinaS);
	 System.out.println(estadoPublicacionTweet);
	 return "El estado es: " +  estadoPiscina + ". \nSe envio a FCM: \n" + fcmNotification + "\nTwitter: \n" + estadoPublicacionTweet;
 }
}