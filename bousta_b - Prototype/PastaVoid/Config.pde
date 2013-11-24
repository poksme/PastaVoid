class Config {
  String _version;
  ArrayList<Level> _levels;

  Config(JSONObject config) {
       _version = config.getString("version");

       JSONArray levels = config.getJSONArray("levels");
       _levels = new ArrayList<Level>(levels.size());
       for (int i = 0; i < levels.size();i++) {
         _levels.add(new Level(levels.getJSONObject(i).getString("music"), 
                               levels.getJSONObject(i).getString("script")));
       }
  }
  
  String getMusicPath(int trackNumber) {
    return _levels.get(trackNumber).getMusicPath();
  }
  
  String getScriptPath(int trackNumber) {
    return _levels.get(trackNumber).getScriptPath();
  }
  
  String toString() {
    String ret = "[Config]";
    ret += " Version: " + _version + ", Level number : " + _levels.size();
    for (int i = 0; i < _levels.size(); i++) {
      ret += "\n\t" + _levels.get(i);
    }
    return ret;
  }
}
