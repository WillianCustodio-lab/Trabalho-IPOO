import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Mostra a tela de derrota ao encerrar o jogo.
 */
public class TelaDerrota extends World
{

    /**
     * Constructor for objects of class TelaDerrota.
     * 
     */
    public TelaDerrota()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
    }
    
    //Reinicia o jogo
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Fase1());
        }
    }
}
