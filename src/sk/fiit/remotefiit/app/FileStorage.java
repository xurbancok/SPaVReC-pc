package sk.fiit.remotefiit.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import sk.fiit.remotefiit.interfaces.DataStorage;

public class FileStorage implements DataStorage {

	@Override
	public Map readData() {
		DataInputStream in;
		Map<String,Map<Movement,Integer>> output = new HashMap<String,Map<Movement,Integer>>();
		try {
			File file = new File("settings.txt");
			if (file.exists() && file.canRead()) {
				FileInputStream fis = new FileInputStream(file);
				String result = convertStreamToString(fis);
				fis.close();
				JSONObject jObject = new JSONObject(result);
				JSONArray jArray = jObject.getJSONArray("profile");
				
				for (int i=0; i < jArray.length(); i++){

						Map<Movement,Integer> profile = new HashMap<Movement,Integer>();
						JSONObject profileJSON = jArray.getJSONObject(i);
						
						String name = profileJSON.getString("name");
						if(profileJSON.has(Movement.MOVE_LEFT.toString())){
							profile.put(Movement.MOVE_LEFT, profileJSON.getInt(Movement.MOVE_LEFT.toString()));
						}
						if(profileJSON.has(Movement.MOVE_RIGHT.toString())){
							profile.put(Movement.MOVE_RIGHT, profileJSON.getInt(Movement.MOVE_RIGHT.toString()));
						}
						if(profileJSON.has(Movement.MOVE_FORWARDS.toString())){
							profile.put(Movement.MOVE_FORWARDS, profileJSON.getInt(Movement.MOVE_FORWARDS.toString()));
						}
						if(profileJSON.has(Movement.MOVE_BACKWARDS.toString())){
							profile.put(Movement.MOVE_BACKWARDS, profileJSON.getInt(Movement.MOVE_BACKWARDS.toString()));
						}
						if(profileJSON.has(Movement.MOVE_UP.toString())){
							profile.put(Movement.MOVE_UP, profileJSON.getInt(Movement.MOVE_UP.toString()));
						}
						if(profileJSON.has(Movement.MOVE_DOWN.toString())){
							profile.put(Movement.MOVE_DOWN, profileJSON.getInt(Movement.MOVE_DOWN.toString()));
						}
						if(profileJSON.has(Movement.LOOK_LEFT.toString())){
							profile.put(Movement.LOOK_LEFT, profileJSON.getInt(Movement.LOOK_LEFT.toString()));
						}
						if(profileJSON.has(Movement.LOOK_RIGHT.toString())){
							profile.put(Movement.LOOK_RIGHT, profileJSON.getInt(Movement.LOOK_RIGHT.toString()));
						}
						if(profileJSON.has(Movement.LOOK_UP.toString())){
							profile.put(Movement.LOOK_UP, profileJSON.getInt(Movement.LOOK_UP.toString()));
						}
						if(profileJSON.has(Movement.LOOK_DOWN.toString())){
							profile.put(Movement.LOOK_DOWN, profileJSON.getInt(Movement.LOOK_DOWN.toString()));
						}
						if(profileJSON.has(Movement.ROTATE_CCW.toString())){
							profile.put(Movement.ROTATE_CCW, profileJSON.getInt(Movement.ROTATE_CCW.toString()));
						}
						if(profileJSON.has(Movement.ROTATE_CW.toString())){
							profile.put(Movement.ROTATE_CW, profileJSON.getInt(Movement.ROTATE_CW.toString()));
						}
						output.put(name, profile);
				}
			}else{
				Map<Movement,Integer> profile = new HashMap<Movement,Integer>();
				profile.put(Movement.MOVE_LEFT, 65);
				profile.put(Movement.MOVE_RIGHT, 68);
				profile.put(Movement.MOVE_UP, 32);
				profile.put(Movement.MOVE_DOWN, 17);
				profile.put(Movement.MOVE_FORWARDS, 38);
				profile.put(Movement.MOVE_BACKWARDS, 40);
				profile.put(Movement.LOOK_LEFT, 37);
				profile.put(Movement.LOOK_RIGHT, 39);
				profile.put(Movement.LOOK_UP, 33);
				profile.put(Movement.LOOK_DOWN, 34);
				output.put("Virtual FIIT", profile);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		reader.close();
		return sb.toString();
	}
	
	
	@Override
	public void storeData(Map<String,Map<Movement,Integer>> mapa) {
		File file = new File("settings.txt");
	    try {
	    	int i = 0;
	        	JSONArray obj = new JSONArray();
	        	JSONObject profileJSON;
	        	List<String> list = new ArrayList<String>(mapa.keySet());

	        	for(String profile : list){
	        		Map<Movement, Integer> item = mapa.get(profile);
	        		i++;
	        		profileJSON = new JSONObject();
	        		profileJSON.put("name", profile);
	        		
	        		if (item.get(Movement.MOVE_LEFT)!=null) profileJSON.put(Movement.MOVE_LEFT.toString(), item.get(Movement.MOVE_LEFT));
	        		if (item.get(Movement.MOVE_RIGHT)!=null) profileJSON.put(Movement.MOVE_RIGHT.toString(), item.get(Movement.MOVE_RIGHT));
	        		if (item.get(Movement.MOVE_UP)!=null) profileJSON.put(Movement.MOVE_UP.toString(), item.get(Movement.MOVE_UP));
	        		if (item.get(Movement.MOVE_DOWN)!=null) profileJSON.put(Movement.MOVE_DOWN.toString(), item.get(Movement.MOVE_DOWN));
	        		if (item.get(Movement.MOVE_FORWARDS)!=null) profileJSON.put(Movement.MOVE_FORWARDS.toString(), item.get(Movement.MOVE_FORWARDS));
	        		if (item.get(Movement.MOVE_BACKWARDS)!=null) profileJSON.put(Movement.MOVE_BACKWARDS.toString(), item.get(Movement.MOVE_BACKWARDS));

	        		if (item.get(Movement.LOOK_LEFT)!=null) profileJSON.put(Movement.LOOK_LEFT.toString(), item.get(Movement.LOOK_LEFT));
	        		if (item.get(Movement.LOOK_RIGHT)!=null) profileJSON.put(Movement.LOOK_RIGHT.toString(), item.get(Movement.LOOK_RIGHT));
	        		if (item.get(Movement.LOOK_UP)!=null) profileJSON.put(Movement.LOOK_UP.toString(), item.get(Movement.LOOK_UP));
	        		if (item.get(Movement.LOOK_DOWN)!=null) profileJSON.put(Movement.LOOK_DOWN.toString(), item.get(Movement.LOOK_DOWN));
	        		if (item.get(Movement.ROTATE_CCW)!=null) profileJSON.put(Movement.ROTATE_CCW.toString(), item.get(Movement.ROTATE_CCW));
	        		if (item.get(Movement.ROTATE_CW)!=null) profileJSON.put(Movement.ROTATE_CW.toString(), item.get(Movement.ROTATE_CW));
	        		obj.put(profileJSON);
	        	}
	        	JSONObject output = new JSONObject();
	        	output.put("profile", obj);
	        	
	            FileWriter filewriter = new FileWriter(file);
	            BufferedWriter out = new BufferedWriter(filewriter);
	            out.write(output.toString());
	            out.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
