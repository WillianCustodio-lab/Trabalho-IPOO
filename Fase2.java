import greenfoot.*;
import java.util.List;

/**
 * Segunda fase do jogo.
 * Aqui aparecem inimigos novos, blocos de gelo e itens que alteram
 * a velocidade ou liberam a saída. 
 * O cenário é mais difícil e o jogador precisa usar o elixir
 * e encontrar a chave para escapar.
 */
public class Fase2 extends FaseBase {
    private GreenfootSound musicaFase2 = new GreenfootSound("Fase - Theme.wav");

    private ConstruirCenarioFase2 cenario;

    private GerarBarbaros gerarBarbaros;

    private GeradorCoroa geradorCoroas;
    private GeradorElixirNegro geradorElixir;
    private GeradorChave geradorChave;

    /**
     * Monta o mapa, adiciona estruturas congeladas,
     * posiciona inimigos e configura os itens da fase.
     */
    public Fase2() {
        super(900, 600);
        CronometroGlobal.iniciar();

        // jogador sempre por cima do gelo
        setPaintOrder(
            JogadorFase2.class,
            ItemBase.class,
            InimigoBase.class,
            Gelo.class
        );

        cenario = new ConstruirCenarioFase2(this);
        cenario.construirCenarioBase();
        cenario.gerarAmbiente();

        Pontuacao.resetar();
        showText("Pontuação: 0", 70, 30);

        gerarBarbaros = new GerarBarbaros(this);

        geradorCoroas = new GeradorCoroa(this);
        geradorElixir = new GeradorElixirNegro(this);
        geradorChave = new GeradorChave(this);

        musicaFase2.playLoop();
    }

    /**
     * Atualizações da fase:
     * gera inimigos, itens e libera a chave quando a pontuação for suficiente.
     */
    public void act() {
        super.act();

        gerarBarbaros.atualizar();

        geradorCoroas.atualizar();
        geradorElixir.atualizar();

        boolean podeGerarChave =
            !JogadorFase2.temChave()
            && Pontuacao.getPontos() >= Pontuacao.getPontuacaoNecessaria();

        if (podeGerarChave) {
            gerarChave();
        }
    }

    /**
     * Mostra a mensagem e cria a chave apenas uma vez.
     */
    private void gerarChave() {
        geradorChave.atualizar();
        showText("A chave apareceu! Pegue-a para escapar!", getWidth() / 2, 30);
    }

    /**
     * Ações executadas quando o jogador morre.
     */
    @Override
    public void jogadorDerrotado() {
        stopped();
        Greenfoot.playSound("defeatScreen.mp3");
        CronometroGlobal.finalizarFase(2);
        Greenfoot.setWorld(new TelaDerrota(2));
    }

    /**
     * Ações ao vencer a fase.
     * Envia o jogador para a tela de vitória da fase 2.
     */
    @Override
    public void jogadorVenceu() {
        stopped();
        Greenfoot.playSound("vitória.mp3");
        CronometroGlobal.finalizarFase(2);
        Greenfoot.setWorld(new TelaVitoria(2));
    }

    /**
     * Música volta ao entrar na fase.
     */
    @Override
    public void started() {
        musicaFase2.playLoop();
    }

    /**
     * Música para quando sair da fase.
     */
    @Override
    public void stopped() {
        musicaFase2.stop();
    }
}
