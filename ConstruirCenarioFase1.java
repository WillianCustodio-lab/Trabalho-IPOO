import greenfoot.*;

/**
 * Constrói os elementos específicos da fase 1.
 */
public class ConstruirCenarioFase1 extends ConstruirCenarioBase {

    private FaseBase mundo;

    public ConstruirCenarioFase1(FaseBase mundo) {
        super(mundo);
        this.mundo = mundo;
    }

    /**
     * Cria os elementos principais da fase1: torres, personagens e estruturas fixas.
     */
    @Override
    public void construirCenarioBase() {
        // Obstáculos fixos
        mundo.addObject(new Vines(), 470, 450);
        mundo.addObject(new Vines(), 200, 300);
        
        // Torres
        mundo.addObject(new Torre(), 270, 180);
        mundo.addObject(new Torre(), 655, 180);
        mundo.addObject(new TorreRei(), 465, 70);
        
        // Personagens fixos
        mundo.addObject(new Princesa(), 270, 150);
        mundo.addObject(new Princesa(), 655, 150);
        mundo.addObject(new Rei(), 465, 35);
        
        // Estrutura que gera inimigos
        mundo.addObject(new CabanaBarbaros(), 465, 250);
        
        // Jogador principal
        mundo.addObject(new JogadorFase1(), 450, 550);
        Greenfoot.playSound("entradaDartGoblin.wav"); // som de entrada
    }

}
