import greenfoot.World;
import greenfoot.MouseInfo;
import greenfoot.Greenfoot;

/**
 * Essa classe controla a lógica de disparo do jogador.
 * Ela cuida do tempo de recarga, da direção do tiro e da criação do projétil.
 */
public class ControleDeTiro {
    private int tempoRecarga;       // tempo mínimo entre um tiro e outro
    private int contadorRecarga = 0; // conta os frames até poder atirar de novo

    /**
     * Define o intervalo de recarga (em frames).
     */
    public ControleDeTiro(int tempoRecarga) {
        this.tempoRecarga = tempoRecarga;
    }

    /**
     * Atualiza o contador de tempo a cada ciclo do jogo.
     * Assim que ele atinge o limite, o jogador pode disparar novamente.
     */
    public void atualizar() {
        if (contadorRecarga < tempoRecarga)
            contadorRecarga++;
    }

    /**
     * Retorna true se o jogador já pode atirar novamente.
     */
    public boolean podeAtirar() {
        return contadorRecarga >= tempoRecarga;
    }

    /**
     * Reinicia o tempo de recarga após um disparo.
     */
    public void resetar() {
        contadorRecarga = 0;
    }

    /**
     * Cria o tiro e define sua direção com base na posição do mouse.
     * O disparo sempre sai um pouco à frente do jogador.
     */
    public void atirar(World mundo, int x, int y) {
        // Se ainda estiver recarregando, não faz nada
        if (!podeAtirar()) return;
    
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse == null) return;

        // Pega as coordenadas do mouse
        int mouseX = mouse.getX();
        int mouseY = mouse.getY();

        // Calcula o ângulo entre o jogador e o mouse
        double anguloRad = Math.atan2(mouseY - y, mouseX - x);
        double anguloDeg = Math.toDegrees(anguloRad);
        if (anguloDeg < 0) anguloDeg += 360; // garante que o ângulo fique entre 0 e 360

        // Define a origem do tiro um pouco à frente do jogador
        int distancia = 20;
        int origemX = (int) Math.round(x + Math.cos(anguloRad) * distancia);
        int origemY = (int) Math.round(y + Math.sin(anguloRad) * distancia);

        // Cria o tiro com o ângulo calculado
        Tiro tiro = new Tiro((int) anguloDeg);
        mundo.addObject(tiro, origemX, origemY);
        
        Greenfoot.playSound("DartGoblinTiro.wav");
        resetar();
    }
}
