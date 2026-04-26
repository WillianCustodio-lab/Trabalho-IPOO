import greenfoot.*;

/**
 * Item que concede velocidade temporária ao jogador.
 * 
 * Assim que coletado:
 * - aplica o efeito de aumento de velocidade
 * - remove o item do mapa
 * - reproduz o som correspondente
 *
 * Pode ser usado por qualquer jogador que implemente
 * os métodos podeUsarElixir() e ativarVelocidadeTemporaria().
 */
public class ElixirNegro extends ItemBase {

    public ElixirNegro() {
        super(3, "elixirNegro"); // animação com 3 quadros
    }

    @Override
    public void coletar(JogadorBase jogador) {

        // verifica se o jogador daquela fase tem o recurso habilitado
        if (jogador.podeUsarElixir()) {
            jogador.ativarVelocidadeTemporaria(1, 180); // duração aproximada: 3 segundos
        }

        Greenfoot.playSound("elixir.mp3");
        getWorld().removeObject(this);
    }
}
