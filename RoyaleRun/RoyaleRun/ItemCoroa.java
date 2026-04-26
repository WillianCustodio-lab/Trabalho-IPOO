import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa o item "Coroa" do jogo.
 * Esse item é coletado pelo jogador para ganhar pontos e possui uma animação contínua.
 */
public class ItemCoroa extends Actor
{
    private GreenfootImage[] icone = new GreenfootImage[7]; // armazena os frames da animação
    private int frameAtual = 0;      // controla qual imagem está sendo exibida
    private int contador = 0;        // usado para controlar o tempo entre as trocas de imagem
    private int velocidadeAnim = 6;  // define a velocidade da animação (quanto maior, mais lenta)

    /**
     * Construtor: carrega as imagens e define a primeira imagem exibida.
     */
    public ItemCoroa()
    {
        carregarImagens();
        setImage(icone[0]);
    }

    /**
     * Método chamado a cada ciclo do jogo.
     * Faz a animação da coroa girando continuamente.
     */
    public void act()
    {
        animar();
    }

    /**
     * Carrega as imagens da coroa em sequência (de coroa1.png a coroa7.png).
     * Essas imagens são usadas para dar o efeito de rotação.
     */
    private void carregarImagens() {
        for (int i = 0; i < icone.length; i++) {
            icone[i] = new GreenfootImage("coroa" + (i+1) + ".png");
        }
    }

    /**
     * Faz a troca dos frames da animação.
     * O contador garante que a mudança de imagem aconteça em um ritmo constante.
     */
    private void animar() {
        contador++;
        if (contador >= velocidadeAnim) {
            contador = 0;
            frameAtual = (frameAtual + 1) % icone.length; // volta ao início após o último frame
            setImage(icone[frameAtual]);
        }
    }
}
