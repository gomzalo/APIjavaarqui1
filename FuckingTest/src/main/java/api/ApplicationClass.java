package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import model.NotificationData;
import model.NotificationRequestModel;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.lang.reflect.Type;


public class ApplicationClass {


    public static String fcm(String estadoPiscina) throws IOException {

    	
        //System.out.println("Bienvenido prroz.");


        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost postRequest = new HttpPost(
                "https://fcm.googleapis.com/fcm/send");

        // we already created this model class.
        // we will convert this model class to json object using google gson library.

        NotificationRequestModel notificationRequestModel = new NotificationRequestModel();
        NotificationData notificationData = new NotificationData();

//        notificationData.setDetail("this is firebase push notification from java client (server)");
        notificationRequestModel.setTo("/topics/Arqui1");
        
        //Llenando notification
        notificationData.setBody(estadoPiscina);
        notificationData.setTitle("Modulo Piscina");
        notificationData.setContent_available("true");
        notificationData.setPriority("high");
        
        //Enviando notification
        notificationRequestModel.setNotification(notificationData);


        Gson gson = new Gson();
        Type type = new TypeToken<NotificationRequestModel>() {
        }.getType();

        String json = gson.toJson(notificationRequestModel, type);

        StringEntity input = new StringEntity(json);
        input.setContentType("application/json");

        // server key of your firebase project goes here in header field.
        // You can get it from firebase console.

        postRequest.addHeader("Authorization", "key=AIzaSyCmvxnrqEFD5nwkH_n4RB-ItWLVFsYwCfI");
        //											AIzaSyCmvxnrqEFD5nwkH_n4RB-ItWLVFsYwCfI
        postRequest.setEntity(input);

        System.out.println("request:" + json);

        HttpResponse response = httpClient.execute(postRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        } else if (response.getStatusLine().getStatusCode() == 200) {

            System.out.println("response:" + EntityUtils.toString(response.getEntity()));
           
        }
        
        return json;
    }
    
}