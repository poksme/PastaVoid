class Pattern {
  ArrayList<Step>  _steps;
  
  Pattern(JSONArray patterns) {
    _steps = new ArrayList<Step>(patterns.size());
    for (int i = 0; i < patterns.size(); i++) {
      _steps.add(new Step(patterns.getJSONObject(i)));
    }
  }
  
  String toString() {
    String ret = "[Pattern]";
    ret += " Steps number: " + _steps.size();
    for (int i = 0; i < _steps.size(); i++) {
      ret += "\n\t\t\t\t" + _steps.get(i);
    }
    return ret;
  }
}
