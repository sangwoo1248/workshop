import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class RosaPush {
   //https://firebase.google.com/docs/cloud-messaging/downstream 참조
	private static String TAG = "RosaPush";
	private final String API_URL="https://fcm.googleapis.com/fcm/send";
	private String FIREBASE_SERVER_KEY;
	
	private HashMap<String, String> attrMap = new HashMap<String, String>();
	private Map<String, Object> dataMap;
	
	public RosaPush(String serverKey){
		FIREBASE_SERVER_KEY = serverKey;
	}
	public void push(){
		HttpURLConnection con = null;
		try{
			String json = toJson();
			System.out.println("JSON: " + json);
			String url = API_URL;
			
			URL obj = new URL(url);
			con = (HttpURLConnection)obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "key="+FIREBASE_SERVER_KEY);
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			
			DataOutputStream wr= new DataOutputStream(con.getOutputStream());
			wr.writeBytes(json);
			wr.flush();
			wr.close();
			
			con.getResponseCode();
		}catch(Exception e){
			e.printStackTrace();
		}
	}//
	
	public void setTo(String to){
		attrMap.put("to", to);
	}
	public void setData(Map<String, Object> _dataMap){
		dataMap = _dataMap;
	}
	
	public String toJson(){

		JSONObject obj = new JSONObject();
		for(String key : attrMap.keySet()){
			String value = attrMap.get(key);
			obj.put(key,value);
		}
		obj.put("data", dataMap);
		return obj.toString();
	}
	
	
}
