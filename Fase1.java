import greenfoot.*;
import java.util.List;

/**
 * Primeira fase do jogo.
 * Responsável por montar o cenário inicial, tocar a música da fase,
 * gerar inimigos e itens básicos, controlar a pontuação e verificar
 * a condição de liberação da saída.
 */
public class Fase1 extends FaseBase {
    
    private GreenfootSound musicaFase1 = new GreenfootSound("Fase - Theme.wav");

    private ConstruirCenarioFase1 cenario;
    private GeradorCoroa geradorCoroas;
    private GerarBarbaros geradorBarbaros;

    /**
     * Constrói e prepara todos os elementos da fase.
     * Isso inclui cenário, pontuação inicial, geradores e música.
     */
    public Fase1() {
        super(900, 600);
        CronometroGlobal.iniciar();

        cenario = new ConstruirCenarioFase1(this);
        cenario.construirCenarioBase();
        cenario.gerarAmbiente();

        Pontuacao.resetar();
        showText("Pontos: 0", 70, 30);

        geradorCoroas = new GeradorCoroa(this);
        geradorBarbaros = new GerarBarbaros(this);

        musicaFase1.playLoop();
    }

    /**
     * Atualizações constantes da fase.
     * Aqui são gerados inimigos, itens e verificada a pontuação
     * para liberar a saída quando necessário.
     */
    public void act() {
        super.act();

        geradorBarbaros.atualizar();
        geradorCoroas.atualizar();

        if (!getSaidaLiberada() && Pontuacao.getPontos() >= Pontuacao.getPontuacaoNecessaria()) {
            abrirSaida();
        }
    }

    /**
     * O que acontece quando o jogador é derrotado nesta fase.
     * Para fase 1, a música é parada e a tela de derrota é exibida.
     */
    @Override
    public void jogadorDerrotado() {
        stopped();
        Greenfoot.playSound("defeatScreen.mp3");
        CronometroGlobal.finalizarFase(1);
        Greenfoot.setWorld(new TelaDerrota(1));
    }

    /**
     * Chamado quando o jogador alcança a saída.
     * Envia para a tela de vitória específica da fase 1.
     */
    @Override
    public void jogadorVenceu() {
        stopped();
        Greenfoot.playSound("vitória.mp3");
        CronometroGlobal.finalizarFase(1);
        Greenfoot.setWorld(new TelaVitoria(1));
    }

    /**
     * Controle da música quando a fase volta a ficar ativa.
     */
    @Override
    public void started() {
        musicaFase1.playLoop();
    }

    /**
     * Controle da música quando a fase perde foco
     * ou quando o jogador muda de tela.
     */
    @Override
    public void stopped() {
        musicaFase1.stop();
    }
}
