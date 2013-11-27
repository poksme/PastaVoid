package Config;

import processing.data.JSONArray;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:34
 * To change this template use File | Settings | File Templates.
 */
public class Pattern {
    ArrayList<Step> steps;

    public Pattern(JSONArray patterns) {
        steps = new ArrayList<Step>(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            steps.add(new Step(patterns.getJSONObject(i)));
        }
    }

    public String toString() {
        String ret = "[Pattern]";
        ret += " Steps number: " + steps.size();
        for (int i = 0; i < steps.size(); i++) {
            ret += "\n\t\t\t\t" + steps.get(i);
        }
        return ret;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }
}
