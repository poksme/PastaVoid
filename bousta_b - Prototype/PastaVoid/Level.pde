import java.util.Map;

class Level {
 String _musicPath;
 String _scriptPath;
 String _name;
 String _artist;
 float _bpm;
 ArrayList<LevelPart> _patterns;
 HashMap<String, Pattern> _patternLibrary;
  
 Level(String musicPath, String scriptPath) {
   JSONObject musicScript = loadJSONObject("music_script" +  java.io.File.separator + scriptPath);
   JSONArray patternPaths = musicScript.getJSONArray("patternPaths");

   _scriptPath = scriptPath;
   _musicPath = musicPath;
   _name = musicScript.getString("name");
   _artist = musicScript.getString("artist");
   _bpm = musicScript.getFloat("bpm");
   _patternLibrary = new HashMap<String, Pattern>(patternPaths.size());
   
   // Create HashMap with pattern name / pattern object from the patternPaths
   /* For each pattern paths, create an entry in the _patternLibrary */
   for (int i = 0; i < patternPaths.size(); i++) {
     /* Load the JsonObject from the pattern path */
     JSONObject patternInfo = loadJSONObject("pattern_script" + java.io.File.separator + patternPaths.getString(i));
      /* Create an entry into the pattern library */
     _patternLibrary.put(patternInfo.getString("patternName"), new Pattern(patternInfo.getJSONArray("pattern")));
   }
   
   /* Load the level part infos with a pointer to the pattern */
   JSONArray patterns = musicScript.getJSONArray("patterns");
   _patterns = new ArrayList<LevelPart>(patterns.size());
   for (int i = 0; i < patterns.size(); i++) {
     _patterns.add(new LevelPart(patterns.getJSONObject(i).getInt("startBar"),
                                 patterns.getJSONObject(i).getInt("endBar"),
                                 _patternLibrary.get(patterns.getJSONObject(i).getString("patternName"))));
   }
 }
 
 String getMusicPath() {
   return _musicPath;
 }

 String getScriptPath() {
   return _scriptPath;
 }
 
 String toString() {
    String ret = "[Level]";
    ret += " Music Path: " + _musicPath + ", Script Path: " + _scriptPath + ", Name: " + _name + ", Artist: " + _artist + ", BPM: " + _bpm + ", Pattern Number: " + _patterns.size();
    for (int i = 0; i < _patterns.size(); i++) {
      ret += "\n\t\t" + _patterns.get(i);
    }
   ret += "\n\t";
   ret += "[Pattern Library]";
   ret += " Library size: " + _patternLibrary.size();
   for (Map.Entry elem : _patternLibrary.entrySet()) {
      ret += "\n\t\t" + "[Key Value Pair]" + " Key: " + elem.getKey() + ", Value:\n\t\t\t" + elem.getValue();
    }
    return ret;
  }
}
