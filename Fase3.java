import greenfoot.*;
import java.util.List;

/**
 * Terceira fase do jogo.
 * Aqui acontece a batalha contra o Mega Cavaleiro.
 * O cenário é montado com estruturas congeladas e o chefe
 * ataca o jogador periodicamente até ser derrotado.
 */
public class Fase3 extends FaseBase {

    private GreenfootSound musicaFase3 = new GreenfootSound("Fase - Theme.wav");

    private ConstruirCenarioFase3 cenario;

    private GeradorCoroa geradorCoroas;
    private GeradorElixirNegro geradorElixir;
    private GeradorChave geradorChave;

    /**
     * Constrói o ambiente da fase, adiciona o jogador,
     * o chefe, itens e reseta a pontuação inicial.
     */
    public Fase3() {
        super(900, 600);
        CronometroGlobal.iniciar();

        cenario = new ConstruirCenarioFase3(this);
        cenario.construirCenarioBase();
        cenario.gerarAmbiente();

        Pontuacao.resetar();
        showText("Pontuação: 0", 70, 30);

        geradorCoroas = new GeradorCoroa(this);
        geradorElixir = new GeradorElixirNegro(this);
        geradorChave = new GeradorChave(this);

        musicaFase3.playLoop();
    }

    /**
     * Atualizações constantes da fase.
     * Gera itens e verifica se o chefe morreu
     * para liberar a chave da saída.
     */
    public void act() {
        super.act();

        geradorCoroas.atualizar();
        geradorElixir.atualizar();

        boolean podeGerarChave =
            !JogadorFase3.temChave()
            && Pontuacao.getPontos() >= Pontuacao.getPontuacaoNecessaria()
            && MegaCavaleiro.getEstaVivo() == false;

        if (podeGerarChave) {
            gerarChave();
        }
    }

    /**
     * Gera a chave quando o jogador derrotar o chefe
     * e tiver alcançado a pontuação necessária.
     */
    private void gerarChave() {
        geradorChave.atualizar();
        showText("A chave apareceu! Pegue-a para escapar!", getWidth() / 2, 30);
    }

    /**
     * Devolve o jogador presente nesta fase.
     * Usado pelo Mega Cavaleiro para mirar os ataques.
     */
    public JogadorBase getJogador() {
        return (JogadorBase)getObjects(JogadorBase.class).get(0);
    }

    /**
     * Ações ao perder na fase.
     * A música é parada e a tela de derrota é mostrada.
     */
    @Override
    public void jogadorDerrotado() {
        stopped();
        Greenfoot.playSound("defeatScreen.mp3");
        CronometroGlobal.finalizarFase(3);
        Greenfoot.setWorld(new TelaDerrota(3));
    }

    /**
     * Ações ao vencer a fase.
     * O jogador é enviado para a tela de vitória da fase 3.
     */
    @Override
    public void jogadorVenceu() {
        stopped();
        Greenfoot.playSound("vitória.mp3");
        CronometroGlobal.finalizarFase(3);
        Greenfoot.setWorld(new TelaVitoria(3));
    }

    /**
     * A música volta quando a fase fica ativa.
     */
    @Override
    public void started() {
        musicaFase3.playLoop();
    }

    /**
     * A música para quando a fase perde o foco.
     */
    @Override
    public void stopped() {
        musicaFase3.stop();
    }
}
