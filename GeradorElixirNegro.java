/**
 * Gerador responsável por criar o item Elixir Negro.
 *
 * Apenas um elixir pode existir por vez no mapa:
 * - utiliza um booleano para impedir múltiplos spawns
 * - só cria outro após o jogador coletar o anterior
 * - intervalo de geração definido na superclasse
 */
public class GeradorElixirNegro extends GeradorItemBase {

    private static boolean temElixir = false;

    /**
     * Cria o gerador do Elixir Negro com intervalo de spawn.
     */
    public GeradorElixirNegro(FaseBase fase) {
        super(fase, 500);
    }

    /**
     * Gera o elixir em uma posição livre.
     * Garante que apenas um exista por vez.
     */
    @Override
    public void gerarItem() {
        if (temElixir) return;

        int[] pos = getFase().encontrarPosicaoLivre();
        if (pos == null) return;

        getFase().addObject(new ElixirNegro(), pos[0], pos[1]);
        temElixir = true;
    }

    /**
     * Chamado quando o jogador coleta o elixir.
     * Libera o próximo spawn.
     */
    public static void elixirColetado() {
        temElixir = false;
    }
}
