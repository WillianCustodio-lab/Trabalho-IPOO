/**
 * Classe base para qualquer gerador de itens.
 * 
 * Controla:
 * - referência para a fase onde o item será criado
 * - intervalo entre gerações
 * - contador interno de tempo
 *
 * As subclasses implementam apenas como o item será criado.
 */
public class GeradorItemBase {

    private FaseBase fase;     // fase onde o item será gerado
    private int contador = 0;  // avança a cada act
    private int intervalo = 0; // frequência do spawn

    /**
     * Cria o gerador usando o intervalo padrão.
     */
    public GeradorItemBase(FaseBase fase) {
        this.fase = fase;
    }

    /**
     * Cria o gerador com um intervalo específico.
     */
    public GeradorItemBase(FaseBase fase, int intervalo) {
        this.fase = fase;
        this.intervalo = intervalo;
    }

    /**
     * Atualiza o contador.
     * Quando o tempo chega no intervalo, dispara a criação do item.
     */
    public void atualizar() {
        contador++;
        if (contador >= intervalo) {
            gerarItem();
            contador = 0;
        }
    }

    /**
     * Subclasses definem o que será criado e como será posicionado.
     */
    public void gerarItem() {}

    /**
     * Acesso ao mundo da fase para facilitar a geração do item.
     */
    public FaseBase getFase() {
        return fase;
    }
}
