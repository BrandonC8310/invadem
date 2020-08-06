package invadem;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import invadem.moving.Moving;
import invadem.moving.Tank;
import invadem.moving.Projectile;

public class TankTest {
  public Tank tank1;
  public Tank tank2;
  public Tank tank3;
  public int x1;
  public int y1;
  public int x2;
  public int y2;


  @Before
  public void setUp() {
    Tank tank1 = new Tank(null, 309, 464, 22, 16, 1, 3, 1);
    this.tank1 = tank1;
    Tank tank2 = new Tank(null, 309, 464, 22, 16, 1, 3, 1);
    this.tank2 = tank2;
    Tank tank3 = new Tank(null, 309, 464, 22, 16, 1, 3, 1);
    this.tank3 = tank3;
    this.x1 = tank1.getX();
    this.x2 = tank2.getX();
    this.y1 = tank1.getY();
    this.y2 = tank2.getY();

  }

  @Before
  public void getHit() {
    tank1.remove(1);
    tank2.remove(1);
    tank2.remove(1);
    tank3.remove(3);
  }


   @Test
   public void testTankConstruction() {
       assertNotNull(tank1);
   }

   @Test
   public void testTankFireMiddleProjectile() {
       assertNotNull(tank1.fireMiddle(null));
   }
   @Test
   public void testTankFireRighteProjectile() {
       assertNotNull(tank1.fireRight(null));
   }
   @Test
   public void testTankFireLeftProjectile() {
       assertNotNull(tank1.fireLeft(null));
   }

   @Test
   public void testTankIsNotDead() {
       assertEquals(false, tank1.destroyed());
   }

   @Test
   public void testTankIsDead() {
       assertEquals(true, tank3.destroyed());
   }


   @Test
   public void testGetHP() {
       assertEquals(2, tank1.getHP());
       assertEquals(1, tank2.getHP());
       assertEquals(0, tank3.getHP());
   }


   @Test
   public void testMoveNormal() {
       tank1.moveLeft();
       assertEquals(x1 - 1, tank1.getX());
       tank1.moveRight();
       assertEquals(x1, tank1.getX());
   }

   @Test
   public void testMoveNormalY() {
     assertEquals(464, tank2.getY());
   }



   @Test
   public void testMoveEdge() {
     for (int i = 1; i <= 160; i++) {
       tank2.moveLeft();
     }
     assertEquals(180, tank2.getX());
   }

   @Test
   public void testMoveEdge2() {
     for (int i = 1; i <= 300; i++) {
       tank2.moveRight();
     }

     assertEquals(438, tank2.getX());
   }


























}
