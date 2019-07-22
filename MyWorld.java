import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        act();
        Bee bee = new Bee();
        addObject(bee, 298, 176);
        Spider spider = new Spider();
        addObject(spider, 12, 45);
        
        for( int i=0; i<10; i++){
            int direction = Greenfoot.getRandomNumber(360);
            int xcoord = Greenfoot.getRandomNumber(600);
            int ycoord = Greenfoot.getRandomNumber(400);
            int maxSpeed = Greenfoot.getRandomNumber(10);
            addObject (new Fly(maxSpeed, direction),xcoord, ycoord);
        }    
        /*
        addObject(new Fly(2,40), 18, 94);
        addObject(new Fly(4,50), 13, 94);
        addObject(new Fly(3,90), 83, 94);
        addObject(new Fly(6,70), 283, 94);
        */
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Bee bee = new Bee();
        /*Fly fly = new Fly();
        *addObject(fly, 183, 94);
        *Fly fly2 = new Fly();
        addObject(fly2, 515, 115);        
        Fly fly3 = new Fly();
        addObject(fly3, 43, 56);
        Fly fly4 = new Fly();
        addObject(fly4, 43, 56);
        */
    }   
}
