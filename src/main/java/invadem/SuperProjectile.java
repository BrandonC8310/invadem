package invadem;
import java.util.List;
import java.util.ArrayList;

import processing.core.PImage;
import processing.core.PApplet;
import invadem.moving.Projectile;




public class SuperProjectile {


  public static class Super extends Projectile {

    private int[] velocity;
    private int stepX;
    private int stepY;


    public Super(PImage pic, int x, int y, int width, int height, int level, int HP, int power, boolean me, int[] velocity) {
      super(pic, x, y, width, height, level, HP, power, me);
      this.velocity = velocity;
      stepX = 0;
      stepY = 0;
    }

    public void tickX() {
      this.x += velocity[0];
      stepX += Math.abs(velocity[0]);
      if (stepX >= 100) {
        this.remove(1);
      }
    }

    public void tickY() {
      this.y += velocity[1];
      stepY += Math.abs(velocity[1]);
      if (stepY >= 50) {
        this.remove(1);
      }
    }

    public void draw(PApplet app) {
      if (!destroyed) {
        app.image(pic, x, y, width, height);
        tickX();
        tickY();
        }
    }

  }

  private List<Super> superProjectiles;


  public SuperProjectile(PImage pic, int x, int y) {
    superProjectiles = new ArrayList<Super>();
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {0, -1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {-2, -1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {2, -1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {-1, -1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {1, -1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {-1, 0}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {1, 0}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {2, 1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {-2, 1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {1, 1}));
    superProjectiles.add(new Super(pic, x, y, 2, 5, 1, 1, 1, true, new int[] {-1, 1}));

  }

  public List<Super> getSuperProjectiles() {
    return superProjectiles;
  }







}
