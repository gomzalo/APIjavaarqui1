package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.TwitterException;

public class twitter4j 
{
	public static String publicarTweet(String estadoPiscina) {
		String respuesta = null;
		
		String consumerKey = "iOfjUZK32tbXBGIFGH2y7X827";
		String consumerKeySecret = "5FDUe09McwEEgeB4vv2VOZeZfxe94NJpOko9XyvBnQnz855b6V";

	    String accessToken = "1035248506703884288-YYOzIDkSyYcFvKhVJ1x4bdI0ZYNsI0";
	    String accessTokenSecret = "5PiWP7v41wcXnzLO3yhXHo1ahUAGVBh2vyidcjJuxecce";
// 		..........................................................................................................		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true);
		cb.setOAuthConsumerKey(consumerKey);
		cb.setOAuthConsumerSecret(consumerKeySecret);
		cb.setOAuthAccessToken(accessToken);
		cb.setOAuthAccessTokenSecret(accessTokenSecret);
		
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
// 		..........................................................................................................
// 		..........................................................................................................
		//_____________________________MMMMM________________________________________________________		

	    try {
	      // Getting Twitter Timeline using Twitter4j API
	    
//		ResponseList<Status> statusReponseList = twitter.getUserTimeline(new Paging(1, 5));
//	      for (Status status : statusReponseList) {
//	        System.out.println(status.getText());
//	      }
	      // Post a Tweet using Twitter4j API
	      Status status = twitter.updateStatus(estadoPiscina);
	      System.out.println("Se público exitosamente: [" + status.getText() + "].");
	      respuesta = "Se público exitosamente: [" + status.getText() + "].";
	    } 
	    catch (TwitterException te) 
	    {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
//            System.exit(-1);
        }
	    catch (IllegalStateException ie) 
	    {
		    if(!twitter.getAuthorization().isEnabled()) {
		    	System.out.println("No esta autorizado :v");
		    }        
        }
	    catch (Exception e) 
	    {
	    	
	    }
		//_____________________________MMMMM________________________________________________________
		
		//||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
		
		return respuesta;
	}
}