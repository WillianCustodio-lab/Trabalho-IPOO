import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Inimigo da torre para a Fase 3: Canhoneiro.
 * Usará imagens e sons próprios.
 */

public class Canhoneiro extends InimigoTorre
{
    public Canhoneiro() {
        super(
            new GreenfootImage("canhoneiro.png"),
            new GreenfootImage("canhoneiro-after-shoot.png"),
            300);
    }
    
    @Override
    public void atirar() {
        //chama a animação da superclasse
        super.atirar();
        
        // cria o tiro
        getWorld().addObject(new TiroCanhoneiro(8), getX(), getY() + 40);
        Greenfoot.playSound("canhoneiro.mp3");
    }
}
