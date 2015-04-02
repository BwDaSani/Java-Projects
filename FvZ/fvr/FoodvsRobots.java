package fvr;

import java.util.Random;

import jgame.*;
import jgame.platform.*;



public class FoodvsRobots extends StdGame//JGEngine
{
 static int level;
//This will change according to certain levels
static int robotnumCounter = 0;
static int robotnumMax = 20;
 
 //Keeps track of how many robots are in each row
 static int rowBotNum[] = new int [5];
 
 //An array of Food objects tiles
 static JGObject foodLoc [][] = new JGObject[5][9];
 
 //Used for generating random row robots
 static Random random = new Random();
 static int [] botrowArray = 
 {140+40, 250+40, 360+40, 470+40, 580+40};

 //Player's money
 static int money = 0;
 //Determines how fast money grows
 static int moneyGrow = 1;
 
 //Initializes clicked button
 static int buttonNum = -1;
 
 //FOOD STATS
 String foodType = null;
 int foodHP = 0;
 int foodCost = 0;
 int foodshootFreq = 0;
 
 //Egg Roll Status
 boolean row1M = true;
 boolean row2M = true;
 boolean row3M = true;
 boolean row4M = true;
 boolean row5M = true;
 
 //Backdoor control
 static boolean clearRow1;
 static boolean clearRow2;
 static boolean clearRow3;
 static boolean clearRow4;
 static boolean clearRow5;
 
 //Main
 public static void main(String [] args) 
 {
  //Menu 1
  Menu1 menu1;
  menu1 = new Menu1(null, "Menu");
  menu1.setVisible(true);
  
  //Menu 2
  Menu2 menu2;
  menu2 = new Menu2(null, "Menu");
  menu2.setVisible(true);
  
  //Start Game
  int gameLevel = 0;
  boolean startGame = false;
  startGame = menu2.returnStart;
  gameLevel = menu2.returnLevel; 
  if(startGame == true)
  {
   new FoodvsRobots(new JGPoint(1200,800), gameLevel);
  }
 }
 
 ////////////////////////////////////////////////////////////////////////////
 
 //Setup 1
 public FoodvsRobots(JGPoint size, int inLevel) 
 { 
  initEngine(size.x,size.y);
  level = inLevel;
 }
 
 ////////////////////////////////////////////////////////////////////////////
 
 //Setup 2
 public void initCanvas() 
 {
  setCanvasSettings(70, 46, 16, 16, null, JGColor.white, null);
 }
 
 ////////////////////////////////////////////////////////////////////////////
 
//Setup 3
 public void initGame() 
 {
  setFrameRate(35, 2);
  defineMedia("gametable.tbl");
  setBGImage("mybackground");
  random.setSeed(5);
  
  robotnumMax = 10* level;
  robotnumCounter = 0;
  
  new Food("FB", 1, 0, 0, 160, 140, 0, 1);
  new Food("FB", 1, 0, 0, 160, 250, 0, 1);
  new Food("FB", 1, 0, 0, 160, 360, 0, 1);
  new Food("FB", 1, 0, 0, 160, 470, 0, 1);
  new Food("FB", 1, 0, 0, 160, 580, 0, 1);
 }
 
 ////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////
 ////////////////////////////////////////////////////////////////////////////
 
 int gametimer = 0;
 
