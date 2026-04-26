import greenfoot.*;  
import java.util.List; 

/**
 * Classe principal da primeira fase do jogo.
 * Aqui o cenário é construído, os inimigos e coroas são gerados
 * e a lógica principal do jogo é controlada (pontuação, derrota e vitória).
 */
public class Fase1 extends World {
    private boolean saidaLiberada = false; // indica se o jogador pode escapar pela torre
    private GreenfootSound musicaFase1 = new GreenfootSound("Fase1 - Theme.wav");

    private ConstruirCenario cenario;
    private GeradorCoroas geradorCoroas;
    private GeradorInimigos geradorInimigos;
    
    public Fase1() {    
        super(900, 600, 1); 
        
        // Cria e monta o cenário base da fase
        cenario = new ConstruirCenario(this);
        cenario.construirCenarioBase();
        cenario.gerarAmbiente();
        
        // Zera e mostra a pontuação inicial
        Pontuacao.resetar();
        showText("Pontos: 0", 70, 30);
        
        // Gera os objetos que aparecerão ao longo da partida
        geradorCoroas = new GeradorCoroas(this);
        geradorInimigos = new GeradorInimigos(this);
        
        // Toca o tema da fase em loop
        musicaFase1.playLoop();
    }
    
    public void act() {
        // Atualiza os geradores a cada ciclo
        geradorInimigos.atualizar();
        geradorCoroas.atualizar();
        
        // Libera a saída apenas quando o jogador atingir 100 pontos
        if (!saidaLiberada && Pontuacao.getPontos() >= Pontuacao.getPontuacaoLimite()) {
            saidaLiberada = true;
            liberarSaida();
        }
    }
    
    // Método chamado quando o jogador perde
    public void jogadorDerrotado() {
        stopped();
        Greenfoot.setWorld(new TelaDerrota());
        Greenfoot.playSound("defeatScreen.mp3");
    }
    
    // Ativa a animação da torre e avisa o jogador que pode sair
    private void liberarSaida() {
        TorreRei torre = (TorreRei) getObjects(TorreRei.class).get(0);
        if (torre != null) {
            torre.iniciarAbertura();
        }

        Greenfoot.playSound("AberturaTorreRei.mp3");
        showText("A saída foi aberta! Vá até a torre!", getWidth() / 2, 30);
    }

    // É chamado pela torre quando o jogador chega à saída
    public void jogoVencido() {
        stopped();
        Greenfoot.playSound("vitória.mp3");
        Greenfoot.setWorld(new TelaVitoria());
    }

    // Controle de música
    public void started() { 
        musicaFase1.playLoop(); 
    }
    
    public void stopped() { 
        musicaFase1.stop(); 
    }
}
