package invadem.moving;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;
import invadem.SuperProjectile;

public class Projectile extends Moving{

  private boolean me;
  public Projectile(PImage pic, int x, int y, int width, int height, int level, int HP, int power, boolean me) {
    super(pic, x, y, width, height, level, HP, power);
    this.me = me;
  }

  public void tick1() {
    this.y -= 1;
  }

  public void tick2() {
    this.y += 1;
  }

  public boolean isFriendly() {
    return me;
  }

  public void draw(PApplet app) {
    if (!destroyed) {
      app.image(pic, x, y, width, height);
      if (me) {
        tick1();
      } else {
        tick2();
      }

    }
  }

  public SuperProjectile superFire(PImage p) {
    return new SuperProjectile(p, this.x, this.y);
  }

}
