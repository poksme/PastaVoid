package Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: poksme
 * Date: 27/11/13
 * Time: 16:35
 * To change this template use File | Settings | File Templates.
 */
public class LevelPart {
    int startBar;
    int endBar;
    Pattern pattern;

    public LevelPart(int startBar, int endBar, Pattern pattern) {
        this.startBar = startBar;
        this.endBar = endBar;
        this.pattern = pattern;
    }

    public String toString() {
        String ret = "[Level Part]";
        ret += " Start Bar: " + startBar + ", End Bar: " + endBar + ", Pattern: " + "\n\t\t\t" + pattern;
        return ret;
    }

    public int getStartBar() {
        return startBar;
    }

    public int getEndBar() {
        return endBar;
    }

    public Pattern getPattern() {
        return pattern;
    }
}
