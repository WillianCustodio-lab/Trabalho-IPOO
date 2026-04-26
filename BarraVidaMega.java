import greenfoot.*;

/**
 * Barra de vida do Mega Cavaleiro.
 * Exibe imagens diferentes conforme o chefe perde vida.
 * Cada imagem representa um nível de 0% a 100%, variando de 10 em 10.
 */
public class BarraVidaMega extends Actor {

    private GreenfootImage[] barras;

    /**
     * Prepara todas as imagens da barra e exibe o estado inicial (100%).
     */
    public BarraVidaMega() {
        carregarImagens();
        setImage(barras[10]);   // começa cheio
    }

    /**
     * Carrega todas as imagens da barra.
     * Os arquivos devem seguir o padrão:
     */
    private void carregarImagens() {
        barras = new GreenfootImage[11];

        for (int i = 0; i <= 10; i++) {
            barras[i] = new GreenfootImage("vida" + (i * 10) + ".png");
        }
    }

    /**
     * Atualiza a barra conforme a vida atual do chefe.
     * Recebe um valor entre 0 e 100.
     */
    public void atualizar(int vidaMega) {
        int indice = vidaMega / 10;
        setImage(barras[indice]);
    }
}
