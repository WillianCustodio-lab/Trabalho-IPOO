import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Inimigo da torre para a Fase 1: Princesa.
 * Define imagens, som e tipo de tiro.
 */
public class Princesa extends InimigoTorre
{
    public Princesa() {
        super(
            new GreenfootImage("princess.png"),
            new GreenfootImage("princess-after-shoot.png"),
            420);
    }
    
    @Override
    public void atirar() {
        //chama a animação da superclasse
        super.atirar();
        
        // cria o tiro
        getWorld().addObject(new TiroPrincesa(4), getX(), getY() + 40);
        Greenfoot.playSound("princess.wav");
    }
}
