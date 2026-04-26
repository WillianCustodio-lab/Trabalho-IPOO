public class CronometroGlobal {

    private static long inicio;
    private static long tempoFase1 = 0;
    private static long tempoFase2 = 0;
    private static long tempoFase3 = 0;

    public static void iniciar() {
        inicio = System.currentTimeMillis();
    }

    public static void finalizarFase(int fase) {
        long tempo = System.currentTimeMillis() - inicio; // ms
        long segundos = tempo / 1000;

        if (fase == 1) 
            tempoFase1 = segundos;
        if (fase == 2) 
            tempoFase2 = segundos;
        if (fase == 3) 
            tempoFase3 = segundos;
    }

    public static long getTempo(int fase) {
        if (fase == 1) 
            return tempoFase1;
        if (fase == 2) 
            return tempoFase2;
       
        return tempoFase3;
    }
}
