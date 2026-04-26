import greenfoot.*;

/**
 * Classe principal do jogador.
 * 
 * Reúne tudo o que é comum às três fases:
 * - movimentação
 * - animações
 * - coleta de itens
 * - colisões com inimigos
 * - controle de tiro
 * 
 * As fases seguintes podem ampliar o comportamento
 * sobrescrevendo métodos específicos.
 */
public class JogadorBase extends Actor {
    
    private Pontuacao pontuacao = new Pontuacao();
    
    // Controle geral do jogador
    private boolean estaVivo = true;
    private String direcao = "front";
    private int velocidade = 3;

    // Animações organizadas por direção
    private ControleAnimacao front, back, left, right;

    // Controle do tempo entre tiros
    private ControleDeTiro controleTiro = new ControleDeTiro(20);

    /**
     * Construtor que prepara as animações do goblin.
     * Carrega as imagens de todas as direções.
     */
    public JogadorBase() {
        front = new ControleAnimacao(8, carregarImagens("front", 4));
        back  = new ControleAnimacao(8, carregarImagens("back", 4));
        left  = new ControleAnimacao(8, carregarImagens("left", 2));
        right = new ControleAnimacao(8, carregarImagens("right", 2));
        setImage(front.proximoFrame());
    }

    /**
     * Comportamento principal executado em cada ciclo.
     * Inclui movimento, animação, interações e tiro.
     */
    public void act() {
        if (!estaVivo) return;

        mover();
        animar();
        verificarColisaoItem();
        verificarColisaoInimigo();

        controleTiro.atualizar();
        if (Greenfoot.isKeyDown("space")) {
            controleTiro.atirar(getWorld(), getX(), getY());
        }
    }

    /**
     * Movimentação do jogador através das teclas WASD.
     * Define direção e aplica velocidade.
     */
    public void mover() {
        int dx = 0, dy = 0;

        if (Greenfoot.isKeyDown("a")) { dx = -velocidade; direcao = "left"; }
        if (Greenfoot.isKeyDown("d")) { dx =  velocidade; direcao = "right"; }
        if (Greenfoot.isKeyDown("w")) { dy = -velocidade; direcao = "back"; }
        if (Greenfoot.isKeyDown("s")) { dy =  velocidade; direcao = "front"; }

        moverSeNaoHaObstaculo(dx, dy);
    }

    /**
     * Move o jogador somente se não houver um obstáculo.
     * Permite deslizar no gelo sem bloquear movimento.
     */
    public void moverSeNaoHaObstaculo(int dx, int dy) {

        // gelo não bloqueia movimento
        if (getOneObjectAtOffset(dx, dy, Gelo.class) != null) {
            setLocation(getX() + dx, getY() + dy);
            return;
        }

        if (dx != 0 && !temObstaculo(dx, 0))
            setLocation(getX() + dx, getY());

        if (dy != 0 && !temObstaculo(0, dy))
            setLocation(getX(), getY() + dy);
    }

    /**
     * Detecta presença de um obstáculo no deslocamento.
     */
    private boolean temObstaculo(int dx, int dy) {
        return getOneObjectAtOffset(dx, dy, Obstaculo.class) != null;
    }

    /**
     * Atualiza a animação de acordo com a direção do movimento.
     */
    private void animar() {
        switch (direcao) {
            case "front": setImage(front.proximoFrame()); break;
            case "back":  setImage(back.proximoFrame()); break;
            case "left":  setImage(left.proximoFrame()); break;
            case "right": setImage(right.proximoFrame()); break;
        }
    }

    /**
     * Carrega as imagens referentes a cada direção do goblin.
     */
    private GreenfootImage[] carregarImagens(String direcao, int total) {
        GreenfootImage[] imgs = new GreenfootImage[total];
        for (int i = 0; i < total; i++) {
            imgs[i] = new GreenfootImage("goblin" + (i+1) + "-" + direcao + ".png");
        }
        return imgs;
    }

    /**
     * Verifica se há algum item tocando o jogador.
     * Caso exista, delega o comportamento ao item.
     */
    private void verificarColisaoItem() {
        ItemBase item = (ItemBase)getOneIntersectingObject(ItemBase.class);
        if (item != null) {
            item.coletar(this);
        }
    }

    /**
     * Detecta inimigos. Ao colidir, o jogador perde a partida.
     */
    private void verificarColisaoInimigo() {
        InimigoBase inimigo = (InimigoBase)getOneIntersectingObject(InimigoBase.class);

        if (inimigo != null) {
            estaVivo = false;

            if (getWorld() instanceof FaseBase) {
                ((FaseBase)getWorld()).jogadorDerrotado();
            }
        }
    }

    // Métodos básicos de acesso

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int v) {
        velocidade = v;
    }

    public String getDirecao() {
        return direcao;
    }

    public void matarJogador() {
        estaVivo = false;
    }
    
    public Pontuacao getPontuacao() {
        return pontuacao;
    }

    // Métodos sobrescritos por jogador das fases seguintes

    public void coletarChave() {}

    public boolean podeUsarElixir() {
        return false;
    }

    public void ativarVelocidadeTemporaria(int aumento, int duracao) {}
}