 public void doFrame() 
 {
  /*System.out.println("---------------------");
  for(int i = 0; i < 5; i++)
  {
   System.out.println(rowBotNum[i]);
  }
  System.out.println("---------------------");*/
  
  gametimer++;
  
  moveObjects(null, 0);
  
  checkCollision(
                 1, // cids of objects that our objects should collide with 
                 2+4  // cids of the objects whose hit() should be called 
                );
 
  
  if(getKey(key_1))
  {
    System.out.println("row1");
    clearRow1 = !clearRow1;
    if(clearRow1)
     rowBotNum[0] = 0;
    else
     rowBotNum[0] = 1;
    clearKey(key_1);
  }
  if(getKey(key_2))
  {
    System.out.println("row2");
    clearRow2 = !clearRow2;
    if(clearRow2)
     rowBotNum[1] = 0;
    else
     rowBotNum[1] = 1;
    clearKey(key_2);
  }
  if(getKey(key_3))
  {
    System.out.println("row3");
    clearRow3 = !clearRow3;
    if(clearRow3)
     rowBotNum[2] = 0;
    else
     rowBotNum[2] = 1;
    clearKey(key_3);
  }
  if(getKey(key_4))
  {
    System.out.println("row4");
    clearRow4 = !clearRow4;
    if(clearRow4)
     rowBotNum[3] = 0;
    else
     rowBotNum[3] = 1;
    clearKey(key_4);
  }
  if(getKey(key_5))
  {
    System.out.println("row5");
    clearRow5 = !clearRow5;
    if(clearRow5)
     rowBotNum[4] = 0;
    else
     rowBotNum[4] = 1;
    clearKey(key_5);
  }
  
  if (getMouseButton(1)) 
  {
   //System.out.println(getMouseX());
   //System.out.println(getMouseY());
   //System.out.println(buttonNum);
   
   //Clicked on Shovel
   if((getMouseX() > 226 && getMouseX() < 338) &&
      (getMouseY() > 34 && getMouseY() < 109))
   {
    buttonNum = 0;
   }
   
   //Clicked on TankBurger
   else if((getMouseX() > 11 && getMouseX() < 118) &&
           (getMouseY() > 35 && getMouseY() < 112))
   {
    if(money >= 20)
    {
     buttonNum = 1;
     foodType = "TankBurger";
     foodHP = 100;
     foodCost = 20;
     foodshootFreq = 50;
    }
   }
   
   //Clicked on SubMachineGun
   else if((getMouseX() > 11 && getMouseX() < 117) &&
           (getMouseY() > 121 && getMouseY() < 199))
   {
    if(money >= 40)
    {
     buttonNum = 1;
     foodType = "SubMachineGun";
     foodHP = 100;
     foodCost = 40;
     foodshootFreq = 10;
    }
   }
   
   //Clicked on Pizzooka
   else if((getMouseX() > 11 && getMouseX() < 117) &&
           (getMouseY() > 206 && getMouseY() < 284))
   {
    if(money >= 50)
    {
     buttonNum = 1;
     foodType = "Pizzooka";
     foodHP = 100;
     foodCost = 50;
     foodshootFreq = 85;
    }
   }
   
   //Clicked on CashRegister
   else if((getMouseX() > 11 && getMouseX() < 119) &&
           (getMouseY() > 461 && getMouseY() < 539))
   {
    if(money >= 10)
    {
     buttonNum = 1;
     foodType = "CashRegister";
     foodHP = 100;
     foodCost = 10;
     foodshootFreq = 1;
    }
   }
   
   //Clicked on CheeseWall
   else if((getMouseX() > 11 && getMouseX() < 119) &&
           (getMouseY() > 290 && getMouseY() < 367))
   {
    if(money >= 10)
    {
     buttonNum = 1;
     foodType = "CWA";
     foodHP = 900;
     foodCost = 10;
     foodshootFreq = 1;
    }
   }
   
   //Clicked on HotDynamiteDog
   else if((getMouseX() > 11 && getMouseX() < 119) &&
           (getMouseY() > 377 && getMouseY() < 454))
   {
    if(money >= 30)
    {
     buttonNum = 1;
     foodType = "HDD";
     foodHP = 50;
     foodCost = 30;
     foodshootFreq = 1;
    }
   }
   
   //Clicked in the Field
   else if((getMouseX() >= 242 && getMouseX() <= 1069) &&
           (getMouseY() >= 158 && getMouseY() <= 713))
   {
    //Get "clicked" location with offset
    int placex = getMouseX()-35;
    int placey = getMouseY()-35;
    
    //Snap Y to tile
    if(placey >= 115)
    {
     placey = 170 + (placey-115)/110*110;
    }
    else
    {
     placey = 0;
    }
    //Snap X to tile
    if(placex >= 199)
    {
     placex = 245 + (placex-199)/92*92;
    }
    else
    {
     placex = 0;
    }
    
    int col = (placex-245)/92;
    int row = (placey-170)/110;
    
    //If tile is not occupied and a food is chosen
    if(buttonNum == 1 && foodLoc[row][col] == null)
    {  
     //Plant food in a specific tile in the object array
     foodLoc [row][col] = new Food(foodType, 
                                     foodHP, 
                                       0, 0, 
                                     placex, 
                                     placey, 
                                   foodCost, 
                             foodshootFreq);
       
     //Reset clicked button
     buttonNum = -1;
       
     //Reset plant stats
     foodType = null;
     foodHP = 0;
     foodCost = 0;
     foodshootFreq = 0;
    }
    
    //If tile is occupied and the shovel is chosen
    else if (buttonNum == 0 && foodLoc[row][col] != null)
    {
     //Decrease money growth if removed cash register
     if(foodLoc[row][col].infoodType.equals("CashRegister"))
     {
      moneyGrow --;
     }
     
     //Remove food
     removeObjects(foodLoc[row][col].getName(),0);
     foodLoc[row][col] = null;
     
     //Reset clicked button
     buttonNum = -1;
    }
    
    //If food is chosen but tile is occupied
    //If shovel is chosen but tile is already empty
    else if((buttonNum == 1 && foodLoc[row][col] != null) ||
            (buttonNum == 0 && foodLoc[row][col] == null))
    {
     //Reset everything
     buttonNum = -1;
     foodType = null;
     foodHP = 0;
     foodCost = 0;
     foodshootFreq = 0;
    }
   }
   
   clearMouseButton(1);
  }
  
  //Generate money according to timer
  if(gametimer % 20 == 0)
  {
   money = money + moneyGrow;
  }
  
  
  //Generates robots in random rows for certain levels
  //Randomized index from 0 - 4
  int randNum = random.nextInt(5);
  if(level == 0)
  {
   if(gametimer % 100 == 0 && robotnumCounter <= robotnumMax)
   {
    new Robot("Robot1", 20, -0.5, 0, 1050, botrowArray[randNum]);
   }
  }
  else
  {
   int delay = 50*(8-level);
   if(robotnumMax != 0 && robotnumCounter >= robotnumMax)
   {
    System.out.println("Win");
   }
   else
   {
    if(gametimer % delay == 0 && robotnumCounter <= robotnumMax)
    {
     new Robot("Robot1", 10*level, -0.5, 0, 1050, botrowArray[randNum]);
    }
   }
  }
 }
 
 
 //Paint frame
 public void paintFrame() 
 {
  //Print money
  setColor(JGColor.black);
  drawString(String.valueOf(money), 193, 105, 0);
 }
 
