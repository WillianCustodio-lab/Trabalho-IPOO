import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Descreve ao usuário como jogar o jogo
 */
public class TelaInstruções extends World
{

    /**
     * Constructor for objects of class TelaInstruções.
     * 
     */
    public TelaInstruções()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
    }
    
    //entra na fase1
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Fase1());
            Greenfoot.playSound("Clique.mp3");
        }
    }
}
