package invadem.moving;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import processing.core.PApplet;
import processing.core.PImage;

public abstract class Moving {
  protected PImage pic;
  protected int x;
  protected int y;
  protected int width;
  protected int height;
  protected boolean destroyed;
  protected int level;
  protected int HP;
  protected int power;

  public Moving(PImage pic, int x, int y, int width, int height, int level, int HP, int power) {
    this.pic = pic;
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.level = level;
    this.HP = HP;
    this.power = power;
    this.destroyed = false;
  }

  public boolean destroyed() {
    return destroyed;
  }

  public int getPower() {
    return power;
  }

  public int getHP() {
    return HP;
  }

  public int remove(int hit) {
    HP -= hit;
    if (this.HP <= 0) {
      destroyed = true;
    }
    return hit;
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public abstract void draw(PApplet app);

}
