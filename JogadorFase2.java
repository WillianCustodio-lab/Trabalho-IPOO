/**
 * Jogador usado na Fase 2.
 * 
 * Inclui:
 * • redução de velocidade ao pisar no gelo
 * • velocidade temporária ao usar o Elixir Negro
 * • controle da chave para liberar a saída
 */
public class JogadorFase2 extends JogadorBase {

    private static boolean chaveColetada;

    private boolean velocidadeTempAtiva = false;
    private int tempoVelTemp = 0;
    
    public JogadorFase2() {
        chaveColetada = false;
    }
    
    @Override
    public void act() {
        atualizarVelocidadeTemporaria();
        verificarGelo();
        super.act();
    }

    //Gelo
    /**
     * Quando o jogador está em contato com o gelo,
     * sua velocidade é reduzida para simular escorregamento.
     * Se não estiver no gelo, retorna à velocidade normal,
     * exceto quando o efeito do Elixir Negro está ativo.
     */
    private void verificarGelo() {
        Gelo gelo = (Gelo)getOneIntersectingObject(Gelo.class);

        if (gelo != null) {
            setVelocidade(1);   // mais lento no gelo
        } else {
            if (!velocidadeTempAtiva) {
                setVelocidade(3); // valor padrão
            }
        }
    }

    // Velocidade temporária (elixir)
    /**
     * Ativa um aumento temporário de velocidade.
     * Usado quando o jogador coleta o Elixir Negro.
     */
    public void ativarVelocidadeTemporaria(int aumento, int duracao) {
        setVelocidade(getVelocidade() + aumento);
        velocidadeTempAtiva = true;
        tempoVelTemp = duracao;
    }

    /**
     * Conta o tempo do efeito do Elixir.
     * Assim que acabar, retorna à velocidade normal.
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
     * Retorna se o jogador já pegou a chave.
     * Usado pela fase para abrir a saída.
     */
    public static boolean temChave() {
        return chaveColetada;
    }
}
