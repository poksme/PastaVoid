/**
 * Created with IntelliJ IDEA.
 * User: KMU
 * Date: 11/14/13
 * Time: 10:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game {

    private SceneManager    sceneManager;

    void    start() {
        PastaVoid.pApplet.size(800, 600);
        this.sceneManager = new SceneManager();
        this.getSceneManager().start();
//        this.getSceneManager().addScene(new TestScene());
        this.getSceneManager().addScene(new MenuScene());
        //create GameScene
        //create GUiGameScene (GameScene)
    }

    void    update() {
        this.getSceneManager().update();
    }

    void    draw() {
        this.getSceneManager().draw();
    }

    public SceneManager getSceneManager() {
        return sceneManager;
    }
}
