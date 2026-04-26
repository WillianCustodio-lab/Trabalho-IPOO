import greenfoot.*;

/**
 * Representa o projétil disparado pelo jogador.
 * 
 * O tiro se move na direção indicada e desaparece ao:
 *  atingir um inimigo;
 *  colidir com obstáculo sólido;
 *  ou sair dos limites.
 */
public class TiroGoblin extends Actor {
    private int velocidade = 8;
    private boolean removido = false;

    public TiroGoblin(int angulo) {
        setRotation(angulo);
    }

    public void act() {
        if (removido) return;

        move(velocidade);

        // Checa colisões na ordem de prioridade
        if (colisaoComInimigo()) return;
        if (colisaoComChefe()) return;
        if (colisaoComObstaculo()) return;
        if (isAtEdge()) removerTiro();
    }

    private boolean colisaoComInimigo() {
        InimigoBase inimigo = (InimigoBase) getOneIntersectingObject(InimigoBase.class);
        if (inimigo != null) {
            inimigo.levarDano();
            removerTiro();
            return true;
        }
        return false;
    }

    private boolean colisaoComChefe() {
        MegaCavaleiro chefe = (MegaCavaleiro) getOneIntersectingObject(MegaCavaleiro.class);
        if (chefe != null) {
            chefe.levarDano();
            removerTiro();
            return true;
        }
        return false;
    }

    private boolean colisaoComObstaculo() {
        Obstaculo obstaculo = (Obstaculo) getOneIntersectingObject(Obstaculo.class);
        if (obstaculo != null && !(obstaculo instanceof Agua) && !(obstaculo instanceof Gelo)) {
            removerTiro();
            return true;
        }
        return false;
    }

    private void removerTiro() {
        if (!removido && getWorld() != null) {
            removido = true;
            getWorld().removeObject(this);
        }
    }
}
