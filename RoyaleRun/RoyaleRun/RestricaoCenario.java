import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Limita a area lateral do cenário
 */
public class RestricaoCenario extends Obstaculo
{
    /**
     * Act - do whatever the RestricaoCenario wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public RestricaoCenario() {
        //cria uma imagem transparente.
        GreenfootImage imagemInvisivel = new GreenfootImage(20, 20); 
    
        // Define esta imagem para a restrição do cenário
        setImage(imagemInvisivel);
    }
}
