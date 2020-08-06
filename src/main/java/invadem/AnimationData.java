package invadem;
import java.util.List;
import java.util.ArrayList;

import processing.core.PImage;
import invadem.moving.Sprites;



public class AnimationData {
  private static int row;
  private static int column;
  private int index = 0;
  private int destroyed;
  private List<Sprites> sprites;
  private List<Sprites> deadsprites;


  public AnimationData(PImage pic1, PImage pic_A1, PImage pic_P1, PImage pic2, PImage pic_A2, PImage pic_P2, int level) {
    row = 150;
    column = 0;
    deadsprites = new ArrayList<Sprites>();
    sprites = new ArrayList<Sprites>();
    for (int t = 0; t < 40; t++) {
      index++;
      if (t < 10) {
        sprites.add(new Sprites(pic_A1, pic_A2, row, column, 16, 16, level, 3, 1, false, 250, index));
      } else if (t < 20) {
        sprites.add(new Sprites(pic_P1, pic_P2, row, column, 16, 16, level, 1, 1, true, 250, index));
      } else {
        sprites.add(new Sprites(pic1, pic2, row, column, 16, 16, level, 1, 1, false, 100, index));
      }
      row += 32;
      if (row >= 470) {
        column += 32;
        row = 150;
      }
    }
  }

  public int getAverageY() {
    int sum = 0;

    List<Integer> ls = new ArrayList<Integer>();

    for (Sprites s : sprites) {
      if (!s.destroyed()) {
        ls.add(s.getY());
      }
    }
    for (int i : ls) {
      sum += i;
    }


    return sum/ls.size();
  }

  public int getDesctoyed() {
    for (Sprites s : sprites) {
      boolean add = true;
      if (s.destroyed()) {
          for (Sprites sp : deadsprites) {
            if (s.getIndex() == sp.getIndex()) {
              add = false;
            }
          }
      } else {
        add = false;
      }
      if (add) {
        deadsprites.add(s);

      }
    }
    return deadsprites.size();
  }

  public boolean deadNum(int i) {
    if (getDesctoyed() == i) {
      return true;
    } else {
      return false;
    }
  }

  public Sprites findThisSprite(int i) {
    return deadsprites.get(i - 1);
  }

  public boolean doIlose() {
    for (Sprites s : sprites) {
      if (!s.destroyed() && s.getY() + 16 + 10 >= 435) {
        return true;
      }
    }
    return false;
  }

  public List<Sprites> getSprites() {
    return sprites;
  }
}
