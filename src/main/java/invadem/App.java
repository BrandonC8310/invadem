package invadem;
import java.util.List;
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
import java.util.Arrays;

public class App extends PApplet {
  protected static PImage p1; PImage p2; PImage p3; PImage p4; PImage p5; PImage p6;
  protected PImage p7; PImage p8; PImage p9; PImage p10; PImage p11; PImage p12;
  protected static List<Projectile> projectiles;
  protected static List<Projectile> invademProjectiles;
  protected static List<SuperProjectile> superProjectiles;
  protected boolean left;
  protected boolean right;
  protected boolean generated;
  protected int win_time;
  protected int lose_time;
  protected static int level = 1;
  protected AnimationData sprites;
  protected boolean loaded;
  protected boolean fire;
  protected int frame;
  protected int num;
  protected static List<Barrier> barriers;
  protected boolean win;
  protected boolean gua;
  protected boolean lose;
  protected boolean guaLose;
  protected static List<Tank> tank;
  protected static int highest_score = 10000;
  protected static int current_score = 0;
  protected List<Integer> index;
  protected int random;
  protected boolean shoot;
  protected PImage heart;
  protected PImage projectilePic;
  protected PImage projectilePicY;
  protected PImage golden;
  protected PImage projectilePicLg;
  protected int randomG;
  protected static int goldnum = 0;
  protected int goldentime;
  protected boolean guaG;
  protected boolean addG;
  protected boolean saving;
  protected int counter;
  protected boolean superMode;
  protected boolean onit;
  protected int timer;
  protected int randomNum;
  protected int goldenCountDownFrame;
  protected int goldenCountDownNum;
  protected boolean goldenCountDown;
  protected boolean stopped1;
  protected boolean stopped2;
  protected boolean stopped3;
  protected boolean goldenHeartInto;
  protected int superModeCountDownFrame;
  protected int superModeCountDownNum;
  protected boolean superModeCountDown;
  protected boolean hit1;
  protected boolean hit2;
  protected boolean blood;
  protected int bloodCounter;
  protected int bloodTime;
  protected boolean had;
  protected static boolean firstTimeG = true;
  protected static boolean firstTimeH = true;
  protected boolean superFireUp;
  protected boolean superFireNow;
  protected boolean superFire;
  protected int superFireLevelIndex;
  protected int[] superFireLevel;
  protected boolean dead;
  protected boolean saved;
  protected boolean showSuperFire;
  protected int showSuperFireTime;
  protected boolean firstTime50;
  protected boolean backgroundYellowChange;
  protected int superFireCounter;
  protected int backgroundYellowChangeTime;

  public App() {}