 /////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////////////////
 
 //ROBOTS
 class Robot extends JGObject 
 {
  //Constructor
  Robot(String robotType, int hp, double xSpeed, double ySpeed, int startX, int startY)
  {
   super(
         "robot", //Name
            true, //Indexed
          startX, //Start Loc X
          startY, //Start Loc Y
               1, //Collision ID
        robotType //Gif-type String
        );
   
   hitpoints = hp; //HP
   
   xspeed = xSpeed;//X Speed
   yspeed = ySpeed;//Y Speed
   
   originalXspeed = xSpeed;//Original X Speed
   originalYspeed = ySpeed;//Original X Speed
   
   //For food detection
   victimX= -1;
   victimY= -1;
   
   //Robot Row and Col Number
   startCol = (startX-245)/92;
   startRow = (startY-140)/110;
   
   //Increase row occupancy
   rowBotNum[startRow] ++;
  }
  //End of Constructor
  
  public void move() 
  {
   if(x <= 193)
   {
    if(row1M == true && startRow == 0)
    {
     new Bullet("ER", 190, y-15, 5, 0, 1000);
     row1M = false;
    }
    else if(row2M == true && startRow == 1)
    {
     new Bullet("ER", 190, y-15, 5, 0, 1000);
     row2M = false;
    }
    else if(row3M == true && startRow == 2)
    {
     new Bullet("ER", 190, y-15, 5, 0, 1000);
     row3M = false;
    }
    else if(row4M == true && startRow == 3)
    {
     new Bullet("ER", 190, y-15, 5, 0, 1000);
     row4M = false;
    }
    else if(row5M == true && startRow == 4)
    {
     new Bullet("ER", 190, y-15, 5, 0, 1000);
     row5M = false;
    }
    else if(x <= 170)
    {
     stop();
    
     DeathScreen deathscreen;
     deathscreen = new DeathScreen(null, "Game Over");
     deathscreen.setVisible(true);
     if(deathscreen.quit == true)
     {
      System.exit(0);
     }
    }
   }
   
   //If robot's HP reaches 0
   if(hitpoints <= 0)
   {
    //Robot dies, decrease row occupancy
    rowBotNum[startRow]--;
    
    //Robot "freezes" before death
    /*stopAnim();
    xspeed = 0;
    yspeed = 0;*/
    
    //Add death animation?
    
    //Remove robot from field (after a certain time?)
    removeObjects(this.getName(),0);
   }
   
   //Use for food detection
   if(victimX == -1 && victimY == -1)
   {
    xspeed = originalXspeed;
    yspeed = originalYspeed;
   }
   else if(foodLoc[victimX][victimY] != null) 
   {
    xspeed = 0;
    yspeed = 0;
   }
   else
   {
    xspeed = originalXspeed;
    yspeed = originalYspeed;
   }
  }
 }
 
 ////////////////////////////////////////////////////////////////////////////
 
