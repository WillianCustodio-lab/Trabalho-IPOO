import greenfoot.*;

/**
 * Classe base para todos os itens coletáveis do jogo.
 *
 * Responsabilidades:
 * - controlar a animação do item (caso tenha mais de um quadro)
 * - definir um ponto central para itens que usam imagens animadas
 * - fornecer o método coletar(), que será sobrescrito nas subclasses
 *
 * Cada item específico (chave, coroa, elixir)
 * herda desta classe e implementa o efeito de coleta.
 */
public class ItemBase extends Actor {

    private GreenfootImage[] frames;   // quadros da animação
    private int frameAtual = 0;        // controle de qual frame está
    private int contador = 0;          // controla velocidade da animação
    private int velocidadeAnimacao = 8;

    /**
     * Construtor:
     * recebe o número total de frames e o nome-base das imagens.
     */
    public ItemBase(int totalFrames, String baseNomeImagem) {
        carregarImagens(totalFrames, baseNomeImagem);
        setImage(frames[0]);
    }

    /**
     * Atualização do item.
     * Aqui fica apenas a animação básica.
     * A lógica de coleta é responsabilidade das subclasses.
     */
    public void act() {
        animar();
    }

    /**
     * Método chamado quando o jogador coleta o item.
     * Subclasses vão sobrescrever para adicionar efeitos específicos.
     */
    public void coletar(JogadorBase jogador) {
        // ItemBase sozinho não faz nada
    }

    /**
     * Carrega todas as imagens da animação.
     */
    private void carregarImagens(int total, String nome) {
        frames = new GreenfootImage[total];
        for (int i = 0; i < total; i++) {
            frames[i] = new GreenfootImage(nome + (i + 1) + ".png");
        }
    }

    /**
     * Controla animação do item, alternando os frames em loop.
     */
    private void animar() {
        contador++;
        if (contador >= velocidadeAnimacao) {
            contador = 0;
            frameAtual = (frameAtual + 1) % frames.length;
            setImage(frames[frameAtual]);
        }
    }
}
