import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Torna o MegaCavaleiro um obstaculo para evitar que o goblin passe por ele
 */
public class Boss extends Obstaculo
{
    public Boss() {     //cria uma imagem transparente.
        GreenfootImage imagemInvisivel = new GreenfootImage(60, 60); 
        
        // Define esta imagem para a agua
        setImage(imagemInvisivel);
    }
}
