package Configuration;

import processing.core.*;
import processing.data.JSONObject;
import processing.data.JSONArray;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 17:03
 * To change this template use File | Settings | File Templates.
 */
public class Config {
    String version;
    ArrayList<Level> levels;

    public Config(PApplet parent) {
    	JSONObject config = parent.loadJSONObject("config.json");
        version = config.getString("version");

        JSONArray levels = config.getJSONArray("levels");
        this.levels = new ArrayList<Level>(levels.size());
        for (int i = 0; i < levels.size();i++) {
            this.levels.add(new Level(parent, levels.getJSONObject(i).getString("music"),
                    levels.getJSONObject(i).getString("script")));
        }
    }

    public String toString() {
        String ret = "[Config]";
        ret += " Version: " + version + ", Level number : " + levels.size();
        for (int i = 0; i < levels.size(); i++) {
            ret += "\n\t" + levels.get(i);
        }
        return ret;
    }

    public String getVersion() {
        return version;
    }

    public ArrayList<Level> getLevels() {
        return levels;
    }
}
