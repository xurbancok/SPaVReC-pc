package sk.fiit.remotefiit.app;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import sk.fiit.remotefiit.interfaces.Parser;

public class JSONParser implements Parser{

	private List<Movement> result;
	
	public JSONParser(){
		result = new ArrayList<Movement>();
	}

	public List<Movement> parse(JSONObject input) throws JSONException {
		result.clear();
		String[] movements = input.getString("MOVE").replace("[","").replace("]","").split(",");
		for(String s: movements){
			
			try{
				Movement move = Movement.valueOf(s.trim());
				result.add(move);
			}catch(IllegalArgumentException e){
				
			}
		}
		return result;
	}

}
