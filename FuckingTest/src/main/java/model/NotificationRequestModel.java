package model;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class NotificationRequestModel {
    
	@SerializedName("to")
    private String mTo;
	
    @SerializedName("notification")
    private NotificationData mNotification;

    public String getTo() {
        return mTo;
    }

    public void setTo(String to) {
        mTo = to;
    }
    
    public NotificationData getNotification() {
		return mNotification;
	}

	public void setNotification(NotificationData mNotification) {
		this.mNotification = mNotification;
	}
	
}