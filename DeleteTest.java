import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DeleteTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		URL url = new URL("http://localhost:50070/webhdfs/v1/user/bijoyan/tutorial1.txt?user.name=bijoyan&op=DELETE");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("DELETE");
		
		Map<String, List<String>> headers = con.getHeaderFields();
		for (String header : headers.keySet())
			System.out.println(header + ": "  + headers.get(header));
	}

}
