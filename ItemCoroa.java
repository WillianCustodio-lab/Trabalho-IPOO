import greenfoot.*;

/**
 * Item de pontuação.
 * 
 * Sempre que coletado:
 * - adiciona pontos ao jogador
 * - executa o som correspondente
 * - remove a coroa
 * - avisa o gerador para permitir o próximo spawn
 */
public class ItemCoroa extends ItemBase {

    public ItemCoroa() {
        super(7, "coroa"); // animação com 7 quadros
    }

    @Override
    public void coletar(JogadorBase jogador) {

        Pontuacao.adicionar(10);
        Greenfoot.playSound("coroa.mp3");

        getWorld().removeObject(this);

        // informa ao gerador que a coroa foi coletada
        GeradorCoroa.coroaColetada();
    }
}
