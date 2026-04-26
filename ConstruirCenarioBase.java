import greenfoot.*;
import java.util.List; 

/**
 * Classe base responsável por gerar elementos comuns do cenário,
 * como o rio e as bordas laterais do mapa.
 * 
 * As fases específicas vão herdar desta classe..
 */
public class ConstruirCenarioBase {
    private FaseBase mundo;

    /**
     * Recebe uma referência ao mundo principal,
     * permitindo adicionar objetos diretamente nele.
     */
    public ConstruirCenarioBase(FaseBase mundo) {
        this.mundo = mundo;
    }

     /**
     * Método vazio que as subclasses vão sobrescrever para
     * adicionar o conteúdo principal do cenário.
     */
    public void construirCenarioBase() {
        // Subclasses irão sobrescrever
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
