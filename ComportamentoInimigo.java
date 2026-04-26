import greenfoot.*;
import java.util.List;

/**
 * Classe responsável por definir o comportamento inteligente do inimigo.
 * Ela decide quando mudar de direção, perseguir o jogador ou mirar nas coroas.
 */
public class ComportamentoInimigo {
    private InimigoBase inimigo;

    public ComportamentoInimigo(InimigoBase inimigo) {
        this.inimigo = inimigo;
    }

    /**
     * Define a nova direção do inimigo a cada ciclo.
     * Há uma pequena chance de mudar de forma aleatória,
     * mirar em uma coroa ou perseguir o jogador.
     */
    public String definirNovaDirecao(String direcaoAtual) {
        // chance pequena de mudar de direção naturalmente
        if (Greenfoot.getRandomNumber(100) < 2) {
            return novaDirecaoAleatoria();
        }

        // chance pequena de mirar em uma coroa
        if (Greenfoot.getRandomNumber(100) < 2) {
            ItemCoroa coroa = buscarCoroa();
            if (coroa != null) {
                return ajustarDirecaoPara(coroa.getX(), coroa.getY());
            }
        }

        // chance pequena de perseguir o jogador
        if (Greenfoot.getRandomNumber(100) < 3) {
            JogadorBase jogador = buscarJogador();
            if (jogador != null) {
                return ajustarDirecaoPara(jogador.getX(), jogador.getY());
            }
        }

        // mantém a mesma direção se nada ocorrer
        return direcaoAtual;
    }

    // Métodos auxiliares

    /**
     * Escolhe aleatoriamente uma das quatro direções principais.
     */
    private String novaDirecaoAleatoria() {
        String[] direcoes = {"up", "down", "left", "right"};
        return direcoes[Greenfoot.getRandomNumber(direcoes.length)];
    }

    /**
     * Busca uma coroa aleatória no mundo (usada como alvo).
     */
    private ItemCoroa buscarCoroa() {
        List<ItemCoroa> coroas = inimigo.getWorld().getObjects(ItemCoroa.class);
        if (!coroas.isEmpty()) {
            return coroas.get(Greenfoot.getRandomNumber(coroas.size()));
        }
        return null;
    }

    /**
     * Busca o jogador no mundo (geralmente há apenas um).
     */
    private JogadorBase buscarJogador() {
        List<JogadorBase> jogadores = inimigo.getWorld().getObjects(JogadorBase.class);
        if (!jogadores.isEmpty()) {
            return jogadores.get(0);
        }
        return null;
    }

    /**
     * Calcula qual direção seguir (horizontal ou vertical)
     * com base na posição do alvo.
     */
    private String ajustarDirecaoPara(int x, int y) {
        int dx = x - inimigo.getX();
        int dy = y - inimigo.getY();

        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) 
                return "right";
            else 
                return "left";
        } else {
            if (dy > 0) 
                return "down";
            else 
                return "up";
        }
    }
}
