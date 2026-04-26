import greenfoot.*;

/**
 * Constrói o cenário da terceira fase,
 */
public class ConstruirCenarioFase3 extends ConstruirCenarioBase {

    private FaseBase mundo;

    public ConstruirCenarioFase3(FaseBase mundo) {
        super(mundo);
        this.mundo = mundo;
    }

    @Override
    public void construirCenarioBase() {

        // Obstáculos básicos da fase 3
        mundo.addObject(new Lapide(), 530, 440);
        mundo.addObject(new Lapide(), 410, 440);

        mundo.addObject(new Vines(), 170, 300);
        
        // Torres congeladas
        mundo.addObject(new Torre(), 270, 180);
        mundo.addObject(new Torre(), 655, 180);
        mundo.addObject(new TorreRei(), 465, 70);

        // NPCs congelados
        mundo.addObject(new Canhoneiro(), 270, 150);
        mundo.addObject(new Canhoneiro(), 655, 150);
        mundo.addObject(new Rei(), 465, 35);

        // Chefão
        BarraVidaMega barra = new BarraVidaMega();
        mundo.addObject(barra, 465, 200);
        
        mundo.addObject(new MegaCavaleiro(barra), 465, 250);
        mundo.addObject(new Boss(), 465, 250);

        // Jogador da fase 2
        mundo.addObject(new JogadorFase3(), 450, 550);

        Greenfoot.playSound("entradaDartGoblin.wav");
        Greenfoot.playSound("mega-knight-spawn.mp3");
    }
}
