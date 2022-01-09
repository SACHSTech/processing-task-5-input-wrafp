import processing.core.PApplet;

public class Sketch extends PApplet {
  // Global variables
  public int R = 255;
  public int G = 255;
  public int B = 255;
  public String strText = "";
  
  public void settings() {
    size(500, 500);
  }


  public void setup() {
    background(R, G, B);
  }


  public void draw() {

    // When mouse pressed, it draws the body of the snake
    if (mousePressed) {
      stroke(185, 45, 190);
      fill (185, 45, 190);
      ellipse(mouseX, mouseY, height / 20, height / 20);
    }
    
    if (keyPressed) {
      // When CONTROL is pressed, it draws a patch of dirt
      if (keyCode == CONTROL) {
        stroke(100, 65, 45);
        fill(100, 65, 45);
        rect(mouseX, mouseY, height / 10, height / 10);
      }
      // When ALT is pressed, it draws water
      else if (keyCode == ALT) {
        stroke(45, 115, 250);
        fill(45, 115, 250);
        rect(mouseX, mouseY, height / 10, height / 10);
      }
      // When ENTER is pressed, it starts a new text 
      else if (keyCode == ENTER) {
        strText = "";
      }
      // When BACKSPACE is pressed, clears the screen
      else if (keyCode == BACKSPACE) {
        background(R, G, B);
      }
    }
  }

  /**
   * When mouse press is released, it draws the end of a snake, a bloomed flower.
   */
  public void mouseReleased() {
    stroke(0);
    fill(255);
    ellipse(mouseX + 15, mouseY, height / 25, height / 40);
    ellipse(mouseX, mouseY + 15, height / 40, height / 25);
    ellipse(mouseX - 15, mouseY, height / 25, height / 40);
    ellipse(mouseX, mouseY - 15, height / 40, height / 25);
    fill(220, 150, 40);
    ellipse(mouseX, mouseY, height / 25, height / 25);
  }

  /** 
   * When key is typed, it will draw a text at mouse coordinates
   */
  public void keyTyped() {
    strText += key;
    fill(0);
    textSize(height / 30);
    text(strText, mouseX, mouseY);
  }
}
