package invadem;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import invadem.moving.Moving;
import invadem.moving.Tank;
import invadem.moving.Projectile;
import invadem.AnimationData;

public class ProjectileTest {

  public Projectile me;
  public Projectile inv;

  @Before
  public void setup() {
    Tank tank = new Tank(null, 309, 464, 22, 16, 1, 3, 1);
    me = tank.fireMiddle(null);
    AnimationData sprites = new AnimationData(null, null, null, null, null, null, 1);
    inv = sprites.getSprites().get(0).fire(null, 1, 3, 1);
  }


   @Test
   public void testProjectileConstruction() {
       assertNotNull(me);
       assertNotNull(inv);
   }
}
