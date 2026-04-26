import greenfoot.*;

/**
 * Sombra que aparece antes da queda da Luva do Mega Cavaleiro.
 * Ela cresce até o tamanho final e então gera a Luva no mesmo local.
 */
public class SombraLuva extends Actor {

    private int tamanhoAtual = 10;
    private int tamanhoFinal = 100;

    public void act() {
        if (getWorld() == null) return;

        if (tamanhoAtual < tamanhoFinal) {
            tamanhoAtual += 3;
            atualizarTamanho();
        } else {
            criarLuva();
        }
    }

    private void atualizarTamanho() {
        GreenfootImage img = new GreenfootImage(tamanhoAtual, tamanhoAtual);
        img.setColor(new Color(0, 0, 0, 100));
        img.fillOval(0, 0, tamanhoAtual, tamanhoAtual);
        setImage(img);
    }

    private void criarLuva() {
        World w = getWorld();
        w.addObject(new LuvaAtaque(), getX(), getY());
        w.removeObject(this);
    }
}
