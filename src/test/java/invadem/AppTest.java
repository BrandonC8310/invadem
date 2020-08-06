package invadem;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import java.awt.event.KeyEvent;
import invadem.moving.Moving;
import invadem.moving.Tank;
import invadem.moving.Projectile;
import invadem.moving.Sprites;
import invadem.AnimationData;
import invadem.Barrier;
import invadem.SuperProjectile;
import invadem.SuperProjectile.Super;
import invadem.moving.Part;
import invadem.App;


public class AppTest extends App {

  public static String[] arr1;
  public static String[] arr2;
  public List<Tank> tank;
  public static App app;
  public PImage p;
  public List<Projectile> projectiles;
  public List<Projectile> projectiles1;
  public List<Projectile> invademprojectiles;
  public Sprites s1;
  public Sprites s2;
  public AnimationData sprites;
  public List<SuperProjectile> superProjectiles;

  public Sprites s3;
  public Sprites s4;
  public List<Super> superclass;



  @Before
  public void setup() {
    app = new App();
    this.app = app;
    arr1 = new String[]{"--location=0,0", "App"};
    PApplet.runSketch(arr1, app);
    delay(2000);


  }


  // @Before
  // public void run1() {
  //   p = loadImage("tank1.png");
  //   this.p = p;
  // }

  @Before
  public void run() {
    tank = new ArrayList<Tank>();
    tank.add(new Tank(null, 309, 464, 22, 16, 1, 3, 1));
    tank.add(new Tank(null, 309, 464, 22, 16, 1, 3, 1));
    arr2 = new String[]{"--location=0,0", "Tank"};
    this.tank = tank;
    this.projectiles = new ArrayList<Projectile>();
    this.projectiles1 = new ArrayList<Projectile>();
    this.invademprojectiles = new ArrayList<Projectile>();
    this.superProjectiles = new ArrayList<SuperProjectile>();
    this.superclass = new ArrayList<Super>();
    this.sprites = new AnimationData(null, null, null, null, null, null, 1);
    this.s1 = sprites.getSprites().get(0);
    sprites.getSprites().get(10).makeItGoldenHeart(null);
    projectiles.add(tank.get(0).fireMiddle(null));
    invademprojectiles.add(s1.fire(null, 1,2,3));
    invademprojectiles.get(0).tick2();
    projectiles.get(0).tick1();
    superProjectiles.add(projectiles.get(0).superFire(null));
    superclass = superProjectiles.get(0).getSuperProjectiles();

    s3 = sprites.getSprites().get(20);
    s4 = sprites.getSprites().get(30);
    s4.makeItGoldenHeart(null);
  }

  @Before
  public void check_collision() {

    for (int i = 1; i < 150; i ++) {
      tank.get(0).moveLeft();
    }

    for (int i = 1; i <= 10; i++) {
      tank.get(1).moveRight();
      projectiles1.add((tank.get(1).fireLeft(null)));
    }
    projectiles.add((tank.get(0).fireLeft(null)));
    projectiles.add((tank.get(0).fireLeft(null)));
    projectiles.add((tank.get(0).fireLeft(null)));

    for (int i = 1; i < 456; i++) {
      projectiles.get(1).tick1();
      projectiles.get(2).tick1();
      projectiles.get(3).tick1();
    }

    List<Integer> ls = new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
      ls.add(i);
    }
    //superFire(ls);

  }

  @Before
  public void check_superFire() {
  //   for (int i = 1; i <= 10; i++) {
  //     tank.get(1).moveRight();
  //
  //   }
}

@Test
public void testApp() {
    assertNotNull(app);
}

@Test
public void testProjectileIsFriendly() {
    assertTrue(projectiles.get(0).isFriendly());
}

@Test
public void testProjectileIsNotFriendly() {
    assertFalse(invademprojectiles.get(0).isFriendly());
}
  @Test
  public void testCollision() {
    for (int i = 1; i <= 30; i++) {
      for (Sprites s : sprites.getSprites()) {
        s.tick2();
      }
    }
    assertEquals(false, detectCollision(projectiles.get(0), s1));
    assertEquals(true, detectCollision(projectiles.get(1), s1));
  }

  @Test
  public void testCollision2() {

      for (int i = 1; i <= 30; i++) {
        for (Sprites s : sprites.getSprites()) {
          s.tick2();
        }
      }
    assertEquals(250, collision(sprites.getSprites(), projectiles));
  }

  @Test
  public void testSpriteTick() {
    for (int i = 1; i <= 30; i++) {
      for (Sprites s : sprites.getSprites()) {
        s.tick1();
      }
    }
    for (int i = 1; i <= 8; i++) {
      for (Sprites s : sprites.getSprites()) {
        s.tick3();
      }
    }

    //assertEquals(0, collision(sprites.getSprites(), projectiles));
  }

  @Test
  public void testADaverageY() {
    assertEquals(48, sprites.getAverageY());
  }

  @Test
  public void testADDeadNum() {
    sprites.getSprites().get(30).makeItGoldenHeart(null);
    sprites.getSprites().get(30).disappear();
    assertTrue(sprites.deadNum(1));
  }

  @Test
  public void testADFindSprite() {
    sprites.getSprites().get(30).makeItGoldenHeart(null);
    sprites.getSprites().get(30).disappear();
    assertEquals(1, sprites.getDesctoyed());
    assertEquals(s4, sprites.findThisSprite(1));
  }

  @Test
  public void testNotNull() {
    assertNotNull(tank.get(0));
  }

  @Test
  public void testSPsNotNull() {
    assertNotNull(superProjectiles);
  }

  @Test
  public void testSPNotNull() {
    assertNotNull(superProjectiles.get(0));
  }

  @Test
  public void testSPTick() {
    for (int i = 0; i < 105; i++) {
      superProjectiles.get(0).getSuperProjectiles().get(1).tickX();
      superProjectiles.get(0).getSuperProjectiles().get(0).tickY();
    }
    assertTrue(superProjectiles.get(0).getSuperProjectiles().get(0).destroyed());
  }

  @Test
  public void testSuper() {
      for (Super su : superclass) {
          assertNotNull(su);
      }
  }

  @Test
  public void testNotNull1() {
    assertNotNull(projectiles);
  }

  @Test
  public void testNotNull2() {
  for (Projectile p : projectiles) {
    assertNotNull(p);
  }
  }

  @Test
  public void testNotNull3() {
    assertNotNull(s1);
  }
  @Test
  public void testNotNull4() {
    assertNotNull(invademprojectiles.get(0));
  }
  @Test
  public void testNotNull5() {
    assertNotNull(invademprojectiles);
  }
  @Test
  public void testNotNull6() {
    assertNotNull(sprites);
  }






}
