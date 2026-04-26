import greenfoot.*;
import java.util.List;

/**
 * Inimigo Bárbaro.
 * Possui velocidade moderada e comportamento agressivo em movimento.
 * 
 * Utiliza as animações e métodos herdados de InimigoBase,
 * configurando apenas o que é específico do bárbaro.
 */
public class Barbaro extends InimigoBase {

    private MovimentoInimigo movimento;
    private ComportamentoInimigo comportamento;

    /**
     * Construtor do Bárbaro.
     * Aqui são carregadas as animações e configurados os sistemas de movimento.
     */
    public Barbaro() {
        setVida(2);
        
        // Carrega animações com o prefixo do bárbaro
        ControleAnimacao front = new ControleAnimacao(10, carregarImagens("front", 4, "barb"));
        ControleAnimacao back = new ControleAnimacao(10, carregarImagens("back", 4, "barb"));
        ControleAnimacao left = new ControleAnimacao(10, carregarImagens("left", 4, "barb"));
        ControleAnimacao right = new ControleAnimacao(10, carregarImagens("right", 4, "barb"));

        setAnimacoes(front, back, left, right);

        movimento = new MovimentoInimigo(this, getVelocidade());
        comportamento = new ComportamentoInimigo(this);
    }

    /**
     * Atualiza movimento e animação do bárbaro.
     */
    public void act() {
        String nova = comportamento.definirNovaDirecao(getDirecao());
        setDirecao(nova);

        movimento.mover(getDirecao());
        animar();
    }
}
