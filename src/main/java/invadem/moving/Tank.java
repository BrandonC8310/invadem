package invadem.moving;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import invadem.moving.Projectile;

public class Tank extends Moving{


  public Tank(PImage pic, int x, int y, int width, int height, int level, int HP, int power) {
      super(pic, x, y, width, height, level, HP, power);
  }

  public void moveLeft() {
    if (this.x >= 181) {
        this.x -= 1;
    }
  }

  public int getHP() {
    return this.HP;
  }


  public void moveRight() {
    if (this.x <= 437) {
        this.x += 1;
      }
  }

  public Projectile fireMiddle(PImage p) {
    return new Projectile(p, this.x + 11, this.y, 1, 3, level, 1, 1, true);
  }
  public Projectile fireLeft(PImage p) {
    return new Projectile(p, this.x, this.y, 1, 3, level, 1, 1, true);
  }
  public Projectile fireRight(PImage p) {
    return new Projectile(p, this.x + 22, this.y, 1, 3, level, 1, 1, true);
  }

  public void draw(PApplet app) {
    if (!destroyed) {
      app.image(pic, x, y, width, height);
    }
  }
}
