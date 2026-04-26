import greenfoot.*;

/**
 * Representa a torre central (do rei) na fase.
 * Ela começa fechada e só se abre quando o jogador atinge uma certa pontuação.
 * Após a animação de abertura, o jogador pode encostar na frente dela para vencer o jogo.
 */
public class TorreRei extends Obstaculo {
    private ControleAnimacao animacaoAbertura;
    private boolean animando = false;
    private boolean saidaAberta = false;

    public TorreRei() {
        // Define a animação da abertura
        animacaoAbertura = new ControleAnimacao(10, carregarImagens());
        setImage(animacaoAbertura.getFrameAtual());
    }

    // Carrega os quadros de imagem da animação de abertura
    private GreenfootImage[] carregarImagens() {
        GreenfootImage[] imgs = new GreenfootImage[5];
        for (int i = 0; i < 5; i++) {
            imgs[i] = new GreenfootImage("king-tower" + (i + 1) + ".png");
        }
        return imgs;
    }

    public void act() {
        // Executa a animação da torre se ela estiver abrindo
        if (animando) {
            setImage(animacaoAbertura.proximoFrame());
            
            // Quando a animação termina, a saída é liberada
            if (animacaoAbertura.acabou()) {
                animando = false;
                saidaAberta = true;
            }
        }

        // Verifica se o jogador está em frente à torre após a abertura
        if (saidaAberta) {
            detectarJogadorProximo();
        }
    }

    // Inicia a sequência de abertura da torre
    public void iniciarAbertura() {
        if (!animando && !saidaAberta) {
            animando = true;
            animacaoAbertura.reiniciar();
        }
    }

    // Retorna se a saída já está aberta
    public boolean isSaidaAberta() {
        return saidaAberta;
    }

    /**
     * Detecta se o jogador está na frente da torre (sem precisar encostar).
     * A colisão não é usada aqui porque a torre ainda é um obstáculo.
     */
    private void detectarJogadorProximo() {
        JogadorBase jogador = (JogadorBase) getWorld().getObjects(JogadorBase.class).get(0);
        if (jogador == null) return;

        int distanciaX = Math.abs(jogador.getX() - getX());
        int distanciaY = jogador.getY() - getY();

        // Se o jogador estiver centralizado e logo abaixo da torre → vitória
        if (distanciaX < 40 && distanciaY > 20 && distanciaY < 90) {
            FaseBase fase = (FaseBase) getWorld();
            fase.jogadorVenceu();
        }
    }
}
