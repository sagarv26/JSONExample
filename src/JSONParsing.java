import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONParsing {

	public static void main(String[] args) {
		JSONObject json;
		try {
			json = readJsonFromUrl("http://localhost:9000/district/all");
			System.out.println(json.toString()+"\r");
		    
		    JSONArray arr = json.getJSONArray("District");
		    
		    for(int i=0;i<arr.length();i++){
		    	System.out.println("Array ID : "+arr.getJSONObject(i).getInt("id_dist")+" | Array Name : "+arr.getJSONObject(i).getString("district_name"));
		    	System.out.println();
		    }
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

	}
	
	private static String readAll(Reader rd) throws IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String jsonText = readAll(rd);
	      JSONObject json = new JSONObject(jsonText);
	      return json;
	    } finally {
	      is.close();
	    }
	  }

}
