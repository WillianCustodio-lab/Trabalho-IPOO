import greenfoot.*;

public class Princesa extends Actor
{
    private int contadorTiro = 0;
    private final int INTERVALOTIRO = 420; // tempo entre tiros (7s)
    private int tempoAnimacao = 60;        // tempo até voltar à imagem normal (~1s)
    private int contadorAnimacao = 0;

    // imagens
    private GreenfootImage normal = new GreenfootImage("princess.png");
    private GreenfootImage semDardo = new GreenfootImage("princess-after-shoot.png");

    private boolean acabouDeAtirar = false;

    public Princesa() {
        setImage(normal);
    }

    public void act() {
        contadorTiro++;

        // quando chega o tempo do disparo
        if (contadorTiro >= INTERVALOTIRO) {
            atirar();
            contadorTiro = 0;
        }

        // controla o retorno da animação
        if (acabouDeAtirar) {
            contadorAnimacao++;
            if (contadorAnimacao >= tempoAnimacao) {
                setImage(normal);
                acabouDeAtirar = false;
                contadorAnimacao = 0;
            }
        }
    }

    private void atirar() {
        // cria o tiro
        getWorld().addObject(new TiroPrincesa(), getX(), getY() + 40);
        Greenfoot.playSound("princess.wav");

        // muda para imagem sem o dardo
        setImage(semDardo);
        acabouDeAtirar = true;
    }
}
