import greenfoot.*;
import java.util.List;

/**
 * Representa o inimigo (bárbaro) dentro do jogo.
 * Ele possui comportamento próprio, movimento automático e animações nas quatro direções.
 */
public class Inimigo extends Actor {
    private int velocidade = 2;
    private String direcao = "down"; // direções possíveis: up, down, left, right

    // Controle de animação do inimigo
    private ControleAnimacao front, back, left, right;

    // Classes auxiliares que separam a lógica de movimento e comportamento
    private MovimentoInimigo movimento;
    private ComportamentoInimigo comportamento;

    /**
     * Construtor: inicializa as animações e as classes que controlam o inimigo.
     */
    public Inimigo() {
        // Cria as animações para cada direção
        front = new ControleAnimacao(10, carregarImagens("front", 4));
        back = new ControleAnimacao(10, carregarImagens("back", 4));
        left = new ControleAnimacao(10, carregarImagens("left", 4));
        right = new ControleAnimacao(10, carregarImagens("right", 4));
        setImage(front.proximoFrame());

        // Configura as classes auxiliares que cuidam do comportamento e do movimento
        movimento = new MovimentoInimigo(this, velocidade);
        comportamento = new ComportamentoInimigo(this);
    }

    /**
     * Método principal do ciclo do inimigo.
     * Define a nova direção com base no comportamento e move o personagem.
     */
    public void act() {
        direcao = comportamento.definirNovaDirecao(direcao);
        movimento.mover(direcao);
        animar();
    }

    /**
     * Troca as imagens de acordo com a direção atual,
     * criando o efeito de animação contínua.
     */
    private void animar() {
        switch (direcao) {
            case "down":  
                setImage(front.proximoFrame());  
                break;
            case "up":    
                setImage(back.proximoFrame());   
                break;
            case "left":  
                setImage(left.proximoFrame());   
                break;
            case "right": 
                setImage(right.proximoFrame());  
                break;
        }
    }

    /**
     * Carrega as imagens da animação de acordo com a direção informada.
     */
    private GreenfootImage[] carregarImagens(String direcao, int total) {
        GreenfootImage[] imagens = new GreenfootImage[total];
        for (int i = 0; i < total; i++) {
            imagens[i] = new GreenfootImage("barb-" + direcao + (i + 1) + ".png");
        }
        return imagens;
    }

    /**
     * Verifica se há um obstáculo na direção desejada.
     * Usado pelo movimento para evitar colisões.
     */
    public boolean temObstaculo(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Obstaculo.class) != null;
    }
}
