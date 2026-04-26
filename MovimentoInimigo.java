import greenfoot.*;

/**
 * Responsável por movimentar o inimigo dentro do cenário.
 * Recebe a direção desejada e aplica o deslocamento,
 * respeitando obstáculos e tentando contornar quando possível.
 */
public class MovimentoInimigo {
    private InimigoBase inimigo;  // referência ao inimigo que será movido
    private int velocidade;   // define o quanto ele anda por vez

    public MovimentoInimigo(InimigoBase inimigo, int velocidade) {
        this.inimigo = inimigo;
        this.velocidade = velocidade;
    }

    /**
     * Move o inimigo conforme a direção indicada.
     * Se houver um obstáculo, ele tenta desviar levemente.
     */
    public void mover(String direcao) {
        int dx = 0, dy = 0;

        // Define o deslocamento com base na direção
        if (direcao.equals("up")) 
            dy = -velocidade;
        else if (direcao.equals("down")) 
            dy = velocidade;
        else if (direcao.equals("left")) 
            dx = -velocidade;
        else if (direcao.equals("right")) 
            dx = velocidade;

        // Se não há obstáculo, move normalmente
        if (!inimigo.temObstaculo(dx, dy)) {
            inimigo.setLocation(inimigo.getX() + dx, inimigo.getY() + dy);
        } 
        else {
            // Caso bata em algo, tenta desviar um pouco (movimento simples de contorno)
            if (direcao.equals("left") || direcao.equals("right")) {
                if (!inimigo.temObstaculo(0, dy)) {
                    inimigo.setLocation(inimigo.getX(), inimigo.getY() + dy);
                }
            }
        }
    }
}
