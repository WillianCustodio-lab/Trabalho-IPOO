import greenfoot.*;

/**
 * Projétil disparado pelos inimigos que ficam nas torres.
 * 
 * Se move para baixo até:
 * - acertar o jogador
 * - ou sair dos limites do mundo
 *
 * Quando acerta o jogador, remove o jogador do mapa e notifica
 * a fase para encerrar a partida com derrota.
 */
public class TiroTorre extends Actor {
    
    private int velocidade;

    /**
     * Cria o tiro já configurado para descer.
     */
    public TiroTorre(int velocidade) {
        setRotation(90);
        this.velocidade = velocidade;
    }

    /**
     * Roda a cada ciclo.
     * Movimenta o tiro e verifica colisões.
     */
    public void act() {
        move(velocidade);
        verificarColisaoJogador();
        verificarLimite();
    }

    /**
     * Quando o tiro encosta no jogador:
     * - remove o jogador
     * - marca o jogador como morto
     * - chama o método de derrota da fase
     * - remove o próprio tiro
     */
    private void verificarColisaoJogador() {

        JogadorBase jogador = (JogadorBase) getOneIntersectingObject(JogadorBase.class);

        if (jogador != null) {

            World w = getWorld();

            w.removeObject(jogador);
            jogador.matarJogador();

            if (w instanceof FaseBase fase) {
                fase.jogadorDerrotado();
            }

            w.removeObject(this);
        }
    }

    /**
     * Remove o tiro assim que ele sai da tela.
     */
    private void verificarLimite() {
        if (getWorld() != null && isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
