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
    ArrayList<StepInfo> stepInfos;

    public Pattern(JSONArray patterns) {
        stepInfos = new ArrayList<StepInfo>(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            stepInfos.add(new StepInfo(patterns.getJSONObject(i)));
        }
    }

    public String toString() {
        String ret = "[Pattern]";
        ret += " Steps number: " + stepInfos.size();
        for (int i = 0; i < stepInfos.size(); i++) {
            ret += "\n\t\t\t\t" + stepInfos.get(i);
        }
        return ret;
    }

    public ArrayList<StepInfo> getStepInfos() {
        return stepInfos;
    }
}
