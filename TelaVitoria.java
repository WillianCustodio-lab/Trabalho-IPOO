import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Tela de vitória ao atingir a pontuação do jogo
 */
public class TelaVitoria extends World
{
    private int faseAtual;    
    /**
     * Constructor for objects of class TelaVitoria.
     * 
     */
    public TelaVitoria(int faseAtual)
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        
        long tempo = CronometroGlobal.getTempo(faseAtual);
        
        showText("Pontuação: " + Pontuacao.getPontos(), 755, 300);
        showText("Tempo da fase: " + tempo + "s", 755, 340);
        
        this.faseAtual = faseAtual;
    }
    
    //controla qual será a proxima tela a partir de sua fase atual
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
           switch(faseAtual) {
               case 1: 
                   Greenfoot.setWorld(new Fase2());
                   break;
               case 2: 
                   Greenfoot.setWorld(new Fase3());
                   break;
               default:
                   Greenfoot.setWorld(new TelaInicial());
                   break;
           }
        }
    }
}
