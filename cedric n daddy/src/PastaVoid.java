import processing.core.PApplet;
import processing.core.PVector;

//public class PastaVoid extends PApplet {
//
//    PVector[]       points;
//    int             sizeX = 50;
//    int             sizeY = 100;
//    int             holeSize = 5;
//    Rect            isoBounds = new Rect(0, 0, 300, 200);
//    float           farPlane = 0.6f;
//    float           nearPlane = 2.0f;
//    float           isoPlanX;
//    public static   PastaVoid   pApplet;
//
//    public void     setup(){
//        pApplet = this;
//        size(800,600);
//        points = new PVector[5];
//        for (int i = 0; i < points.length; ++i) {
//            points[i] = new PVector(random(holeSize * 2, sizeX - holeSize * 2), random(0, sizeY));
//        }
//        isoBounds.x = (width - isoBounds.width) / 2;
//        isoBounds.height = height;
//        isoPlanX = sizeX / 2;
//    }
//
//    public PVector  worldPointToScreenPoint(PVector wpoint) {
//        PVector   spoint = new PVector(wpoint.x, wpoint.y);
//
//        if (key == 'a') {
//            float range = 1.0f - farPlane;
//            float dist = spoint.y / sizeY;
//            range = farPlane + (dist * (nearPlane - farPlane));
//            spoint.x = isoPlanX - (isoPlanX - spoint.x) * (range);
//        }
//        //move it to the iso bounds
//        float   xCoeff = isoBounds.width / sizeX;
//        float   yCoeff = isoBounds.height / sizeY;
//        spoint.x *= xCoeff;
//        spoint.y *= yCoeff;
//        spoint.x += isoBounds.x;
//        spoint.y += isoBounds.y;
//        return spoint;
//    }
//
//    public void     drawLineInScreenPoint(float x, float y, float x1, float y1) {
//        PVector start = worldPointToScreenPoint(new PVector(x, y));
//        PVector end = worldPointToScreenPoint(new PVector(x1, y1));
//
//        line(start.x, start.y, end.x, end.y);
//    }
//
//    public void     draw() {
//        background(255);
//        strokeWeight(5);
//        drawLineInScreenPoint(0, 0, 0, sizeY);
//        drawLineInScreenPoint(sizeX, 0, sizeX, sizeY);
//        for (int i = 0; i < points.length; ++i) {
//            drawLineInScreenPoint(0, points[i].y, points[i].x - holeSize / 2, points[i].y);
//            drawLineInScreenPoint(points[i].x + holeSize / 2, points[i].y, sizeX, points[i].y);
//        }
//    }
//}


public class PastaVoid extends PApplet {

    public static   PastaVoid   pApplet;
    Game            game;

    public void     setup(){
        pApplet = this;
        this.game = new Game();
        this.game.start();
    }

    public void     draw() {
        this.game.update();
        this.game.draw();
    }
}
