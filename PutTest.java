import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class PutTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:50070/webhdfs/v1/user/bijoyan/tutorial1.txt?user.name=bijoyan&op=APPEND");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setDoInput(true);
		
		FileInputStream fin = new FileInputStream("/home/bijoyan/Documents/append.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fin));
		String line,content="";
		while((line=br.readLine()) != null){
			content+=line;
		}
		
		con.getOutputStream().write(content.getBytes());
		
		Map<String, List<String>> headers = con.getHeaderFields();
		for (String header : headers.keySet())
			System.out.println(header + ": "  + headers.get(header));
	}

}
