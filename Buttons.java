import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Classe base para os botões do menu.
 * Ela controla o efeito visual quando o mouse passa por cima
 * e também o comportamento de clicar e mudar de tela.
 */
public class Buttons extends Actor {
    private boolean mouseOver = false;         // indica se o mouse está sobre o botão
    private final int MAX_TRANSPARENCIA = 255; // valor máximo de opacidade da imagem

    /**
     * Verifica se o mouse está sobre o botão e ajusta a transparência.
     * Dá um leve efeito visual para destacar quando o botão é selecionado.
     */
    public void checkMouse() {
        // verifica se o mouse se moveu e se está sobre este botão
        if (Greenfoot.mouseMoved(null)) {
            mouseOver = Greenfoot.mouseMoved(this);
        }

        // altera a transparência de acordo com o estado
        if (mouseOver) {
            ajustarTransparencia(MAX_TRANSPARENCIA / 2); // mais claro com o mouse por cima
        } else {
            ajustarTransparencia(MAX_TRANSPARENCIA);     // volta ao normal
        }
    }

    /**
     * Verifica se o botão foi clicado e muda para o mundo informado.
     * Cada botão pode abrir uma tela diferente (como o menu ou a fase).
     */
    public void checkClick(World world) {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(world);
        }
    }

    /**
     * Ajusta a transparência da imagem do botão.
     * É usada internamente para dar o efeito visual no hover.
     */
    private void ajustarTransparencia(int valor) {
        GreenfootImage img = getImage();
        img.setTransparency(valor);
        setImage(img);
    }
}
