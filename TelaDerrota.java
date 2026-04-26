import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * Mostra a tela de derrota ao encerrar o jogo.
 */
public class TelaDerrota extends World
{
    private int faseAtual;

    /**
     * Constructor for objects of class TelaDerrota.
     * 
     */
    public TelaDerrota(int faseAtual)
    {    
        // Create a new world with 900x600 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        
        long tempo = CronometroGlobal.getTempo(faseAtual);
        
        showText("Pontuação: " + Pontuacao.getPontos(), 765, 300);
        showText("Tempo da fase: " + tempo + "s", 765, 340);
        
        this.faseAtual = faseAtual;
    }
    
    //Reinicia o jogo
    public void act() {
        if(Greenfoot.isKeyDown("enter")) {
            switch(faseAtual) {
               case 1: 
                   Greenfoot.setWorld(new Fase1());
                   break;
               case 2: 
                   Greenfoot.setWorld(new Fase2());
                   break;
               case 3: 
                   Greenfoot.setWorld(new Fase3());
                   break;
               default:
                   Greenfoot.setWorld(new TelaInicial());
                   break;
           }
        }
    }
}
