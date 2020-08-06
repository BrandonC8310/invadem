package invadem.moving;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import invadem.moving.Projectile;

enum State {
  PIC1(true){State change() {return PIC2;} boolean isPic1() {return whichpic;}},
  PIC2(false){State change() {return PIC1;} boolean isPic1() {return whichpic;}};
  boolean whichpic;
  State(boolean whichpic) {this.whichpic = whichpic;}
  abstract State change();
  abstract boolean isPic1();
}

public class Sprites extends Moving {
  private int step = 0;
  private int frame = 0;
  private boolean left = false;
  private boolean powerful;
  private int points;
  public State pic;
  private PImage pic1;
  private PImage pic2;
  private boolean down = false;
  private boolean isGolden = false;
  private int index;
  private int goldentime;


  public Sprites(PImage pic1, PImage pic2,  int x, int y, int width, int height, int level, int HP, int power, boolean powerful, int points, int index) {
      super(pic1, x, y, width, height, level, HP, power);
      this.powerful = powerful;
      this.points = points;
      this.pic1 = pic1;
      this.pic2 = pic2;
      this.pic = State.PIC1;
      this.index = index;
  }

  public int remove(int hit) {
    HP -= hit;
    if (HP <= 0) {
      destroyed = true;
      return points;
    }
    return 0;
  }



  public int getIndex() {
    return index;
  }

  public Projectile fire(PImage p, int a, int b, int c) {
    return new Projectile(p, this.x + 8, this.y + 16, a, b, level, 1, c, false);
  }




  public boolean isPowerful() {
    return powerful;
  }


  public void tick1() {
    this.x -= 1;
    step++;
    if (step == 30) {
      pic = pic.change();
      down = true;
      left = false;
      step = 0;
    }
  }

  public void tick2() {
    this.x += 1;
    step++;
    if (step == 30) {
      pic = pic.change();
      down = true;
      left = true;
      step = 0;
    }
  }


  public void tick3() {
    this.y++;
    step++;
    if (step == 8) {
      pic = pic.change();
      down = false;
      step = 0;
    }
  }

  public void makeItGoldenHeart(PImage goldenHeart) {
    pic1 = goldenHeart;
    pic2 = goldenHeart;
    this.HP = 3;
    this.width = 16;
    this.height = 16;
    this.destroyed = false;
    this.points = -1;
    goldentime = 0;
    this.isGolden = true;
  }

  public void disappear() {
    if (isGolden) {
      this.destroyed = true;
    }
  }

  public boolean isGolden() {
    return isGolden;
  }









  public void draw(PApplet app) {
    if (!destroyed) {
      if (isGolden) {
        goldentime++;
        if (goldentime == 600) {
          this.disappear();
        }
      }
      frame++;
      if (pic.isPic1()) {
        app.image(pic1, x, y, width, height);
      } else {
        app.image(pic2, x, y, width, height);
      }
      if (frame == 2) {
        frame = 0;
        if (down) {
          tick3();
        } else {
          if (left) {
            tick1();
          } else {
            tick2();
          }
        }

      }
    }
  }


}
