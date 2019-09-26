import java.util.HashMap;

public class MainTest {
	/* 
	
	*  serverKey = "AAAA-C965wA:APA91bH25MNuAEy-6jEF0ydpuTh1Zgc4NBXpixrQTedW_DOSWccsy9bbON27V0ciD8U1UYutggUpkau6Uw0kmNFD6jaSJ-IkR0nOJfRWD2yAnWTLap4GFMs9SirHpkWYu4JwI2a8HFns";  는
	*  https://console.firebase.google.com/project/gcmtest-146403/settings/general/android:com.androidfcmtest
	*  의  웹 API 키   AAAA-C965wA:APA91bH25MNuAEy-6jEF0ydpuTh1Zgc4NBXpixrQTedW_DOSWccsy9bbON27V0ciD8U1UYutggUpkau6Uw0kmNFD6jaSJ-IkR0nOJfRWD2yAnWTLap4GFMs9SirHpkWYu4JwI2a8HFns  이다.
	*
	*   clientToken = "eafVk5sokcs:APA91bG-JZ8DNQmcYW9VHTKDfhR1AQaEKr57leIEWVlryDxlkIOxOczn8nJndUGjP8ZDD3kS3543Th6Oar5txU5ndvZyTUgN9rPbVqSoMMSp15gg9Ef0KbVKNa8ZE2j5YqU_48gJHKI5";
	*  는 안드로이드 어플 실행시 로그값으로 출력되는 토큰값이다.
	*/
	private static String serverKey = "AAAA-C965wA:APA91bH25MNuAEy-6jEF0ydpuTh1Zgc4NBXpixrQTedW_DOSWccsy9bbON27V0ciD8U1UYutggUpkau6Uw0kmNFD6jaSJ-IkR0nOJfRWD2yAnWTLap4GFMs9SirHpkWYu4JwI2a8HFns";
	private static String clientToken = "eafVk5sokcs:APA91bG-JZ8DNQmcYW9VHTKDfhR1AQaEKr57leIEWVlryDxlkIOxOczn8nJndUGjP8ZDD3kS3543Th6Oar5txU5ndvZyTUgN9rPbVqSoMMSp15gg9Ef0KbVKNa8ZE2j5YqU_48gJHKI5";
	private static RosaPush rosaPush;
	
	public static void main(String[] args) {
		String message = "Hi!!!!";
		
		push(message);
	}
	private static void push(String data){
		if(rosaPush == null){
			rosaPush = new RosaPush(serverKey);
			rosaPush.setTo(clientToken);
		}
		HashMap<String, Object> map =
				new HashMap<String, Object>();
		map.put("contents", data);
		rosaPush.setData(map);
		rosaPush.push();
	}
}
