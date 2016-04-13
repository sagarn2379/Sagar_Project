package model;
import java.io.Serializable;

public class Application implements Serializable{

private static final long serialVersionUID = 6297385302078200511L;
	
	private String appName;
	private String appDesc;
	private Integer appId;
	private String appKey;
	
	public Integer getID() {
		return appId;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppDesc() {
		return appDesc;
	}
	
	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	@Override
	public String toString() {
		return "Application [appName=" + appName + ", appDesc=" + appDesc + ", appId=" + appId + ", appKey=" + appKey
				+ "]";
	}
	
}
