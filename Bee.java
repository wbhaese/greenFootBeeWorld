import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bee extends Actor
{
    /**
     * Act - do whatever the Bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image1;
    private GreenfootImage image2;
    int score = 0;
    int lives = 5;
    int flys;
    int speed = 4;
    public Bee(){
        image1 = new GreenfootImage("bee1.png");
        image2 = new GreenfootImage("bee3.png");
        setImage(image1);
    }
    public void moveRight(){
        setLocation(getX() + speed, getY());
    }
    public void moveLeft(){
        setLocation(getX() - speed, getY());
    }
    public void moveUp(){
        setLocation(getX(), getY() - speed);
    }
    public void moveDown(){
        setLocation(getX(), getY() + speed);
    }
    public void act() 
    {
       if(getImage() == image1)
       {
           setImage(image2);
       }else{
           setImage(image1);
       }   
       if (Greenfoot.isKeyDown("left")){
           moveLeft();
       }
       if (Greenfoot.isKeyDown("right")){
           moveRight();
        } 
        if (Greenfoot.isKeyDown("up")){
           moveUp();
        }  
        if (Greenfoot.isKeyDown("down")){
           moveDown();
        }  
       handleMovement();
       turnAtEdge();
       catchFly();
       caughtBySpyder();
       updateScore();
    }
    
    public void handleMovement()
    {
        //move(1);
    }
    public boolean atRightEdge()
    {
        if(getX() > getWorld().getWidth() - 20)
            return true;
        else
            return false;
    }
    
    public boolean atBottomEdge()
    {
        if(getY() > getWorld().getHeight() - 20)
            return true;
        else
            return false;
    }
    public void caughtBySpyder(){
        if (isTouching(Spider.class)){
            int xCoord = Greenfoot.getRandomNumber(600);
            int yCoord = Greenfoot.getRandomNumber(400);
            setLocation(xCoord,yCoord);
            lives--;
            getWorld().showText("You losted one life!",350,10);            
            if (lives == 0){
                Greenfoot.stop();
                getWorld().showText("You died!",300,200);
            }
        }
    }
        
    private void catchFly(){
        if (isTouching(Fly.class)){
            removeTouching(Fly.class);
            score+= 10;
            flys += 1;
            getWorld().addObject(new Fly(4,76),Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
            if (score > 500){
                lives+= 1;
                score=0;
                getWorld().showText("You received one life!",350,10);
            }
        }
    }
    private void updateScore(){
        //score++;
        getWorld().showText("Score: "+ score,60,390);
        getWorld().showText("Flys Captured: "+ flys,350,390);
        getWorld().showText("Lifes: "+lives,60,10);
    }
        
    public void turnAtEdge()
    {
        move(1);
       if(atRightEdge()){
           setLocation(6, getY());
       }else
       if(atBottomEdge()){
           setLocation(getX(), 6);
       }//endif
    }
}
