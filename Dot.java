import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dot  extends Actor
{
   private int x;
   private int y;
   private int d;
   private final int DOT_SIZE=20;
   public Dot(int dot){
        GreenfootImage image1 = new GreenfootImage("SnakeHead.gif");
        image1.mirrorHorizontally();
        d = dot;
        if(d==0){
            setImage(image1);
        } else {
            setImage("close.png");
        }
   } 
    //Checks wheather this is the first dot added (head) or not (body)    

    /**
     * Act - do whatever the Head wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   public void act() 
   {
       if( d == 0 )
       {
           lead();
           lookForFood();
           lookForEdge();
           lookForDot();
       }
       else
       {
           follow();
       }
   }
   
   /**
    * lead controls the movement of the head of our snake
    * @paramterers There are no parameters 
    * @retturn There is nothing to return
    */
   private void lead()
   {
       double angle;
       SnakeWorld myWorld = (SnakeWorld)getWorld();
       x = getX();
       y = getY();
       
       if( Greenfoot.isKeyDown("left") )
       {
           setRotation(180);
       }
       else if( Greenfoot.isKeyDown("right") ) 
       {
           setRotation(0);
       }
       else if( Greenfoot.isKeyDown("up") ) 
       {
           setRotation(270);
       }
       else if( Greenfoot.isKeyDown("down") ) 
       {
           setRotation(90);
       }
   
       angle = Math.toRadians( getRotation() );
       x = (int) Math.round( getX() + Math.cos(angle) * DOT_SIZE);
       y = (int) Math.round( getY() + Math.sin(angle) * DOT_SIZE);
   
       setLocation(x, y);
       myWorld.setDX(d, x);
       myWorld.setDY(d, y);
   }
   
   /**
   * @paran d is the dot number
   * @Ruetrn nothing is returned 
   */
   private void lookForEdge()
   {
       if( isAtEdge() )
       {
           getWorld().showText("You have lost", getWorld(). getWidth()/2, getWorld(). getHeight()/2 );
           Greenfoot.stop();
       }
   }
   
   /**
   * lookForFood check is our snake is toutching Food and then grows it tail if we have eaten food
   * @paran there is none 
   * @Return nothing is returned 
   */
   private void lookForFood()
   {
       SnakeWorld world = (SnakeWorld)getWorld();
       
       
       if( isTouching(Food.class) )
       {
           getWorld().removeObject(getOneIntersectingObject(Food.class) );
           growTail();
           world.addFood();
       }
   }
   
   /**
   * @paran d is the dot number
   * @Return nothing is returned 
   */
   private void lookForDot()
   {
     if(isTouching(Dot.class) )
     {
         getWorld().showText("You have lost", getWorld(). getWidth()/2, getWorld(). getHeight()/2 );
         Greenfoot.stop();
     }
   }
   
   /**
    * follow handles every movement for every body part of the snake 
    * @paramterers There are no parameters 
    * @return There is nothing to return
    */
   private void follow()
   {
       SnakeWorld myWorld = (SnakeWorld)getWorld();
       x = myWorld.getMyX(d);
       y = myWorld.getMyY(d);
       setLocation(x, y);
   }
   
   /**
   * gowTail will add a dot to the snake when we eat food
   * @paramterers There are no parameters 
   * @return There is nothing to return
   */
   private void growTail()
   {
       SnakeWorld world = (SnakeWorld)getWorld();
       world.addDot();
   }
}