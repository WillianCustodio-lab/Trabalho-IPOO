import greenfoot.*;

/**
 * Classe responsável por gerar novas coroas no mapa de tempos em tempos.
 * As coroas aparecem em locais livres, longe de obstáculos e do jogador.
 */
public class GeradorCoroas {
    private Fase1 fase;       // referência para o mundo onde serão adicionadas as coroas
    private int contador = 0; // controla o intervalo de geração

    public GeradorCoroas(Fase1 fase) {
        this.fase = fase;
    }

    /**
     * Atualiza o gerador a cada frame.
     * Quando o contador atinge o tempo definido, cria uma nova coroa em posição aleatória.
     */
    public void atualizar() {
        contador++;
        
        // A cada 480 frames (~8 segundos, dependendo da taxa de atualização)
        if (contador >= 480) {
            int[] pos = encontrarPosicaoLivre();
            if (pos != null) {
                fase.addObject(new ItemCoroa(), pos[0], pos[1]);
            }
            contador = 0;
        }
    }

    /**
     * Escolhe uma posição aleatória no mapa que esteja livre de obstáculos, jogador e outras coroas.
     * Faz até 20 tentativas antes de desistir, para evitar loop infinito.
     */
    private int[] encontrarPosicaoLivre() {
        for (int tentativas = 0; tentativas < 20; tentativas++) {
            int x = Greenfoot.getRandomNumber(fase.getWidth());
            int y = Greenfoot.getRandomNumber(fase.getHeight());

            boolean areaLivre =
                fase.getObjectsAt(x, y, Obstaculo.class).isEmpty() &&
                fase.getObjectsAt(x, y, Jogador.class).isEmpty() &&
                fase.getObjectsAt(x, y, ItemCoroa.class).isEmpty();

            if (areaLivre) {
                return new int[] {x, y};
            }
        }
        return null; // se não achar uma posição válida
    }
}
