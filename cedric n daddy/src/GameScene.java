import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/21/13
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameScene implements IScene {

    private boolean     updated = true;
    private boolean     drawn = true;
    private ArrayList<GameObject>   objects;

    public static void      loadGameScene() {
        SceneManager sm = PastaVoid.pApplet.game.getSceneManager();

        sm.addScene(new GameScene());
    }

    @Override
    public void start() {
    }

    @Override
    public void update() {
        //physics processing
        for (int i = 0; i < this.objects.size(); ++i) {
            if (this.objects.get(i).hasCollider()) {
                //player.testCollision(this.objects.get(i));
            }
        }
        //update processing
        for (int i = 0; i < this.objects.size(); ++i) {
            this.objects.get(i).update();
        }
    }

    @Override
    public void draw() {
        PastaVoid.pApplet.background(255);
        //update draw
        for (int i = 0; i < this.objects.size(); ++i) {
            this.objects.get(i).draw();
        }

    }

    @Override
    public boolean isDrawn() {
        return this.updated;
    }

    @Override
    public boolean isUpdated() {
        return this.drawn;
    }

    @Override
    public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    }

    @Override
    public void setUpdated(boolean updated) {
        this.updated = updated;
    }
}
