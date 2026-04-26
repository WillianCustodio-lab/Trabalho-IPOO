import greenfoot.*;

/**
 * Representa o projétil disparado pela Princesa.
 * 
 * Ele se move para baixo e, ao colidir com o jogador,
 * causa o fim da partida. Também é removido ao sair da tela.
 */
public class TiroPrincesa extends Actor {
    private int velocidade = 4;

    /**
     * Construtor: define a direção inicial do tiro.
     */
    public TiroPrincesa() {
        setRotation(90); // define o disparo para baixo
    }

    /**
     * Atualiza o comportamento do tiro a cada ciclo.
     */
    public void act() {
        move(velocidade);
        verificarColisaoJogador();
        verificarLimite();
    }

    /**
     * Detecta colisão com o jogador.
     * Se o jogador for atingido, encerra a partida.
     */
    private void verificarColisaoJogador() {
        Jogador jogador = (Jogador) getOneIntersectingObject(Jogador.class);
        if (jogador != null && getWorld() != null) {
            getWorld().removeObject(jogador);

            Fase1 fase = (Fase1) getWorld();
            fase.jogadorDerrotado();
        }
    }

    /**
     * Remove o tiro ao sair dos limites do mundo.
     */
    private void verificarLimite() {
        if (getWorld() != null && isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
