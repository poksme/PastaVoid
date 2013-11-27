package Config;

import processing.data.JSONArray;
import processing.data.JSONObject;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class Step {
    int stepId;
    ArrayList<Door> doors;

    public Step(JSONObject doorInfo) {
        stepId = doorInfo.getInt("stepID");

        JSONArray doors = doorInfo.getJSONArray("doors");
        this.doors =  new ArrayList<Door>(doors.size());
        for (int i = 0; i < doors.size(); i++) {
            this.doors.add(new Door(doors.getJSONObject(i).getInt("position"),
                    doors.getJSONObject(i).getInt("size")));
        }
    }

    public String toString() {
        String ret = "[Step]";
        ret += " ID: " + stepId;
        for (int i = 0; i < doors.size(); i++) {
            ret += "\n\t\t\t\t\t" + doors.get(i);
        }
        return ret;
    }

    public int getStepId() {
        return stepId;
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }
}
