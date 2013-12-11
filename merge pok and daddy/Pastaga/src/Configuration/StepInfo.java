package Configuration;

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
public class StepInfo {
    int stepId;
    ArrayList<Door> doors;

    public StepInfo(JSONObject doorInfo) {
        stepId = doorInfo.getInt("stepID");

        JSONArray doors = doorInfo.getJSONArray("doors");
        this.doors =  new ArrayList<Door>(doors.size());
        for (int i = 0; i < doors.size(); i++) {
            this.doors.add(new Door(doors.getJSONObject(i).getFloat("position"),
                    doors.getJSONObject(i).getFloat("size")));
        }
    }

    public String toString() {
        String ret = "[StepInfo]";
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
