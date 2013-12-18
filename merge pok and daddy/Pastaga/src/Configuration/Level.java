package Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import processing.core.PApplet;
import processing.data.*;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class Level {
    String musicPath;
    String scriptPath;
    String name;
    String artist;
    int barNumber;
    float bpm;
    int introDelay;
    float playerSpeed;
    ArrayList<LevelPart> patterns;
    HashMap<String, Pattern> patternLibrary;

    public Level(PApplet parent, String musicPath, String scriptPath) {
        JSONObject musicScript = parent.loadJSONObject("music_script/" + scriptPath);
        JSONArray patternPaths = musicScript.getJSONArray("patternPaths");

        this.scriptPath = scriptPath;
        this.musicPath = musicPath;
        name = musicScript.getString("name");
        artist = musicScript.getString("artist");
        bpm = musicScript.getFloat("bpm");
        barNumber = musicScript.getInt("barNumber");
        introDelay = musicScript.getInt("introDelay");
        playerSpeed = musicScript.getFloat("playerSpeed");
        patternLibrary = new HashMap<String, Pattern>(patternPaths.size());

        // Create HashMap with pattern name / pattern object from the patternPaths
   /* For each pattern paths, create an entry in the patternLibrary */
        for (int i = 0; i < patternPaths.size(); i++) {
     /* Load the JsonObject from the pattern path */
            JSONObject patternInfo = parent.loadJSONObject("pattern_script/" + patternPaths.getString(i));
      /* Create an entry into the pattern library */
            patternLibrary.put(patternInfo.getString("patternName"), new Pattern(patternInfo.getJSONArray("pattern")));
        }

   /* Load the level part infos with a pointer to the pattern */
        JSONArray patterns = musicScript.getJSONArray("patterns");
        this.patterns = new ArrayList<LevelPart>(patterns.size());
        for (int i = 0; i < patterns.size(); i++) {
            this.patterns.add(new LevelPart(patterns.getJSONObject(i).getInt("startBar"),
                    patterns.getJSONObject(i).getInt("endBar"),
                    patternLibrary.get(patterns.getJSONObject(i).getString("patternName"))));
        }
    }

    public String toString() {
        String ret = "[Level]";
        ret += " Music Path: " + musicPath + ", Script Path: " + scriptPath + ", Name: " + name + ", Artist: " + artist + ", BPM: " + bpm + ", bar number" + barNumber + ", introDelay" + introDelay + ", Pattern Number: " + patterns.size();
        for (int i = 0; i < patterns.size(); i++) {
            ret += "\n\t\t" + patterns.get(i);
        }
        ret += "\n\t";
        ret += "[Pattern Library]";
        ret += " Library size: " + patternLibrary.size();
        for (Entry<String, Pattern> elem : patternLibrary.entrySet()) {
            ret += "\n\t\t" + "[Key Value Pair]" + " Key: " + elem.getKey() + ", Value:\n\t\t\t" + elem.getValue();
        }
        return ret;
    }

    public String getMusicPath() {
        return musicPath;
    }

    public String getScriptPath() {
        return scriptPath;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public float getBpm() {
        return bpm;
    }
    
    public int getIntroDelay() {
    	return introDelay;
    }

    public ArrayList<LevelPart> getPatterns() {
        return patterns;
    }

    public HashMap<String, Pattern> getPatternLibrary() {
        return patternLibrary;
    }

    public int getBarNumber() {
        return barNumber;
    }
    public boolean hasDoor(int stepID) {
        for (int i = 0; i < patterns.size(); i++) {
            LevelPart tmpLp = patterns.get(i);
            int barId = ((stepID) / 16);
            if (barId >= tmpLp.getStartBar() && barId <= tmpLp.getEndBar()) {
                Pattern tmpPat = tmpLp.getPattern();
                int relativeStepId = ((stepID) % 16);
                for (int j = 0; j < tmpPat.getStepInfos().size(); j++) {
                    if (tmpPat.getStepInfos().get(j).getStepId() == relativeStepId) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public float getPlayerSpeed()
    {
    	return playerSpeed;
    }
    
    public StepInfo getStepInfo(int stepID) {
        for (int i = 0; i < patterns.size(); i++) {
            LevelPart tmpLp = patterns.get(i);
            int barId = (stepID / 16);
            if (barId >= tmpLp.getStartBar() && barId <= tmpLp.getEndBar()) {
                Pattern tmpPat = tmpLp.getPattern();
                int relativeStepId = (stepID % 16);
                for (int j = 0; j < tmpPat.getStepInfos().size(); j++) {
                    if (tmpPat.getStepInfos().get(j).getStepId() == relativeStepId) {
                        return tmpPat.getStepInfos().get(j);
                    }
                }
            }
        }
        return null;
    }
}
