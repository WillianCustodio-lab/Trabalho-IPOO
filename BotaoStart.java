import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Botão de iniciar o jogo
 */
public class BotaoStart extends Buttons {
    public void act() {
        checkMouse();
        
        if(Greenfoot.mouseClicked(this)) {
            Greenfoot.playSound("Clique.mp3");

            TelaInicial tela = (TelaInicial) getWorld();
            tela.stopped(); //para a musica;

            checkClick(new TelaInstruções());
        }
    }
}

