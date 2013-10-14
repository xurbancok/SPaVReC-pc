package sk.fiit.remotefiit.interfaces;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import sk.fiit.remotefiit.app.Movement;

public interface Parser {

	List<Movement> parse(JSONObject input) throws JSONException;
}
