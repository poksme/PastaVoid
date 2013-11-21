class Level {
 String _musicPath;
 String _scriptPath; 
  
 Level(String musicPath, String scriptPath) {
   _musicPath = musicPath;
   _scriptPath = scriptPath;
 }
 
 String getMusicPath() {
   return _musicPath;
 }

 String getScriptPath() {
   return _scriptPath;
 }
 
 void dump() {
   println("Music Path: " + _musicPath + ", Script Path: " + _scriptPath + "\n");
 }
}
