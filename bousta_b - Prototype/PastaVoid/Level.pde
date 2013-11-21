

class Level {
 String _musicPath;
 String _scriptPath;
 JSONObject _musicScript;
 String _name;
 String _artist;
 float _bpm;
 ArrayList<String> _patternPaths;
 ArrayList<Pattern> _patterns;
  
 Level(String musicPath, String scriptPath) {
   _musicPath = musicPath;
   _scriptPath = scriptPath;
   _musicScript = loadJSONObject("music_script" +  java.io.File.separator + _scriptPath);
   _name = _musicScript.getString("name");
   _artist = _musicScript.getString("artist");
   _bpm = _musicScript.getFloat("bpm");
   
   // Create HashMap with pattern name / pattern object
   JSONArray patternPaths = _musicScript.getJSONArray("patternPaths");
   _patternPaths = new ArrayList<String>(patternPaths.size());
   for (int i = 0; i < patternPaths.size();i++) {
     _patternPaths.add(patternPaths.getString(i));
   }
   
   JSONArray patterns = _musicScript.getJSONArray("patterns");
   _patterns = new ArrayList<Pattern>(patterns.size());
   for (int i = 0; i< patterns.size(); i++) {
     // Change Pattern to LevelParts and add pointers to pattern objects (stocked in previous hashmap)
     _patterns.add(new Pattern());
   }
 }
 
 String getMusicPath() {
   return _musicPath;
 }

 String getScriptPath() {
   return _scriptPath;
 }
 
 void dump() {
   println("Music Path: " + _musicPath + ", Script Path: " + _scriptPath + ", Name: " + _name + ", Artist: " + _artist + ", BPM: " + _bpm + "\n");
   for (int i = 0; i < _patternPaths.size(); i++) {
      println(i + ": " + _patternPaths.get(i));
    }
 }
}
