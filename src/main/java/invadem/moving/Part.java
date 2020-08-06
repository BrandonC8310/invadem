package invadem.moving;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import invadem.moving.Moving;

public class Part extends Moving {
  private PImage pic1;
  private PImage pic2;
  private PImage pic3;
  private int getHit;
  // private boolean destroyed;

  public Part(PImage pic1, PImage pic2, PImage pic3) {
    super(pic1, 0, 0, 8, 8, 0, 3, 1);
    this.pic1 = pic1;
    this.pic2 = pic2;
    this.pic3 = pic3;
  }

  public void addX(int x) {
    this.x = x;
  }
  public void addY(int y) {
    this.y = y;
  }

  public int remove(int hit) {
    HP -= hit;
    if (HP <= 0) {
      destroyed = true;
    }
    return HP;
  }

  public void draw(PApplet app) {
    if (!destroyed) {
      if (HP == 3) {
        app.image(pic1, x, y, width, height);
      } else if (HP == 2) {
        app.image(pic2, x, y, width, height);
      } else {
        app.image(pic3, x, y, width, height);
      }
    }
  }



}
