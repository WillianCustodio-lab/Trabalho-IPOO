import greenfoot.*;

/**
 * Responsável por gerar inimigos Bárbaros de forma periódica.
 */
public class GerarBarbaros {

    private FaseBase fase;   // referência à fase onde os bárbaros surgirão
    private int contador = 0;
    private int intervalo = 340; // tempo entre os spawns

    public GerarBarbaros(FaseBase fase) {
        this.fase = fase;
    }

    /**
     * Chamado uma vez por ciclo no método act() da fase.
     * Quando o contador atinge o intervalo, um novo bárbaro é gerado.
     */
    public void atualizar() {
        contador++;
        if (contador >= intervalo) {
            contador = 0;
            gerarBarbaro();
        }
    }

    /**
     * Gera um novo Bárbaro na posição fixa do mapa.
     */
    private void gerarBarbaro() {
        fase.addObject(new Barbaro(), 465, 310);
        Greenfoot.playSound("barbaros.wav");
    }
}
