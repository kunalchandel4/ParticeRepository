package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub



	
				URL url = new URL(
						"https://script.googleusercontent.com/macros/echo?user_content_key=TgmRYLaE_T39aWdAMUlx78MnXgurxFBr3yVo4C0FSs1QMn92OUzZ91eHWI2WK2YkmFPwHqy0hNg8VbssYtkmN-mcYfe_CgnFm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnGbYC2CNf3dpr8KozQOdOw6si8O2NR6jmjvnUiWtCCNtIh4abtbP6yqqSiVrpc3FHmPz4VVp2dIMU81vRPKlGKr-sw-A6lAJvNz9Jw9Md8uu&lib=MSGFH7C6CvbWwVIA1YgIdGoySpgIVWerd");
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String response = in.lines().collect(Collectors.joining());
				in.close();
			
				for(String s : response.split(""))
				System.out.println(s);
		
		
	}
	
	
	public static void call_me() throws Exception {
		
		
		
		
		String url = "https://script.googleusercontent.com/macros/echo?user_content_key=0fELNCDWIjir2OcE_-9Q4CSgF_-IQVkwxAVGVlgAEWI9NbUOSgnwyCF6WrShIAehh2D_Fo_VD6xWoKx4OOv6TagDiAF41isSm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnGbYC2CNf3dpr8KozQOdOw6si8O2NR6jmjvnUiWtCCNtIh4abtbP6yqqSiVrpc3FHmPz4VVp2dIMU81vRPKlGKr-sw-A6lAJvNz9Jw9Md8uu&lib=MSGFH7C6CvbWwVIA1YgIdGoySpgIVWerd";
		
		HttpRequest conn = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
		
		
		HttpClient cilent=HttpClient.newBuilder().build() ;
		
		
//		HttpResponse<String> res =cilent.send(conn, HttpResponse.BodyHandlers);
		
//		System.out.println(res.body());
//		System.out.println(res.statusCode());
		
		
		
		
		
//	     String url = "http://api.ipinfodb.com/v3/ip-city/?key=d64fcfdfacc213c7ddf4ef911dfe97b55e4696be3532bf8302876c09ebd06b&ip=74.125.45.100&format=json";
//	     URL obj = new URL(url);
//	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//	     // optional default is GET
//	     con.setRequestMethod("GET");
//	     //add request header
//	     con.setRequestProperty("User-Agent", "Mozilla/5.0");
//	     int responseCode = con.getResponseCode();
//	     System.out.println("\nSending 'GET' request to URL : " + url);
//	     System.out.println("Response Code : " + responseCode);
//	     BufferedReader in = new BufferedReader(
//	             new InputStreamReader(con.getInputStream()));
//	     String inputLine;
//	     StringBuffer response = new StringBuffer();
//	     while ((inputLine = in.readLine()) != null) {
//	     	response.append(inputLine);
//	     }
//	     in.close();
//	     //print in String
//	     System.out.println(response.toString());
//	     //Read JSON response and print
//	     JSONObject myResponse = new JSONObject(response.toString());
	     
	   }

}
