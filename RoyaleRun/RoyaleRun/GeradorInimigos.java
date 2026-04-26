import greenfoot.*;

/**
 * Responsável por gerar inimigos de tempos em tempos na fase.
 * Os inimigos aparecem sempre em uma coordenada específica do mapa,
 * simulando um "ponto de surgimento" (como uma cabana de bárbaros, por exemplo).
 */
public class GeradorInimigos {
    private Fase1 fase;           // referência ao mundo principal
    private int contador = 0;     // controla o tempo entre as gerações
    private final int INTERVALO = 480; // tempo em frames entre um spawn e outro

    public GeradorInimigos(Fase1 fase) {
        this.fase = fase;
    }

    /**
     * Chamado a cada ciclo do jogo.
     * Quando o contador atinge o intervalo definido, cria um novo inimigo.
     */
    public void atualizar() {
        contador++;
        if (contador >= INTERVALO) {
            gerarInimigo();
            contador = 0;
        }
    }

    /**
     * Cria um novo inimigo em uma coordenada fixa da fase.
     * Essa posição serve como "base" de onde os inimigos surgem.
     */
    private void gerarInimigo() {
        fase.addObject(new Inimigo(), 465, 310); // posição fixa no campo
        Greenfoot.playSound("barbaros.wav");     // som do surgimento
    }
}
