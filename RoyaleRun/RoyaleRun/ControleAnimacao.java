import greenfoot.GreenfootImage;

/**
 * Classe simples para controlar animações de personagens e objetos.
 * Ela define a velocidade de troca das imagens (quadros)
 * e permite reiniciar ou detectar o fim da animação.
 */
public class ControleAnimacao {
    private GreenfootImage[] quadros; // imagens da animação
    private int indiceAtual = 0;
    private int contador = 0;
    private int velocidade; // tempo entre um frame e outro

    public ControleAnimacao(int velocidade, GreenfootImage[] quadros) {
        this.velocidade = velocidade;
        this.quadros = quadros;
    }

    // Avança para o próximo quadro da animação
    public GreenfootImage proximoFrame() {
        contador++;
        if (contador >= velocidade) {
            contador = 0;
            indiceAtual = (indiceAtual + 1) % quadros.length;
        }
        return quadros[indiceAtual];
    }

    // Retorna o quadro atual sem mudar de imagem
    public GreenfootImage getFrameAtual() {
        return quadros[indiceAtual];
    }

    // Verifica se chegou ao último quadro
    public boolean acabou() {
        return indiceAtual == quadros.length - 1;
    }

    // Reinicia a animação do início
    public void reiniciar() {
        indiceAtual = 0;
        contador = 0;
    }
}
