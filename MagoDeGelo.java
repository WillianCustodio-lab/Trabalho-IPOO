import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Inimigo da torre para a Fase 2: Mago de Gelo.
 * Usará imagens e sons próprios.
 */

public class MagoDeGelo extends InimigoTorre
{
    public MagoDeGelo() {
        super(
            new GreenfootImage("ice-wizard.png"),
            new GreenfootImage("ice-wizard-afterShoot.png"),
            360);
    }
    
    @Override
    public void atirar() {
        //chama a animação da superclasse
        super.atirar();
        
        // cria o tiro
        getWorld().addObject(new TiroMagoDeGelo(6), getX(), getY() + 40);
        Greenfoot.playSound("icewizard.mp3");
    }
}
