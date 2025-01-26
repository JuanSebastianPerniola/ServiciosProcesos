package com.example;

public final class App {
    private App() {
    }

    public static void main(String[] args) {
        // arrat para inicializar los nombres de los filosofos
        // yo usare nombres asiaticos por que el problema original proviene de ahi
        // Creador del problema Edsger Dijkstra
        String[] nombres = 
        { "Confucio", "Laozi", "Buda", "Sun Tzu" };

        Filosofo[] filosofos = new Filosofo[nombres.length];
        Cubierto[] cubierto = new Cubierto[nombres.length];

        for (int i = 0; i < cubierto.length; i++) {
            cubierto[i] = new Cubierto();
        }

        for (int i = 0; i < filosofos.length; i++) {

            Cubierto izq = cubierto[i % cubierto.length];

            Cubierto der = cubierto[(i + 1) % cubierto.length];

            filosofos[i] = new Filosofo(nombres[i], izq, der);

        }
        // foreach como un C tictac toes
        for (Filosofo f : filosofos) {
            f.start(); // Iniciar el hilo
        }

    }
}
