package model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class NotificationData {

    @SerializedName("body")
    private String mBody;
    
    @SerializedName("title")
    private String mTitle;

	@SerializedName("content_available")
    private String mContent_available;
    
    @SerializedName("priority")
    private String mPriority;
    
    public String getBody() {
		return mBody;
	}

	public void setBody(String mBody) {
		this.mBody = mBody;
	}


    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
	
	public String getContent_available() {
		return mContent_available;
	}

	public void setContent_available(String mContent_available) {
		this.mContent_available = mContent_available;
	}

	public String getPriority() {
		return mPriority;
	}

	public void setPriority(String mPriority) {
		this.mPriority = mPriority;
	}

}