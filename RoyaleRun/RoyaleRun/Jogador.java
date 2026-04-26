import greenfoot.*;

/**
 * Classe principal que representa o jogador (Goblin).
 * Controla o movimento, as animações, o disparo de projéteis
 * e as interações com itens e inimigos.
 */
public class Jogador extends Actor {
    private boolean estaVivo = true;      // controla se o jogador ainda está ativo no jogo
    private String direcao = "front";     // armazena a direção atual do movimento
    private final int VELOCIDADE = 3;     // define a velocidade de deslocamento do jogador

    // Animações para cada direção
    private ControleAnimacao front, back, left, right;

    // Responsável por controlar o tempo entre disparos
    private ControleDeTiro controleTiro = new ControleDeTiro(15);

    /**
     * Construtor: inicializa as animações do personagem.
     * Cada direção tem uma sequência própria de imagens.
     */
    public Jogador() {
        front = new ControleAnimacao(8, carregarImagens("front", 4));
        back  = new ControleAnimacao(8, carregarImagens("back", 4));
        left  = new ControleAnimacao(8, carregarImagens("left", 2));
        right = new ControleAnimacao(8, carregarImagens("right", 2));
        setImage(front.proximoFrame());
    }

    /**
     * Executa as ações principais do jogador a cada ciclo do jogo.
     */
    public void act() {
        if (!estaVivo) 
            return;

        mover();
        animar();
        verificarColisaoItem();
        verificarColisaoInimigo();
        atualizarPontuacao();

        // Controle de disparos
        controleTiro.atualizar();
        if (Greenfoot.isKeyDown("space")) {
            controleTiro.atirar(getWorld(), getX(), getY());
        }
    }

    // Movimentação

    /**
     * Detecta as teclas pressionadas e define o deslocamento.
     * Atualiza também a direção para a animação correspondente.
     */
    private void mover() {
        int dx = 0, dy = 0;

        if (Greenfoot.isKeyDown("a")) { 
            dx = -VELOCIDADE; 
            direcao = "left"; 
        }
        if (Greenfoot.isKeyDown("d")) { 
            dx =  VELOCIDADE; 
            direcao = "right"; 
        }
        if (Greenfoot.isKeyDown("w")) { 
            dy = -VELOCIDADE; 
            direcao = "back"; 
        }
        if (Greenfoot.isKeyDown("s")) { 
            dy =  VELOCIDADE; 
            direcao = "front"; 
        }

        moverSeNaoHaObstaculo(dx, dy);
    }

    /**
     * Move o jogador somente se não houver obstáculos na direção desejada.
     */
    private void moverSeNaoHaObstaculo(int dx, int dy) {
        if (dx != 0 && !temObstaculo(dx, 0))
            setLocation(getX() + dx, getY());
        if (dy != 0 && !temObstaculo(0, dy))
            setLocation(getX(), getY() + dy);
    }

    /**
     * Verifica se há um obstáculo na direção do movimento.
     */
    private boolean temObstaculo(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Obstaculo.class) != null;
    }

    // Animação

    /**
     * Atualiza a imagem do jogador conforme a direção atual.
     */
    private void animar() {
        if (direcao.equals("front"))      
            setImage(front.proximoFrame());
        else if (direcao.equals("back"))  
            setImage(back.proximoFrame());
        else if (direcao.equals("left"))  
            setImage(left.proximoFrame());
        else if (direcao.equals("right")) 
            setImage(right.proximoFrame());
    }

    /**
     * Carrega as imagens de animação para uma direção específica.
     */
    private GreenfootImage[] carregarImagens(String direcao, int total) {
        GreenfootImage[] imgs = new GreenfootImage[total];
        for (int i = 0; i < total; i++) {
            imgs[i] = new GreenfootImage("goblin" + (i + 1) + "-" + direcao + ".png");
        }
        return imgs;
    }

    // Colisões

    /**
     * Verifica se o jogador coletou uma coroa.
     * Ao coletar, ganha pontos e a coroa é removida do mundo.
     */
    private void verificarColisaoItem() {
        ItemCoroa coroa = (ItemCoroa)getOneIntersectingObject(ItemCoroa.class);
        if (coroa != null) {
            Pontuacao.adicionar(10);
            getWorld().removeObject(coroa);
            Greenfoot.playSound("coroa.mp3");
        }
    }

    /**
     * Verifica colisão com inimigos.
     * Caso encoste em um, o jogador morre e o jogo vai para a tela de derrota.
     */
    private void verificarColisaoInimigo() {
        Inimigo inimigo = (Inimigo)getOneIntersectingObject(Inimigo.class);
        if (inimigo != null) {
            estaVivo = false;
            Fase1 fase = (Fase1) getWorld();
            fase.jogadorDerrotado();
        }
    }

    /**
     * Atualiza o texto da pontuação no canto da tela.
     */
    private void atualizarPontuacao() {
        getWorld().showText("Pontuação: " + Pontuacao.getPontos(), 70, 30);
    }
}
