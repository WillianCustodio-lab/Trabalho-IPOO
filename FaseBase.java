import greenfoot.*;

/**
 * Classe base para todas as fases do jogo.
 * 
 * Responsável por:
 * 
 *     Exibir a pontuação na tela;
 *     Controlar a liberação da saída (TorreRei);
 *     Executar a lógica padrão de vitória e derrota;
 *     Fornecer utilitário para buscar posições livres no mapa.
 * 
 * 
 * As classes Fase1, Fase2 e Fase3 herdam e expandem
 * esse comportamento conforme necessário.
 */
public class FaseBase extends World {
    
    /** Indica se a saída (TorreRei) já foi aberta. */
    private boolean saidaLiberada = false;
    
    /**
     * Constrói uma fase genérica.
     *
     * largura largura do mundo
     * altura  altura do mundo
     */
    public FaseBase(int largura, int altura) {
        super(largura, altura, 1);
    }
    
    /**
     * Atualiza elementos comuns a todas as fases,
     * atualmente apenas a pontuação exibida na tela.
     */
    public void act() {
        atualizarPontuacao();
    }
    
    /**
     * Método chamado quando o jogador perde.
     * 
     * Pode ser sobrescrito nas fases específicas caso
     * seja necessário alterar música, efeitos ou transições.
     */
    public void jogadorDerrotado() {
        Greenfoot.setWorld(new TelaDerrota(0));
        Greenfoot.playSound("derrota.mp3");
    }

    /**
     * Método chamado quando o jogador vence a fase.
     * 
     * Deve ser sobrescrito pelas subclasses
     * para indicar qual tela de vitória usar.
     */
    public void jogadorVenceu() {
        Greenfoot.setWorld(new TelaVitoria(0)); // 0 = valor padrão
        Greenfoot.playSound("vitoria.mp3");
    }
    
    /**
     * Exibe o texto de pontuação no HUD da fase.
     */
    public void atualizarPontuacao() {
        showText("Pontuação: " + Pontuacao.getPontos(), 70, 30);
    }
    
    /**
     * Libera a saída da fase, caso ainda não tenha sido liberada.
     */
    public void abrirSaida() {
        if (!saidaLiberada) {
            saidaLiberada = true;
            liberarSaida();
        }
    }
    
    /**
     * Executa animação e feedback para a abertura da TorreRei.
     */
    private void liberarSaida() {
        TorreRei torre = (TorreRei) getObjects(TorreRei.class).get(0);
        if (torre != null) {
            torre.iniciarAbertura();
        }
        
        Greenfoot.playSound("AberturaTorreRei.mp3");
        showText("A saída foi aberta! Vá até a torre!", getWidth() / 2, 30);
    }
    
    /**
     * @return true se a saída da fase já foi liberada.
     */
    public boolean getSaidaLiberada() {
        return saidaLiberada;
    }
    
    /**
     * Procura uma posição livre no mapa.
     * 
     * A busca tenta até 150 tentativas aleatórias dentro da
     * área útil do mapa.
     *
     * @return vetor x, y com posição válida, ou null caso nenhuma seja encontrada
     */
    public int[] encontrarPosicaoLivre() {
        for (int i = 0; i < 150; i++) {
    
            int x = 180 + Greenfoot.getRandomNumber(540);
            int y = 120 + Greenfoot.getRandomNumber(400);
    
            boolean livre =
                getObjectsAt(x, y, Obstaculo.class).isEmpty() &&
                getObjectsAt(x, y, ItemBase.class).isEmpty() &&
                getObjectsAt(x, y, JogadorBase.class).isEmpty() &&
                getObjectsAt(x, y, InimigoBase.class).isEmpty();
    
            if (livre) {
                return new int[]{x, y};
            }
        }
        return null;
    }
}
