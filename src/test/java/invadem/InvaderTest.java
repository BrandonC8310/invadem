package invadem;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import invadem.moving.Moving;
import invadem.moving.Tank;
import invadem.moving.Projectile;
import invadem.moving.Sprites;
import invadem.AnimationData;

public class InvaderTest {
  public AnimationData sprites;
  public Sprites s1;
  public Sprites s2;
  public Sprites s3;
  public Sprites s4;


  @Before
  public void setup() {
    sprites = new AnimationData(null, null, null, null, null, null, 1);
    s1 = sprites.getSprites().get(0);
    s2 = sprites.getSprites().get(10);
    s3 = sprites.getSprites().get(20);
    s4 = sprites.getSprites().get(30);
    s4.makeItGoldenHeart(null);


  }

   @Test
   public void testInvaderConstruction() {
       assertNotNull(sprites);
       assertNotNull(s1);
       assertNotNull(s2);
       assertNotNull(s3);
       assertNotNull(s4);



   }

   @Test
   public void testInvaderFireProjectile() {
       assertNotNull(s1.fire(null, 1, 3, 1));
       assertNotNull(s2.fire(null, 2, 5, 3));
   }

   @Test
   public void testIsPowerful() {
       assertTrue(s2.isPowerful());
   }

   @Test
   public void testIsGolden() {
       assertTrue(s4.isGolden());
   }

   @Test
   public void testGetIndex() {
       assertEquals(1, s1.getIndex());
       assertEquals(11, s2.getIndex());
       assertEquals(21, s3.getIndex());
       assertEquals(31, s4.getIndex());
   }



   // @Test
   // public void testTick() {
   //     s1
   //     s4.disappear();
   //     assertTrue(s4.destroyed());
   //     assertFalse(s1.destroyed());
   // }

   @Test
   public void testDisappear() {
       s1.disappear();
       s4.disappear();
       assertTrue(s4.destroyed());
       assertFalse(s1.destroyed());
   }


   @Test
   public void testInvaderIsNotDead() {
       assertFalse(s1.destroyed());
   }

   @Test
   public void testInvaderIsDead() {
       s3.remove(1);
       assertTrue(s3.destroyed());
   }
   

}
