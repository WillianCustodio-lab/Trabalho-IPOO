import greenfoot.*;

/**
 * Representa o projétil disparado pelo jogador.
 * 
 * O tiro se move na direção indicada e desaparece ao:
 *  atingir um inimigo (removendo-o do jogo);
 *  colidir com um obstáculo;
 *  ou sair dos limites do mundo.
 */
public class Tiro extends Actor {
    private int velocidade = 8;   // velocidade de deslocamento do projétil
    private boolean removido = false; // evita remoções múltiplas

    /**
     * Construtor que define o ângulo de disparo.
     */
    public Tiro(int angulo) {
        setRotation(angulo);
    }

    /**
     * Executado a cada ciclo do jogo.
     * Controla o movimento e as colisões do tiro.
     */
    public void act() {
        if (removido) return;

        // movimenta o tiro na direção do ângulo definido
        move(velocidade);

        // verifica colisão com inimigo
        Inimigo inimigo = (Inimigo) getOneIntersectingObject(Inimigo.class);
        if (inimigo != null && getWorld() != null) {
            getWorld().removeObject(inimigo);
            removerTiro();
            return;
        }

        // verifica colisão com obstáculo
        Obstaculo obstaculo = (Obstaculo) getOneIntersectingObject(Obstaculo.class);
        if (obstaculo != null && getWorld() != null) {
            removerTiro();
            return;
        }

        // remove o tiro se ele sair da tela
        if (getWorld() != null && isAtEdge()) {
            removerTiro();
        }
    }

    /**
     * Remove o tiro.
     */
    private void removerTiro() {
        if (getWorld() != null) {
            getWorld().removeObject(this);
            removido = true;
        }
    }
}
