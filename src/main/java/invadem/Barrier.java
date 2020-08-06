package invadem;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import invadem.moving.Part;

public class Barrier {
  private Part lefttop;

  private Part righttop;

  private Part solid1;
  private Part solid2;
  private Part solid3;
  private Part solid4;

  private Part top;

  private int getHit;

  public Barrier(int x, int y, PImage p1, PImage p2, PImage p3, PImage p4, PImage p5, PImage p6,
  PImage p7, PImage p8, PImage p9, PImage p10, PImage p11, PImage p12) {
    lefttop = new Part(p1, p2, p3);
    righttop = new Part(p4, p5, p6);
    solid1 = new Part(p7, p8, p9);
    solid2 = new Part(p7, p8, p9);
    solid3 = new Part(p7, p8, p9);
    solid4 = new Part(p7, p8, p9);
    top = new Part(p10, p11, p12);

    lefttop.addX(x); lefttop.addY(y);
    righttop.addX(x + 16); righttop.addY(y);
    top.addX(x + 8); top.addY(y);
    solid1.addX(x); solid1.addY(y + 8);
    solid2.addX(x); solid2.addY(y + 16);
    solid3.addX(x + 16); solid3.addY(y + 8);
    solid4.addX(x + 16); solid4.addY(y + 16);
  }

  public List<Part> getComponents() {
    List<Part> ls = new ArrayList<Part>();
    ls.add(lefttop);
    ls.add(righttop);
    ls.add(solid1);
    ls.add(solid2);
    ls.add(solid3);
    ls.add(solid4);
    ls.add(top);
    return ls;
  }

  public void draw(PApplet app) {
    lefttop.draw(app);
    righttop.draw(app);
    solid1.draw(app);
    solid2.draw(app);
    solid3.draw(app);
    solid4.draw(app);
    top.draw(app);
  }
}
