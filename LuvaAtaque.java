import greenfoot.*;

/**
 * Luva que cai do céu após a sombra aparecer.
 * Possui animação própria e causa dano ao jogador.
 */
public class LuvaAtaque extends Actor {

    private ControleAnimacao animacao;
    private int tempoDeVida = 30;

    public LuvaAtaque() {
        animacao = new ControleAnimacao(90, carregarFrames());
        setImage(animacao.getFrameAtual());
    }

    private GreenfootImage[] carregarFrames() {
        GreenfootImage[] imgs = new GreenfootImage[3];
        for (int i = 0; i < 3; i++) {
            imgs[i] = new GreenfootImage("hand" + (i + 1) + ".png");
        }
        return imgs;
    }

    public void act() {
        if (getWorld() == null) return;

        setImage(animacao.proximoFrame());
        verificarColisaoComJogador();

        tempoDeVida--;
        if (tempoDeVida <= 0) {
            getWorld().removeObject(this);
        }
    }

    private void verificarColisaoComJogador() {
        JogadorFase3 jogador = (JogadorFase3)getOneIntersectingObject(JogadorFase3.class);
        if (jogador != null) {
            jogador.morrerPorAtaqueChefe();
        }
    }
}
