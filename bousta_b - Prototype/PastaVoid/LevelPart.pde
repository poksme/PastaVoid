class  LevelPart {
  int      _startBar;
  int      _endBar;
  Pattern  _pattern;
  
  LevelPart(int startBar, int endBar, Pattern pattern) {
    _startBar = startBar;
    _endBar = endBar;
    _pattern = pattern;
  }

  String toString() {
    String ret = "[Level Part]";
    ret += " Start Bar: " + _startBar + ", End Bar: " + _endBar + ", Pattern: " + "\n\t\t\t" + _pattern;
    return ret;
  }
}
