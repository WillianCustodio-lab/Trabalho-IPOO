import greenfoot.*;

/**
 * Jogador usado na Fase 3.
 * 
 * Inclui:
 * • velocidade temporária ativada pelo Elixir Negro
 * • controle da chave para liberar a saída
 * • tratamento especial quando o chefe derrota o jogador
 */
public class JogadorFase3 extends JogadorBase {

    private static boolean chaveColetada;

    private boolean velocidadeTempAtiva = false;
    private int tempoVelTemp = 0;
    
    public JogadorFase3() {
        chaveColetada = false;
    }
    
    @Override
    public void act() {
        atualizarVelocidadeTemporaria();
        super.act();
    }

    // Velocidade Temporária (elixir)
    /**
     * Ativa um aumento temporário de velocidade.
     * O valor aumenta imediatamente e dura até o tempo acabar.
     */
    public void ativarVelocidadeTemporaria(int aumento, int duracao) {
        setVelocidade(getVelocidade() + aumento);
        velocidadeTempAtiva = true;
        tempoVelTemp = duracao;
    }

    /**
     * Conta a duração da velocidade extra.
     * Quando o tempo chega ao fim, a velocidade volta ao normal.
     */
    private void atualizarVelocidadeTemporaria() {
        if (!velocidadeTempAtiva) return;

        tempoVelTemp--;
        if (tempoVelTemp <= 0) {
            velocidadeTempAtiva = false;
            setVelocidade(3);
        }
    }
    
    /**
     * Usado quando o chefe da fase 3 atinge o jogador.
     * Desativa o jogador e pede à fase que trate a derrota.
     */
    public void morrerPorAtaqueChefe() {
        matarJogador();
    
        World mundo = getWorld();
        if (mundo instanceof FaseBase) {
            ((FaseBase) mundo).jogadorDerrotado();
        }
    }
    
    /**
     * Permite que o jogador desta fase utilize o Elixir Negro.
     */
    public boolean podeUsarElixir() {
        return true; 
    }

    // Chave da Fase
    /**
     * Marca que a chave foi coletada.
     */
    public void coletarChave() {
        chaveColetada = true;
    }

    /**
     * Indica se o jogador já pegou a chave.
     * Usado pela fase para liberar a saída.
     */
    public static boolean temChave() {
        return chaveColetada;
    }
}
