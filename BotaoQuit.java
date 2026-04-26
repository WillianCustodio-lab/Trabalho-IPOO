import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Botao de parar a execução do Greenfoot
 */
public class BotaoQuit extends Buttons {
    public void act() {
        checkMouse();
        
        //verifica se o mouse clicou
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("Clique.mp3");
            Greenfoot.stop();
        }
    }
}

