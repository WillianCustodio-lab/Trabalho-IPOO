import greenfoot.*;

/**
 * Bloco de gelo criado pelo Golem quando morre.
 * 
 * Sua função na Fase 2 é apenas existir no mundo e ser detectado pelo jogador.
 * A redução de velocidade é tratada dentro de JogadorFase2, 
 */
public class Gelo extends Obstaculo {

    public void act() {
        // Nenhuma ação necessária.
        // O jogador detecta o gelo sozinho usando getOneIntersectingObject().
    }
}
