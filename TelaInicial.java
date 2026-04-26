import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela Inicial do jogo
 */
public class TelaInicial extends World
{
    private GreenfootSound musicaFundo = new GreenfootSound("TelaInicial2.mp3");

    /**
     * Constructor for objects of class TelaInicial.
     * 
     */
    public TelaInicial()
    {    
        //tamanho da tela
        super(900, 600, 1); 
        iniciarCenario();
    }
    
    //botões de interação com o usuário
    public void iniciarCenario() {
        addObject(new BotaoStart(), 450, 170);
        addObject(new BotaoQuit(), 450, 230);
    }
    
    public void started() {
        musicaFundo.playLoop();
    }

    public void stopped() {
        musicaFundo.stop();
    }
}
