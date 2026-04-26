import greenfoot.*;
import java.util.List; 

/**
 * Classe responsável por montar todos os elementos do cenário da fase.
 * Ela organiza a posição das torres, personagens, obstáculos e limites do mapa.
 */
public class ConstruirCenario {
    private Fase1 mundo;

    /**
     * Recebe uma referência ao mundo principal (Fase1),
     * permitindo adicionar objetos diretamente nele.
     */
    public ConstruirCenario(Fase1 mundo) {
        this.mundo = mundo;
    }

    /**
     * Cria os elementos principais do cenário: torres, personagens e estruturas fixas.
     */
    public void construirCenarioBase() {
        // Obstáculos fixos
        mundo.addObject(new Vines(), 470, 450);
        mundo.addObject(new Vines(), 200, 300);
        
        // Torres
        mundo.addObject(new TorrePrincesa(), 270, 180);
        mundo.addObject(new TorrePrincesa(), 655, 180);
        mundo.addObject(new TorreRei(), 465, 70);
        
        // Personagens fixos
        mundo.addObject(new Princesa(), 270, 150);
        mundo.addObject(new Princesa(), 655, 150);
        mundo.addObject(new Rei(), 465, 35);
        
        // Estrutura que gera inimigos
        mundo.addObject(new CabanaBarbaros(), 465, 250);
        
        // Jogador principal
        mundo.addObject(new Jogador(), 250, 350);
        Greenfoot.playSound("entradaDartGoblin.wav"); // som de entrada
    }

    /**
     * Cria os obstáculos secundários do mapa, como o rio e as bordas laterais.
     */
    public void gerarAmbiente() {
        mapearRioComoObstaculo();
        mapearRestricaoCenario();
    }

    /**
     * Desenha o rio no cenário, impedindo a passagem de personagens.
     * A ponte é deixada livre para passagem.
     */
    public void mapearRioComoObstaculo() {
        int yRioInicio = 460; 
        int yRioFim = 500;   
        int passo = 10;      

        // Posição da ponte (área livre)
        int xPonteInicio = 260;
        int xPonteFim = 670;

        for (int y = yRioInicio; y <= yRioFim; y += passo) {
            for (int x = 160; x < 780; x += passo) {
                // Cria as áreas de água, exceto nas coordenadas da ponte
                if (x < xPonteInicio || x > xPonteFim)
                    mundo.addObject(new Agua(), x, y);
                else if (x > 290 && x < 640) { // rio entre as pontes centrais
                    mundo.addObject(new Agua(), x, y);                    
                }
            }
        }
    }

    /**
     * Adiciona barreiras invisíveis nas laterais do mapa para evitar que
     * o jogador ou inimigos saiam da área de combate.
     */
    public void mapearRestricaoCenario() {
        int yCenarioInicio = 0;
        int espacamento = 10;

        // Limites horizontais do campo jogável
        int xInicioCampo = 170;
        int xTerminoCampo = 730;

        for (int y = yCenarioInicio; y <= mundo.getHeight(); y += espacamento) {
            for (int x = 0; x < mundo.getWidth(); x += espacamento) {
                if (x < xInicioCampo || x > xTerminoCampo)
                    mundo.addObject(new RestricaoCenario(), x, y);
            }
        }
    }
}
