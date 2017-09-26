package java_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDGIT {

	public static void main(String[] args) {
		
		try {
			URL dgit = new URL("http://www.dgit.or.kr/login.php");
			URLConnection urlConnection=dgit.openConnection();
			urlConnection.setDoOutput(true);
			
			OutputStreamWriter osw = new OutputStreamWriter(urlConnection.getOutputStream());
			osw.write("user_id=bjj7425&userpasswd=30240035");
			osw.close();
			
			BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
