class  LevelPart {
  int      _startBar;
  int      _endBar;
  Pattern  _pattern;
  
  LevelPart(int startBar, int endBar, Pattern pattern) {
    _startBar = startBar;
    _endBar = endBar;
    _pattern = pattern;
  }
  
  void  dump() {
    println("Start Bar: " + _startBar + ", End Bar: " + _endBar + ", Pattern Info: ");
    _pattern.dump();
  }
}
