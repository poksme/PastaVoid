class Step {
  int              _stepId;
  ArrayList<Door>  _doors;
  
  Step(JSONObject doorInfo) {
    _stepId = doorInfo.getInt("stepID");
    
    JSONArray  doors = doorInfo.getJSONArray("doors");
    _doors =  new ArrayList<Door>(doors.size());
    for (int i = 0; i < doors.size(); i++) {
      _doors.add(new Door(doors.getJSONObject(i).getInt("position"),
                          doors.getJSONObject(i).getInt("size")));
    }
  }
  
  void dump() {
    println("Step Id: " + _stepId);
  }
}
