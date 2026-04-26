import greenfoot.*;

/**
 * Base para inimigos posicionados em torres.
 * Essa classe controla:
 * - intervalo entre disparos
 * - troca de imagem ao atirar
 * - retorno automático à imagem normal
 *
 * Outras classes podem herdar desta para definir
 * comportamentos específicos de tiro.
 */
public class InimigoTorre extends Actor {

    private int contadorTiro = 0;
    private int intervaloTiro;

    private int tempoAnimacao = 60;  // tempo para voltar à imagem normal
    private int contadorAnimacao = 0;

    // imagens da torre antes e depois do disparo
    private GreenfootImage normal = new GreenfootImage("princess.png");
    private GreenfootImage semTiro = new GreenfootImage("princess-after-shoot.png");

    private boolean acabouDeAtirar = false;

    /**
     * Configura o inimigo da torre:
     * - imagem normal
     * - imagem após disparo
     * - intervalo entre tiros
     */
    public InimigoTorre(GreenfootImage normal, GreenfootImage semTiro, int intervaloTiro) {
        this.normal = normal;
        this.semTiro = semTiro;
        this.intervaloTiro = intervaloTiro;
        setImage(normal);
    }

    /**
     * Atualização do inimigo:
     * - conta tempo até o próximo tiro
     * - inicia animação de disparo
     * - controla retorno automático ao estado normal
     */
    public void act() {
        contadorTiro++;

        if (contadorTiro >= intervaloTiro) {
            atirar();
            contadorTiro = 0;
        }

        if (acabouDeAtirar) {
            contadorAnimacao++;
            if (contadorAnimacao >= tempoAnimacao) {
                setImage(normal);
                acabouDeAtirar = false;
                contadorAnimacao = 0;
            }
        }
    }

    /**
     * Executa a animação de disparo.
     * Classes que herdam podem sobrescrever para criar o projétil.
     */
    public void atirar() {
        setImage(semTiro);
        acabouDeAtirar = true;
    }
}
