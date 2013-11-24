class Door {
  int  _position;
  int  _size;
  
  Door(int position, int size) {
    _position = position;
    _size = size;
  }

  String toString() {
    String ret = "[Door]";
    ret += " Position: " + _position + ", Size: " + _size;
    return ret;
  }
}
