/**
 * Gerador responsável por criar a chave usada para liberar a saída.
 *
 * Ele só gera uma única chave por fase:
 * - usa um booleano para evitar múltiplas gerações
 * - escolhe uma posição livre no mapa
 * - adiciona o item ao mundo quando estiver tudo certo
 */
public class GeradorChave extends GeradorItemBase {

    private static boolean temChave; // garante que só aparece uma chave

    /**
     * Inicia o gerador e reseta o controle da chave.
     */
    public GeradorChave(FaseBase fase) {
        super(fase);
        temChave = false;
    }

    /**
     * Tenta criar a chave em uma área livre da fase.
     * Só funciona uma única vez.
     */
    @Override
    public void gerarItem() {

        // chave já foi criada antes
        if (temChave) 
            return;

        // tenta achar um ponto válido no mapa
        int[] pos = getFase().encontrarPosicaoLivre();
        if (pos == null) 
            return;

        // cria a chave na posição encontrada
        getFase().addObject(new ItemChave(), pos[0], pos[1]);

        temChave = true;
    }
}
