import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela de vitória ao atingir a pontuação do jogo
 */
public class TelaVitoria extends World
{

    /**
     * Constructor for objects of class TelaVitoria.
     * 
     */
    public TelaVitoria()
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        
        showText("Pontuação: " + Pontuacao.getPontos(), 755, 300);
    }
    
    //Volta a tela inicial
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new TelaInicial());
        }
    }
}
