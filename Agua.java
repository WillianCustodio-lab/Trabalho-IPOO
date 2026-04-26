import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Limita a área do rio do cenário
 */
public class Agua extends Obstaculo
{
    /**
     * Act - do whatever the Agua wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Agua()
    {
        //cria uma imagem transparente.
        GreenfootImage imagemInvisivel = new GreenfootImage(20, 20); 
    
        // Define esta imagem para a agua
        setImage(imagemInvisivel);
    }
}