 //BULLET
 class Bullet extends JGObject 
 {
  //Constructor
  Bullet(String bulletType, double startX, double startY, double xSpeed, double ySpeed, int inDamage)
  {
   super( 
         "bullet", //Name
             true, //Indexed
           startX, //Start Loc X
           startY, //Start Loc Y
                2, //Collision ID
      bulletType); //Gif-type String 
   
   xspeed = xSpeed;//X Speed
   yspeed = ySpeed;//Y Speed
   
   damage = inDamage;//Bullet damage
  }
  //End of Constructor
  
  public void move() 
  {
   //HotDynamiteDog Explosion 
   if(damage == 12)
   {
    if(gametimer % 200 == 0)
    {
     removeObjects(this.getName(), 0);
    }
   }
  }
  
  //If a "HIT" occurs
  public void hit(final JGObject obj) 
  {
   //Bullet disappears
   if(damage != 1000 && damage != 12)
   {
    removeObjects(this.getName(), 0);
   }
 
   //Robot loses HP according to bullet damage
   if(obj.hitpoints > 0)
   {
    obj.hitpoints = obj.hitpoints - damage;
   }
   
   //Robot "reaction" animation
   obj.setGraphic("Robot1H");
   
   //Robot returns to normal animation after a while
   new JGTimer(20, true) 
   { 
    public void alarm()
    {
     obj.setGraphic("Robot1");
    }
   };
  } 
  //End of "HIT" sequence
 }
 
 ////////////////////////////////////////////////////////////////////////////
 
 //FOOD
 class Food extends JGObject 
 {
  //Constructor
  Food(String foodType, 
                int hp, 
         double xSpeed, 
         double ySpeed, 
      final int startX, 
      final int startY, 
        final int cost, 
        final int freq)
  {
   super(
         "food", //Name
           true, //Indexed
         startX, //Start Loc X
         startY, //Start Loc Y
              4, //Collision ID
        foodType //Gif-type String
        );

   hitpoints = hp; //HP
   xspeed = xSpeed;//X Speed '0'
   yspeed = ySpeed;//Y Speed '0'
  
   //Food Row and Col Number
   startCol = (startX-245)/92;
   startRow = (startY-170)/110;
   
   //Subtract money after buying food
   money-=cost;
   
   //Setup shooting frequency
   shootFreq = freq;
   
   //Increase money growth if planted cash register
   if(infoodType.equals("CashRegister"))
   {
    moneyGrow ++;
   }
  }
  //End of Constructor
  
  public void move() 
  {
   if(infoodType.equals("CWA") && hitpoints <= 600)
   {
    setGraphic("CWB");
   }
   //if(infoodType.equals("CWB") && hitpoints <= 300)
   //{
    //setGraphic("CWC");
   //}
   //if(!infoodType.equals("CashRegister"))
   //{
    //Only shoot bullets if there is at least one robot in the SAME ROW   
    if(rowBotNum[startRow] != 0)
    {
     //Shoot according to food's frequency
     if(gametimer % shootFreq == 0)
     {
      //TankBurger
      if(infoodType.equals("TankBurger"))
      {
       //Shooting animation
       setGraphic("TankBurgerA");
       //Set bullet
       new Bullet("TBB", x+100, y+10, 5, 0, 2);
      }
      //SubMachineGun
      if(infoodType.equals("SubMachineGun"))
      {
       //Shooting animation
       setGraphic("SubMachineGunA");
       //Set bullet
       new Bullet("TBB", x+100, y+15, 5, 0, 1);
      }
      //Pizzooka
      if(infoodType.equals("Pizzooka"))
      {
       //Shooting animation
       setGraphic("PizzookaA");
       //Set bullet
       new Bullet("PZB", x+15, y-15, 5, 0, 8);
      }
     }
    }
    //Return to stationary food when there are no robots
    else
    {
     setGraphic(infoodType);
    }
   //}
  }
  
  //If food is "HIT" by a robot
  public void hit(final JGObject obj) 
  {
   //Robot stops and there is eating animation
   obj.xspeed = 0;
   obj.yspeed = 0;

   //Used for detection
   obj.victimX = startRow;
   obj.victimY = startCol;
   
   //Food loses HP, use system clock
   hitpoints--;
   
   //Food "dies" when HP reaches 0
   if(hitpoints == 0)
   {
    if(infoodType.equals("HDD"))
    {
     new Bullet("HDDE", x-140, y-110, 0, 0, 12);
    }
    //If dead food is CashRegister
    if(infoodType.equals("CashRegister"))
    {
     //Decrease money growth
     moneyGrow--;
    }
    
    //Remove food from play
    foodLoc [startRow][startCol] = null;
    removeObjects(this.getName(), 0);
   }
  }
  //End of "HIT" sequence
 }
  
 ////////////////////////////////////////////////////////////////////////////
}
