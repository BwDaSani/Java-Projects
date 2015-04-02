package tutorial;

import jgame.*;
import jgame.platform.*;

public class Example1 extends JGEngine 
{
 public static void main(String [] args) 
 {
  new Example1(new JGPoint(640,480));
 }

 public Example1(JGPoint size) 
 {
  // This inits the engine as an application.
  initEngine(size.x,size.y); 
 }

 public void initCanvas() 
 {
  // The only thing we need to do in this method is to tell the engine
  // what canvas settings to use.  We should not yet call any of the
  // other game engine methods here!
  setCanvasSettings( 20,  // width of the canvas in tiles
                     15,  // height of the canvas in tiles
                     16,  // width of one tile
                     16,  // height of one tile
                          // (note: total size = [20*16=320]  x  [15*16=240])
                     null,// foreground colour -> use default colour white
                     null,// background colour -> use default colour black
                     null // standard font -> use default font
                    );
 }

 

 public void initGame() 
 {
  // We can set the frame rate, load graphics, etc, at this point. 
  // (note that we can also do any of these later on if we wish)
  setFrameRate( 35,// 35 = frame rate, 35 frames per second
                 2 //  2 = frame skip, skip at most 2 frames before displaying
                   //      a frame again
              );
  
 }

 
 /** A timer used to animate the "hello world" text. */
 double texttimer=0;
 
 /** Game logic is done here.  No painting can be done here, define
 * paintFrame to do that. */
 public void doFrame() 
 {
  // Increment the angle of the moving text.
  texttimer += 0.05;
 }

 
 /** Any graphics drawing beside objects or tiles should be done here.
  * Usually, only status / HUD information needs to be drawn here. */
 public void paintFrame() 
 {
  setColor(JGColor.yellow);
  // Draw a text that moves around in a circle.
  // Note: viewWidth returns the width of the view;
  //       viewHeight the height.
  drawString( "Hello world",
              viewWidth()/2  + 50*Math.sin(texttimer), // xpos
              viewHeight()/2 + 50*Math.cos(texttimer), // ypos
              0 // the text alignment
                // (-1 is left-aligned, 0 is centered, 1 is right-aligned)
             );
 }
}