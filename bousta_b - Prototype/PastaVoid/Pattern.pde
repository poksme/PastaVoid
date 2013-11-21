class Pattern {
  ArrayList<Step>  _steps;
  
  Pattern(JSONArray patterns) {
    _steps = new ArrayList<Step>(patterns.size());
    for (int i = 0; i < patterns.size(); i++) {
      _steps.add(new Step(patterns.getJSONObject(i)));
    }
  }
  
  void dump() {
    println("Contains : " + _steps.size() + " steps");
  }
}
