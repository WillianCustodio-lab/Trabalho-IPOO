import greenfoot.*;

/**
 * Item responsável por liberar a saída do mapa.
 * 
 * Quando coletado:
 * - registra no jogador que a chave foi obtida
 * - libera a saída da fase (torre abre)
 * - toca o som da chave
 * - remove o item
 */
public class ItemChave extends ItemBase {

    public ItemChave() {
        super(2, "chave"); // animação com 2 quadros
    }

    @Override
    public void coletar(JogadorBase jogador) {

        jogador.coletarChave();
        Greenfoot.playSound("key.mp3");

        // avisa a fase que a saída deve ser aberta
        if (getWorld() instanceof FaseBase) {
            ((FaseBase) getWorld()).abrirSaida();
        }

        getWorld().removeObject(this);
    }
}
