import greenfoot.*;

/**
 * Superclasse para todos os inimigos do jogo.
 * Armazena os atributos e funcionalidades que são comuns a qualquer inimigo,
 * como velocidade, direção, animações e verificação de obstáculos.
 * 
 * As subclasses (Barbaro, GolemDeGelo, etc.) apenas configuram suas animações
 * e comportamentos utilizando os métodos fornecidos aqui.
 */
public class InimigoBase extends Actor {
    
    private int vida = 1;
    private int velocidade = 2;          // velocidade padrão do inimigo
    private String direcao = "down";     // direção atual da animação

    // Animações em cada direção
    private ControleAnimacao front;
    private ControleAnimacao back;
    private ControleAnimacao left;
    private ControleAnimacao right;

    /**
     * Carrega os frames de animação de acordo com a direção e prefixo do inimigo.
     * direcao  direção (front, back, left, right)
     * total    quantidade de imagens
     * prefixo  nome base dos arquivos
     */
    public GreenfootImage[] carregarImagens(String direcao, int total, String prefixo) {
        GreenfootImage[] imagens = new GreenfootImage[total];
        for (int i = 0; i < total; i++) {
            imagens[i] = new GreenfootImage(prefixo + "-" + direcao + (i + 1) + ".png");
        }
        return imagens;
    }

    /**
     * Define as animações do inimigo, usadas pelas subclasses.
     * Após configurar, já define a imagem inicial.
     */
    public void setAnimacoes(ControleAnimacao front,
                             ControleAnimacao back,
                             ControleAnimacao left,
                             ControleAnimacao right) {
        this.front = front;
        this.back = back;
        this.left = left;
        this.right = right;

        if (this.front != null)
            setImage(this.front.proximoFrame());
    }

    public void setVelocidade(int v) {
        velocidade = v;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setDirecao(String d) {
        direcao = d;
    }

    public String getDirecao() {
        return direcao;
    }

    /**
     * Atualiza o frame da animação de acordo com a direção atual.
     */
    public void animar() {
        if (front == null) return;

        switch (direcao) {
            case "down":  setImage(front.proximoFrame());  break;
            case "up":    setImage(back.proximoFrame());   break;
            case "left":  setImage(left.proximoFrame());   break;
            case "right": setImage(right.proximoFrame());  break;
        }
    }

    /**
     * Verifica se existe um obstáculo na posição desejada.
     */
    public boolean temObstaculo(int dx, int dy) {
        Actor obj = getOneObjectAtOffset(dx, dy, Obstaculo.class);
    
        // Se não encostou em nada → não tem obstáculo
        if (obj == null)
            return false;
    
        // Se encostou em gelo → não é obstáculo para inimigos
        if (obj instanceof Gelo)
            return false;
    
        // Caso contrário → é obstáculo real
        return true;
    }
    
    public void setVida(int v) {
        vida = v;
    }

    public void levarDano() {
        vida--;
    
        if (vida <= 0) {
            morrer();
        }
    }
    
    /**
     * Remove o inimigo do jogo.
     * Subclasses podem sobrescrever para adicionar efeitos.
     */
    public void morrer() {
        World w = getWorld();
        if (w != null) {
            w.removeObject(this);
        }
    }
}
