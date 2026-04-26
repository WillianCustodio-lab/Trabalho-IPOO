import greenfoot.*;

/**
 * Inimigo Golem de Gelo.
 * Mais lento, possui vida extra e ao morrer cria um bloco de gelo no chão.
 * 
 * Reaproveita toda a estrutura da superclasse InimigoBase.
 */
public class GolemDeGelo extends InimigoBase {

    private int vida = 3;

    private MovimentoInimigo movimento;
    private ComportamentoInimigo comportamento;

    /**
     * Construtor do Golem de Gelo.
     * Configura animações, velocidade reduzida e comportamento de movimento.
     */
    public GolemDeGelo() {
        setVida(3);
        setVelocidade(1); // golem é mais lento

        // Animações usando prefixo "golem"
        ControleAnimacao front = new ControleAnimacao(12, carregarImagens("front", 4, "ice-golem"));
        ControleAnimacao back = new ControleAnimacao(12, carregarImagens("back", 4, "ice-golem"));
        ControleAnimacao left = new ControleAnimacao(12, carregarImagens("left", 3, "ice-golem"));
        ControleAnimacao right = new ControleAnimacao(12, carregarImagens("right", 3, "ice-golem"));

        setAnimacoes(front, back, left, right);

        movimento = new MovimentoInimigo(this, getVelocidade());
        comportamento = new ComportamentoInimigo(this);
    }

    /**
     * Loop principal do Golem.
     * Anda lentamente e segue o mesmo comportamento dos bárbaros.
     */
    public void act() {
        String nova = comportamento.definirNovaDirecao(getDirecao());
        setDirecao(nova);

        movimento.mover(getDirecao());
        animar();
    }

    /**
     * Reduz a vida do golem sempre que levar dano.
     */
    public void levarDano() {
        vida--;
        if (vida <= 0) morrer();
    }

    /**
     * Remove o golem e cria um bloco de gelo no local da morte.
     */
    public void morrer() {
        World w = getWorld();
        if (w != null) {
            w.addObject(new Gelo(), getX(), getY());
            w.removeObject(this);
        }
    }
}
