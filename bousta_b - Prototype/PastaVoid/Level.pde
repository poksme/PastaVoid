import java.util.Map;

class Level {
 String _musicPath;
 String _scriptPath;
 JSONObject _musicScript;
 String _name;
 String _artist;
 float _bpm;
 //ArrayList<String> _patternPaths;
 ArrayList<LevelPart> _patterns;
 HashMap<String, Pattern> _patternLibrary;
  
 Level(String musicPath, String scriptPath) {
   _musicPath = musicPath;
   _scriptPath = scriptPath;
   _musicScript = loadJSONObject("music_script" +  java.io.File.separator + _scriptPath);
   _name = _musicScript.getString("name");
   _artist = _musicScript.getString("artist");
   _bpm = _musicScript.getFloat("bpm");
   _patternLibrary = new HashMap<String, Pattern>();
   
   // Create HashMap with pattern name / pattern object from the patternPaths
   JSONArray patternPaths = _musicScript.getJSONArray("patternPaths");

   /* For each pattern paths, create an entry in the _patternLibrary */
   for (int i = 0; i < patternPaths.size(); i++) {
     /* Load the JsonObject from the pattern path */
     JSONObject patternInfo = loadJSONObject("pattern_script" + java.io.File.separator + patternPaths.getString(i));
      /* Create an entry into the pattern library */
     JSONArray  patterns = patternInfo.getJSONArray("pattern");
     _patternLibrary.put(patternInfo.getString("patternName"), new Pattern(patterns));
   }
   
   /* Load the level part infos with a pointer to the pattern */
   JSONArray patterns = _musicScript.getJSONArray("patterns");
   _patterns = new ArrayList<LevelPart>(patterns.size());
   for (int i = 0; i< patterns.size(); i++) {
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
 
 void dump() {
   println("*// Music Infos //*");
   println("Music Path: " + _musicPath + ", Script Path: " + _scriptPath + ", Name: " + _name + ", Artist: " + _artist + ", BPM: " + _bpm + "\n");
   /*for (int i = 0; i < _patternPaths.size(); i++) {
      println(i + ": " + _patternPaths.get(i));
    }*/
 
   println("*// Level Part //*");
   for (int i = 0; i< _patterns.size(); i++) {
     _patterns.get(i).dump();
   }
 }
}
