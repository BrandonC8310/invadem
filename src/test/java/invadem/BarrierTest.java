package invadem;

import org.junit.Test;
import static org.junit.Assert.*;
import invadem.moving.*;
import invadem.Barrier;
import org.junit.Test;
import org.junit.Before;

public class BarrierTest {
  public Part p;
  public Barrier b;

  @Before
  public void setup() {
    b = new Barrier(202, 435, null, null, null, null, null, null, null, null, null, null, null, null);
    p = b.getComponents().get(0);
  }

   @Test
   public void barrierConstruction() {
       assertNotNull(p);
   }

   @Test
   public void testBarrierNotDestroyed() {
       assertEquals(false, p.destroyed());
   }

   @Test
   public void testBarrierHitPointsMax1() {
     System.out.println(p.getHP());
       assertEquals(3, p.getHP());
   }

   @Test
   public void testBarrierHitPointsMax2() {
       p.remove(1);
       assertEquals(2, p.getHP());
   }

   @Test
   public void testBarrierHitPointsMax3() {
       p.remove(1);
       p.remove(1);
       assertEquals(1, p.getHP());
   }


   @Test
   public void testBarrierIsDestroyed() {
     p.remove(1);
     p.remove(1);
     p.remove(1);
     assertNotNull(b);
   }

}
