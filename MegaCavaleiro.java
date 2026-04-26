import greenfoot.*;

/**
 * Chefe da Fase 3.
 * 
 * Atua como inimigo principal, atacando periodicamente com a luva.
 * Possui:
 * barra de vida própria
 * animação de ataque
 * cooldown entre ataques
 * lógica para mirar no jogador ou em posições aleatórias
 *
 * Quando a vida chega a zero:
 * o chefe desaparece
 * a barra de vida é removida
 * um som de morte é tocado
 */
public class MegaCavaleiro extends Actor {
    
    private BarraVidaMega barra;      // barra que exibe a vida atual
    private static boolean estaVivo;  // usado pela fase para gerar chave
    private int vida = 100;           // vida total do chefe

    // imagens e animações
    private GreenfootImage frameParado;
    private ControleAnimacao animAtaque;

    // controle do ataque
    private boolean atacando = false;
    private int cooldown = 0;
    private int tempoEntreAtaques = 120; // cerca de 2 segundos

    /**
     * Recebe a barra de vida já criada no mundo.
     * Assim o chefe pode atualizá-la diretamente.
     */
    public MegaCavaleiro(BarraVidaMega barra) {
        carregarAnimacoes();
        setImage(frameParado);
        estaVivo = true;
        
        this.barra = barra;
    }

    /**
     * Carrega a imagem parada e os quadros de animação do ataque.
     */
    private void carregarAnimacoes() {
        frameParado = new GreenfootImage("mega1.png");

        GreenfootImage[] frames = new GreenfootImage[3];
        for (int i = 0; i < 3; i++) {
            frames[i] = new GreenfootImage("mega" + (i + 1) + ".png");
        }
        animAtaque = new ControleAnimacao(10, frames);
    }

    /**
     * Executado a cada ciclo do jogo.
     * Alterna entre animar o ataque ou iniciar um novo ataque.
     */
    public void act() {
        if (atacando) {
            animarAtaque();
        } else {
            tentarAtacar();
        }
    }

    /**
     * Aguarda o cooldown antes de iniciar outra animação de ataque.
     */
    private void tentarAtacar() {
        if (cooldown > 0) {
            cooldown--;
            return;
        }

        atacando = true;
        animAtaque.reiniciar();
    }

    /**
     * Mostra os quadros de animação até chegar no último.
     * Quando termina, dispara o ataque.
     */
    private void animarAtaque() {
        setImage(animAtaque.proximoFrame());

        if (animAtaque.acabou()) {
            realizarAtaque();
            atacando = false;
            cooldown = tempoEntreAtaques;
            setImage(frameParado);
        }
    }

    /**
     * Atira a luva em uma posição:
     * • 30% de chance de mirar no jogador
     * • caso contrário, usa uma posição livre do mapa
     */
    private void realizarAtaque() {
        Fase3 fase = (Fase3)getWorld();

        int[] pos;

        if (Greenfoot.getRandomNumber(100) < 30) {
            JogadorBase j = fase.getJogador();
            pos = new int[] { j.getX(), j.getY() };
        } else {
            pos = fase.encontrarPosicaoLivre();
        }

        if (pos != null) {
            fase.addObject(new SombraLuva(), pos[0], pos[1]);
            Greenfoot.playSound("mega-knight-attack2.mp3");
        }
    }

    /**
     * Reduz a vida quando atingido por tiros do jogador.
     * Também atualiza a barra de vida.
     */
    public void levarDano() {
        vida--;
        if (barra != null) {
            barra.atualizar(vida); 
        }

        if (vida <= 0) morrer();
    }

    /**
     * Quando o chefe morre:
     * marca que não está mais vivo
     * remove o chefe
     * remove a barra
     * toca o som de morte
     * 
     * A Fase 3 usa esta informação para liberar a chave.
     */
    private void morrer() {
        estaVivo = false;
        getWorld().removeObject(this);
        getWorld().removeObject(barra);
        Greenfoot.playSound("mega-knight-death.mp3");
    }
    
    /**
     * Usado pela Fase 3 para checar se a chave pode aparecer.
     */
    public static boolean getEstaVivo() {
        return estaVivo;
    }
}
