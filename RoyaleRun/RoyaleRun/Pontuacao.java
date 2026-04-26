/**
 * Classe responsável por controlar a pontuação do jogador.
 * Armazena, soma, reseta e fornece o valor atual dos pontos.
 * Também define o limite de pontuação para liberar a saída da fase.
 */
public class Pontuacao {
    private static int pontos = 0;                  // armazena a pontuação atual
    private static final int PONTUACAOLIMITE = 100; // valor necessário para abrir a torre do rei

    /**
     * Soma pontos ao total atual.
     * Chamado, por exemplo, quando o jogador coleta uma coroa.
     */
    public static void adicionar(int valorAdiciona) {
        pontos += valorAdiciona;
    }
    
    /**
     * Reinicia a pontuação para zero.
     * Usado no início de cada nova fase.
     */
    public static void resetar() {
        pontos = 0;
    }
    
    /**
     * Retorna o valor atual da pontuação.
     */
    public static int getPontos() {
        return pontos;
    }
    
    /**
     * Retorna o valor limite necessário para abrir a saída da fase.
     */
    public static int getPontuacaoLimite() {
        return PONTUACAOLIMITE;
    }
}
