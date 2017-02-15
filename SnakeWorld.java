import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class snakeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnakeWorld  extends World
{
    private final int MAX_DOTS = (600*400)/(20*20);
    
    private int[] x = new int[MAX_DOTS];
    private int[] y = new int[MAX_DOTS];
    private int dots = 4;
    private Dot body;
    
    /**
     * Constructor for objects of class snakeWorld.
     * 
     */
    public SnakeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        for(int i = 0; i < dots; i++){
            x[i] = 100 - i*20;
            y[i] = 20;
        }
        
        addObject( new Food(), Greenfoot.getRandomNumber(12)*50+25,Greenfoot.getRandomNumber(8)*50+25);
        
        prepareSnake();
    }
    
    /**
     * act handles the actions must be taken verytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act()
    {
        for(int i = dots; i > 0; i--)
        {
            x[i] = x[i-1];
            y[i] = y[i-1]; 
        }
    }
    
    /**
     * prepareSnake adds the Dot objects to the worlds
     * to create our Snake
     * @param There are no parameters 
     * @return There is no return type
     */
    private void prepareSnake() {
        for(int i = 0; i < dots; i++){
            body = new Dot(i);
            addObject(body, x[i], y[i]);

        }
    }
    
    /**
     * setDX changes the stored x coordinates for a given Dot object
     * @param d is the dot number 
     * @param dx is the new x coordinate of the Dot object 
     * @return Nothing is returned 
     */
    public void setDX(int d, int dx)
    {
        x[d] = dx;
    }
   
    /**
    * setDY changes the stored y coordinates for a given Dot object
    * @param d is the dot number 
    * @param dx\y is the new y coordinate of the Dot object 
    * @return Nothing is returned 
    */
    public void setDY(int d, int dy)
    {
        y[d] = dy;
    }
    
     /**
    * getMyX return x coordinate of the given Dot object 
    * @paran d is the dot number
    * @return an integer that represents
    */
    public int getMyX(int d)
    {
        return x[d];
    }
    
    public int getMyY(int d)
    {
        return y[d];
    }
    
    /**
     * addFood will add a random number (1 or 2) into the world 
     * @paran d is the dot number
     * @Ruetrn nothing is returned 
     */
    public void addFood()
    {
        for(int i = 0; i < Greenfoot.getRandomNumber(1)+1; i++)
        {
             addObject( new Food(), Greenfoot.getRandomNumber(12)*50+25,Greenfoot.getRandomNumber(8)*50+25);
        }
    }
    
    public void addDot()
    {
       int parentX = x[dots-1];
       int parentY = y[dots-1];
            
       body = new Dot(dots);
       addObject( body, parentX, parentY );
       dots++;
      

        }
       
    }



        