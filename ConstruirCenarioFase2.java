import greenfoot.*;

/**
 * Constrói o cenário da segunda fase,
 * com gelo, mago de gelo e o golem de gelo.
 */
public class ConstruirCenarioFase2 extends ConstruirCenarioBase {

    private FaseBase mundo;

    public ConstruirCenarioFase2(FaseBase mundo) {
        super(mundo);
        this.mundo = mundo;
    }

    @Override
    public void construirCenarioBase() {

        // Obstáculos básicos da fase
        mundo.addObject(new Ice(), 530, 410);
        mundo.addObject(new Ice(), 375, 410);

        // Torres congeladas
        mundo.addObject(new Torre(), 270, 180);
        mundo.addObject(new Torre(), 655, 180);
        mundo.addObject(new TorreRei(), 465, 70);

        // NPCs congelados
        mundo.addObject(new MagoDeGelo(), 270, 150);
        mundo.addObject(new MagoDeGelo(), 655, 150);
        mundo.addObject(new Rei(), 465, 35);

        // Estrutura que gera inimigos
        mundo.addObject(new CabanaBarbaros(), 465, 250);
        
        //Golens de gelo
        mundo.addObject(new GolemDeGelo(), 270, 110);
        mundo.addObject(new GolemDeGelo(), 655, 110);
        mundo.addObject(new GolemDeGelo(), 370, 200);
        mundo.addObject(new GolemDeGelo(), 565, 200);
        mundo.addObject(new GolemDeGelo(), 465, 375);

        // Jogador da fase 2
        mundo.addObject(new JogadorFase2(), 450, 550);

        Greenfoot.playSound("entradaDartGoblin.wav");
    }
}
