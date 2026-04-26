/**
 * Gerador responsável por criar coroas no mapa.
 *
 * A coroa só pode existir uma por vez:
 * - usa um booleano para evitar múltiplas gerações
 * - gera uma nova coroa após o jogador coletar a anterior
 * - tempo entre gerações é passado para a superclasse
 */
public class GeradorCoroa extends GeradorItemBase {

    private static boolean temCoroa;

    /**
     * Inicia o gerador com intervalo fixo para spawn.
     * Também reseta o controle de existência da coroa.
     */
    public GeradorCoroa(FaseBase fase) {
        super(fase, 480);  // intervalo de criação
        temCoroa = false;
    }

    /**
     * Gera uma coroa em uma posição livre do mapa.
     * Só gera uma nova quando a anterior tiver sido coletada.
     */
    @Override
    public void gerarItem() {
        if (temCoroa)
            return;

        int[] pos = getFase().encontrarPosicaoLivre();
        if (pos != null) {
            getFase().addObject(new ItemCoroa(), pos[0], pos[1]);
            temCoroa = true;
        }
    }

    /**
     * Chamado pela classe ItemCoroa quando o jogador coleta a coroa.
     * Permite que uma nova seja gerada futuramente.
     */
    public static void coroaColetada() {
        temCoroa = false;
    }
}
