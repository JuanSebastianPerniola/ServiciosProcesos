package com.example;

public class Cubierto {
    
    private boolean disponible = true;
    public synchronized void Tomar(){
        while (!disponible){
            try {
                // Esperarr hasta que el cubierto este libre
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            disponible = false;
        }
    }

    public synchronized void Soltar(){
        disponible = true;
        // Q difirencia hay? supongo que en este caso avisa a un hilo o el hilo que espera que esta detras de este hilo
        // notify();
        // Notificar a todos los filosofos/hilos que esten esperando
        notifyAll();   
    }
}
