import org.multiply.processing.*;

import ddf.minim.spi.*;
import ddf.minim.signals.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import ddf.minim.ugens.*;
import ddf.minim.effects.*;

Minim minim;
AudioPlayer player;
AudioInput input;

float bpm;
float bpms;
boolean poom = false;
PrintWriter debug;

Config config;

private TimedEventGenerator changeColor;
private int lastMillis = 0;

void setup() {
  debug = createWriter("log.txt");
  config = new Config(loadJSONObject("config.json"));
  debug.println(config);
  debug.flush();
  debug.close();
  
  minim = new Minim(this);
  player = minim.loadFile("music" + java.io.File.separator + config.getMusicPath(0));
  
  bpm = 94.f;
  bpms = (bpm / 60.f) / 1000.f;
  changeColor = new TimedEventGenerator(
    this, "onChangeColorEvent", false);
  changeColor.setIntervalMs((int)(1.f / bpms));
  System.out.println("Pas: " + (int)(1.f / bpms));
  changeColor.setEnabled(true);
  input = minim.getLineIn(Minim.STEREO, 1024); 
  player.play();
}

void draw() {
    background(poom ? 255 : 0 );
}

void onChangeColorEvent() {
   System.out.println(poom ? "poom" : "chak");
   poom = !poom;
}

void stop() {
  player.close();
  input.close();
  minim.stop();
  super.stop();
}