  public void setup() {
    frameRate(60);
    fill(255);
    tank = new ArrayList<Tank>();
    tank.add(new Tank(loadImage("tank1.png"), 309, 464, 22, 16, level, 3, 1));
    sprites = new AnimationData(loadImage("invader1.png"), loadImage("invader1_armoured.png"), loadImage("invader1_power.png"), loadImage("invader2.png"), loadImage("invader2_armoured.png"), loadImage("invader2_power.png"), level);
    projectiles = new ArrayList<Projectile>();
    invademProjectiles = new ArrayList<Projectile>();
    barriers = new ArrayList<Barrier>();
    superProjectiles = new ArrayList<SuperProjectile>();
    fire = false;
    loaded = true;
    win_time = 0;
    lose_time = 0;
    win = false;
    frame = 0;
    lose = false;
    gua = false;
    index = new ArrayList<Integer>();
    random = 0;
    shoot = false;
    heart = loadImage("heart.png");
    projectilePic = loadImage("projectile.png");
    projectilePicY = loadImage("projectileY.png");
    projectilePicLg = loadImage("projectile_lg.png");
    randomG = (int) this.random(1, 39);
    System.out.println("golden!" + String.valueOf(randomG));
    golden = loadImage("goldenheart.png");
    generated = false;
    goldentime = 0;
    guaLose = false;
    guaG = false;
    addG = true;
    saving = false;
    superMode = false;
    counter = 0;
    onit = false;
    timer = 0;
    goldenCountDownFrame = 0;
    goldenCountDownNum = 9;
    superModeCountDownFrame = 0;
    superModeCountDownNum = 15;
    randomNum = 0;
    goldenCountDown = false;
    stopped1 = false;
    stopped2 = false;
    stopped3 = false;
    goldenHeartInto = false;
    superModeCountDown = false;
    hit1 = false;
    hit2 = false;
    blood = false;
    bloodTime = 0;
    bloodTime = 0;
    had = false;
    superFireUp = false;
    superFireNow = true;
    superFireLevel = new int[] {5, 2, 1};
    superFire = false;
    superFireLevelIndex = -1;
    dead = false;
    saved = false;
    showSuperFire = false;
    showSuperFireTime = 0;
    firstTime50 = true;
    backgroundYellowChange = false;
    superFireCounter = 0;
    backgroundYellowChangeTime = 0;
    p1 = loadImage("barrier_left1.png");
    p2 = loadImage("barrier_left2.png");
    p3 = loadImage("barrier_left3.png");
    p4 = loadImage("barrier_right1.png");
    p5 = loadImage("barrier_right2.png");
    p6 = loadImage("barrier_right3.png");
    p7 = loadImage("barrier_solid1.png");
    p8 = loadImage("barrier_solid2.png");
    p9 = loadImage("barrier_solid3.png");
    p10 = loadImage("barrier_top1.png");
    p11 = loadImage("barrier_top2.png");
    p12 = loadImage("barrier_top3.png");
    barriers.add(new Barrier(204, 435, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
    barriers.add(new Barrier(308, 435, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
    barriers.add(new Barrier(413, 435, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12));
  }

  // Set the size of screen
  public void settings() {
      size(640, 480);
  }

  // Print out the current and highest score
  public void printScore() {
    if (onit) {
      fill(248,234,79);
    } else if (goldenCountDown || showSuperFire) {
      fill(255);
    }
    textFont(createFont(("PressStart2P-Regular.ttf"), 16));
    text("Score:", 10,20);
    text("Highest:",510, 20);
    String h = String.valueOf(highest_score);
    text(h,510, 44);
    String s = String.valueOf(current_score);
    text(s,10, 44);
  }


  // Print out the current level
  public void printLevel() {
    if (onit) {
      fill(248,234,79);
    } else if (goldenCountDown || showSuperFire) {
      fill(255);
    }
    textFont(createFont(("PressStart2P-Regular.ttf"), 16));
    text("LEVEL", 10, 470);
    String l = String.valueOf(level);
    text(l, 90, 470);
  }


  // Detect whether the player wins or not
  // in the draw loop
  // be called everytime
  // show "next level" for 120 frames
  public void detectWin() {
    if (sprites.getDesctoyed() == 40) {
      win = true;
    }
    if (win) {
      PImage p = loadImage("nextlevel.png");
      this.image(p, 259, 232, p.width, p.height);
      win_time++;
      if (win_time == 120) {
        afterWin();
      }
    }
  }


  // Change states and reset after winning
  public void afterWin() {
    levelUp();
    noLoop();
    setup();
    loop();
  }

  // Level up
  public void levelUp() {
    this.level++;
  }


  // Determine whether the player is dead
  public boolean doIlose() {
    if (sprites.doIlose() || tank.get(0).destroyed()) {
      blood = true; // Invole getHit()
      return true;
    }
    return false;
  }

  // Detect whether the player loses or not
  // in the draw loop
  // be called everytime
  // If the player has a golden heart, it can save their lifes
  // Show some info after death, if they really are dead,
  // show "game over" for 120 frames
  public void detectLose() {
    if (dead) {
      if (goldnum > 0) {
        if (saved) {
          saveMyLife();
          saved = true;
        }
        if (!stopped3 && !saved) {
          noLoop();
          fill(248,234,79);
          textFont(createFont(("PressStart2P-Regular.ttf"), 12));
          text("You are dead!", 130, 195);
          text("Luckly you got a gloden heart",130, 220);
          text("Press [Y] to have one more time", 130, 245);
          fill(255);
          stopped3 = true;
          saved = true;
        }
        if (!dead) {
          saved = false;
        }
      } else {
        lose = true;
        PImage p = loadImage("gameover.png");
        this.image(p, 259, 232, p.width, p.height);
        lose_time++;
        if (lose_time == 120) {
          afterLose();
        }
      }
    }
  }

  // Reset after losing
  public void afterLose() {
    noLoop();
    setup();
    if (current_score >= highest_score) {
      highest_score = current_score;
    }
    current_score = 0;
    level = 1;
    loop();
  }



  // Override the keyPressed() method
  // Store information of the change of key status
  public void keyPressed() {
    keyPressed = true;
    if (this.keyCode == KeyEvent.VK_LEFT) {
        left = true;
    }
    if (this.keyCode == KeyEvent.VK_RIGHT) {
        right = true;
    }
    if (this.key == '\n') {
      if (goldnum > 0 && !onit) {
        superMode = true;
        goldnum--;
      }
    }
    if (this.key == 's') {
      superFireUp = true;
    }
    if (this.key == 'a') {
        gua = true; // Directly to win (for me to test)
    }
    if (this.key == 'z') {
        guaLose = true; // Directly to lose (for me to test)
    }
    if (this.key == 'g') {
        guaG = true; // Genereate a golden heart (for me to test)
    }
    if (this.key == ' ') {
        fire = true;
    }
    if (this.key == 'y') {
      loop();
    }
  }


  // Override the keyReleased() method
  // Store information of the change of key status
  public void keyReleased() {
    keyPressed = false;
    if (this.keyCode == KeyEvent.VK_LEFT) {
        left = false;
    }
    if (this.keyCode == KeyEvent.VK_RIGHT) {
        right = false;
    }
    if (this.key == 'g') {
        addG = true;
        guaG = false;
    }
    if (this.key == ' ') {
      loaded = true;
        fire = false;
     }
     if (this.key == 's') {
       superFireNow = true;
       superFireUp = false;
     }
  }


  // Detect the keys pressed by the player each frame
  public void detectKey() {
    // Tank fires a projectile
    if (fire && loaded) {
      // This is under the "Super Mode"
      if (onit) {
      projectiles.add(tank.get(0).fireLeft(projectilePicY));
      projectiles.add(tank.get(0).fireMiddle(projectilePicY));
      projectiles.add(tank.get(0).fireRight(projectilePicY));
      } else {
      // Tank fires a regular projectile
      projectiles.add(tank.get(0).fireMiddle(projectilePic));
      }
      // This is a "Super Fire"
      random = (int) this.random(1, randomNum + 1); // The probability of firing a Super Fire
      if (random == 1 && superFire) { // if super fire starts
        index.add(projectiles.size() - 1);// The index of this Super Fire projectile
        superFire(index); // This is the method that makes this particular projectile a Super Fire
      }
      loaded = false;
      }
      // Tank moves to left
      if (left) {
        tank.get(0).moveLeft();
      }
      // Tank moves to right
      if (right) {
        tank.get(0).moveRight();
      }
      // Super Mode begins
      if (superMode) {
        // Invoke the creation of superMode Projectiles
        // Make every text yellow
        // Invoke superModeCountDown().
        onit = true;
        superMode = false;
      }
      // Me generating a golden heart (not designed for players)
      if (guaG && addG) {
        isGolden();
        addG = false;
      }
      // Super Fire starts
      if (superFireUp && superFireNow && goldnum > 0) {
        superFireUp(); // An attempt of increasing the prob of Super Fire
        superFireNow = false; // this section will only be invoked when users press the key everytime.
        superFire = true; // Super Fire starts
      }
   }



   // Invadem fire
   public void invademFire() {
     frame++;
     if (level <= 5) {
       if (frame >= 300 - (level - 1) * 60) {
         frame = 0;
       }
     } else {
       if (frame >= 60) {
         frame =0;
       }
     }

     if (frame == 0) {
       while (true) {
         num = (int) this.random(40);
         // one of invadems that is not destroyed will fire a projectile every period
         if (!sprites.getSprites().get(num).destroyed() && !sprites.getSprites().get(num).isGolden()) {
           break;
         }
       }
       if (sprites.getSprites().get(num).isPowerful()) {
         invademProjectiles.add(sprites.getSprites().get(num).fire(projectilePic, 2, 5, 3));
       } else {
         invademProjectiles.add(sprites.getSprites().get(num).fire(projectilePicLg, 1, 3, 1));
       }
     }
   }



   // Check the collision of two objects that are of type Moving
   public boolean detectCollision(Moving r1, Moving r2) {
     if ( (r1.getX() < (r2.getX() + r2.getWidth())) &&
           ((r1.getX() + r1.getWidth()) > r2.getX()) &&
          (r1.getY() < (r2.getY() + r2.getHeight())) &&
          ((r1.getHeight() + r1.getY()) > r2.getY())) {
         return true;
       } else {
         return false;
       }
   }



   // Using generics in order to be ultilised by more than two classes/
   // If two objects collides, the HP of one object will be reduced by the amount of
   // the power of the other object.
   // Return the points of invader when it has been destroyed.
   public <T extends Moving, K extends Moving> int collision(List<T> r1, List<K> r2) {
     int points = 0;
     int m = 0;
     for (int t  = 0; t < r1.size(); t++) {
       for (int k  = 0; k < r2.size(); k++) {
         if (!r1.get(t).destroyed() && !r2.get(k).destroyed()) {
           if (detectCollision(r1.get(t), r2.get(k))) {
             m = r1.get(t).remove(r2.get(k).getPower()); // HP1 -= power2
             if (m == -1) {
               // m here works as a discriminant of whether this
               // sprite is a golden heart.
               isGolden(); // Invoke the following operation of obtaining a golden heart
               m = 1000; // The point of a golden heart is 1000.
             }
             points += m;
             m = 0;
             r2.get(k).remove(r1.get(t).getPower()); // HP2 -= power1
           }
         }
       }
     }
    return points;
   }






// ----------------- My extension --------------------


    // Some effects after being saved
    // Show some info for 120 frames
    // Then reset to the begining of the current level
    public void saveMyLife() {
      // saving = true;
      // if (goldentime % 3 == 0) {
      //   backgroundChange();
      // }
      // textFont(createFont(("PressStart2P-Regular.ttf"), 27));
      // fill(248,234,79);
      // text("One more time!", 145, 200);
      // this.image(golden, 268, 251, 22, 20);
      // text("--;", 300, 275);
      // fill(255);
      // goldentime++;
      // if (goldentime == 120) {
        goldnum -= 1;
        noLoop();
        setup();
        loop();
      // }
    }

    // Colour changes of background when calling the method above
    public void backgroundChange() {
      // if (counter == 0) {
      //   counter++;
      //   background(41, 91, 240);
      // } else if (counter == 1) {
      //   counter++;
      //   background(53, 133, 224);
      // } else if (counter == 2) {
      //   counter++;
      //   background(71, 145, 244);
      // } else if (counter == 3) {
      //   counter++;
      //   background(73, 148, 248);
      // } else if (counter == 4) {
      //   counter++;
      //   background(102, 201, 246);
      // } else if (counter == 5) {
      //   counter++;
      //   background(102, 200, 248);
      // } else if (counter == 6) {
      //   counter++;
      //   background(127, 247, 244);
      // } else if (counter == 7) {
      //   counter++;
      //   background(127, 246, 242);
      // } else if (counter == 8) {
      //   counter++;
      //   background(102, 201, 246);
      // } else if (counter == 9) {
      //   counter++;
      //   background(102, 200, 248);
      // } else if (counter == 10) {
      //   counter++;
      //   background(71, 145, 244);
      // } else if (counter == 11) {
      //   counter = 0;
      //   background(73, 148, 248);
      // }
    }


    // Change of background when getting hit
    public void backgroundHitChange() {
      bloodCounter++;
      if (bloodCounter == 1) {
        background(255,0,0);
      } else {
        background(0);
        bloodCounter = 0;
      }
    }

    // The following operations (change the colour of background) when the tank is hit.
    public void getHit() {
      if (blood) {
        bloodTime++;
        if (bloodTime % 7 == 0){
          backgroundHitChange();
        }
        if (bloodTime == 50) {
          blood = false;
          background(0);
          bloodTime = 0;
          if (doIlose()) {
            // after the background blinks, the player then is dying
            dead = true;
            // invoke detectLose()
          }
        }
      }
    }

    public void hit2() {
      if (!hit2) {
        hit2 = true;
        blood = true; // invoke getHit();
      }
    }


    // Detect whether the tank is hit
    // If so, a red heart will be lost
    public void drawHearts() {
      this.image(golden, 570, 458, 16, 13);
      textFont(createFont(("PressStart2P-Regular.ttf"), 14));
      text("x", 590, 471);
      text(String.valueOf(goldnum), 607, 472);
      if (tank.get(0).getHP() == 3) {
        this.image(heart, 490, 457, 16, 16);
        this.image(heart, 515, 457, 16, 16);
        this.image(heart, 540, 457, 16, 16);
      } else if (tank.get(0).getHP() == 2) {
        if (!hit1) {
          hit1 = true;
          blood = true; // invoke getHit();
        }
        this.image(heart, 490, 457, 16, 16);
        this.image(heart, 515, 457, 16, 16);
      } else if (tank.get(0).getHP() == 1) {
        hit2();
        this.image(heart, 490, 457, 16, 16);
      } else if (doIlose()){
        // There will be a change of background even if the tank is destroyed.
        blood = true; // invoke getHit();
      }
    }


    // Make the projectile of particular index a Super Fire
    public void superFire(List<Integer> index) {
      for(int i : index) {
        Projectile p = projectiles.get(i);
        if (p.getY() <= sprites.getAverageY()) {
          if (!p.destroyed()) {
            p.remove(1);
            superProjectiles.add(p.superFire(projectilePicY));
            shoot = false;
          }
        }
      }
    }

    // Increase the probability of firing a Super Fire
    public void superFireUp() {
      backgroundYellowChange = true; // Invoke getSuperFire()
      showSuperFire = true; // Invoke showSuperFire()
      superFireLevelIndex ++;
      goldnum--;
      if (superFireLevelIndex > superFireLevel.length - 1) {
        superFireLevelIndex = superFireLevel.length - 1;
      }
      randomNum = superFireLevel[superFireLevelIndex];
    }



    // The colour of the background changes when the prob of Super Fire increases.
    public void getSuperFire() {
      if (backgroundYellowChange) {
        backgroundYellowChangeTime++;
        if (backgroundYellowChangeTime % 7 == 0){
          backgroundYellowChange();
        }
        if (backgroundYellowChangeTime == 28) {
          backgroundYellowChange = false;
          background(0);
          backgroundYellowChangeTime = 0;
        }
      }
    }


    // Background changes
    public void backgroundYellowChange() {
      superFireCounter++;
      if (superFireCounter == 1) {
        background(248,234,79);
      } else {
        background(0);
        superFireCounter = 0;
      }
    }



    // Print out the current probability of the Super Fire
    public void showSuperFire() {
      if (showSuperFire) {
        fill(248,234,79);
        textFont(createFont(("PressStart2P-Regular.ttf"), 12));
        if (superFireLevelIndex == 0) {
          text("Super Fire \nincreased \nto 20%", 5, 70);
        } else if (superFireLevelIndex == 1) {
          if (firstTime50) {
            showSuperFireTime = 0;
            firstTime50 = false;
          }
          text("Super Fire \nincreased \nto 50%", 5, 70);

        } else {
          text("Super Fire \nincreased \nto 100%", 5, 70);
        }
      }
    }




    // Randomly genereate a golden heart when an invadem died.
    public void generateGodlenHeart() {
      if (!generated) {
        if (level == 1) {
          randomG = 1;
        }
        if (sprites.getDesctoyed() == randomG) {
          goldenCountDown = true; // Invoke goldenCountDown()
          sprites.findThisSprite(randomG).makeItGoldenHeart(golden);
          generated = true;
        }
      }
    }



    //
    public void goldenCountDown() {
      if (goldenCountDown) {
        fill(248,234,79);
        if (!stopped1 && firstTimeG) {
          noLoop();
          firstTimeG = false; // Show some info when the first golden heart is generated.
          textFont(createFont(("PressStart2P-Regular.ttf"), 14));
          text("Golden Heart appears", 185, 220);
          text("It lasts for 9s",185, 245);
          text("Hit it 3 times!", 185, 270);
          text("Press [Y] to continue", 185, 295);
          stopped1 = true;
        }
        text(String.valueOf(goldenCountDownNum),590, 450);
        goldenCountDownFrame--;
        if (goldenCountDownFrame % 60 == 0) {
          goldenCountDownNum--;
        }
        if (goldenCountDownNum == 0) {
          goldenCountDown = false;
          fill(255);
        }
      }
    }



    // Invoked after a golden heart is obtained
    public void isGolden() {
      goldnum++;
      had = true;
      goldenCountDown = false;
      goldenHeartInto = true; // Invoke goldenHeartInto();
      fill(255);
    }


    // Show some info when the first golden heart is obtained
    public void goldenHeartInto() {
      if (goldenHeartInto && goldnum == 1 && firstTimeH) {
        if (!stopped2) {
          noLoop();
          firstTimeH = false;
          fill(248,234,79);
          textFont(createFont(("PressStart2P-Regular.ttf"), 12));
          text("You got a Golden Heart!", 30, 195);
          text("1.You can have one more life when you die, OR",30, 220);
          text("2.Press [Enter] to get into Super Mode, OR", 30, 245);
          text("3.Press [S] to increase the chance of Super Fire.", 30, 270);
          text("Press [Y] to continue first", 30, 295);
          stopped2 = true;
          fill(255);
        }
      }
    }


    // Show the count down of Super Mode
    public void superModeCountDown() {
      if (onit) {
        fill(248,234,79);
        textFont(createFont(("PressStart2P-Regular.ttf"), 14));
        text("Super Mode", 10, 440);
        text(String.valueOf(superModeCountDownNum),500, 450);
        superModeCountDownFrame--;
        if (superModeCountDownFrame % 60 == 0) {
          superModeCountDownNum--;
        }
        if (superModeCountDownNum == 0) {
          onit = false;
          superModeCountDownNum = 15;
          fill(255);
        }
      }
    }


    //Directly win or lose (for me to test)
    // public void shortcut_for_me() {
    //   if (gua) {
    //     for (Sprites s : sprites.getSprites()) {
    //       s.remove(1);
    //     }
    //   }
    //   if (guaLose) {
    //     tank.get(0).remove(3);
    //   }
    // }



    // Draw everything
    public void draw() {


      // Background is black in normal cases
      if (!saving && !blood && !backgroundYellowChange) {
          background(0);
      }



      // Normal cases (when the player is not dying, winning or being saved)
      if (!win && !lose && !saving) {
        // Normal cases
        doIlose();
        printScore();
        printLevel();
        invademFire();
        detectKey();

        // Getting hit and drawing hearts(HP)
        getHit();
        drawHearts();

        // Generating golden hearts, count down and info
        generateGodlenHeart();
        goldenCountDown();
        goldenHeartInto();

        // Super Fire
        superFire(index);
        getSuperFire();
        showSuperFire();

        // Super Mode
        superModeCountDown();

        // Shortcut
        // shortcut_for_me();

        // Check collision ----------------------------------------
        current_score += collision(sprites.getSprites(),projectiles);
        for (SuperProjectile su : superProjectiles) {
          current_score += collision(sprites.getSprites(),su.getSuperProjectiles());
        }
        for (Barrier barrier : barriers) {
            collision(projectiles, barrier.getComponents());
            collision(invademProjectiles, barrier.getComponents());
          }
        collision(invademProjectiles, tank);
        // --------------------------------------------------------


        // Draw entities ------------------------------------------
        tank.get(0).draw(this);
        for (Projectile p : projectiles) {
          p.draw(this);
          // PApplet.runSketch(arr, this);
          // System.out.println(Arrays.toString(arr));
        }
        for (SuperProjectile sup : superProjectiles) {
          for (Super supe : sup.getSuperProjectiles()) {
            supe.draw(this);
          }
        }
        for (Projectile p1 : invademProjectiles) {
          p1.draw(this);
        }
        for (Sprites s : sprites.getSprites()) {
          s.draw(this);
        }
        for (Barrier b : barriers) {
          b.draw(this);
        }
        // --------------------------------------------------------
      }
      // Check every time.
      detectWin();
      detectLose();
    }


    public static void main(String[] args) {
        PApplet.main("invadem.App");
    }

  }
