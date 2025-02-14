package com.example;

import java.util.Random;

public class Filosofo extends Thread {
    // Variables

    private static Random rand = new Random();
    private final Cubierto izq, der;
    private String nombre;

    public Filosofo(String nombre, Cubierto izq, Cubierto der) {
        this.nombre = nombre;
        this.izq = izq;
        this.der = der;
    }

    @Override
    public void run() {
        while (true) {
            Pensar();
            Comer();
        }
    }

    private void Pensar() {
        System.out.println(nombre + " Pensando");
        Esperar(rand.nextInt(2000, 3000));
    }

    private void Comer() {
        try {
            System.out.println(nombre + "esta pensando");
            Thread.sleep(1000);
            System.out.println(nombre + " intenta tomar los cubiertos");

            // has code => entra al codigo de filo < al de desp porque se a ejecutado
            // crucial para inter bloqueo
            // orden total para repartir los recursos
            // De la manera siguiente se obliga a los filosofos en tomar los cubiertos en orden
            if (izq.hashCode() < der.hashCode()) {
                izq.Tomar();
                der.Tomar();
            } else {
                der.Tomar();
                izq.Tomar();
            }
			// cada objeto en java tiene un hashcode unique
			// 
            Thread.sleep(1000);
            System.out.println(nombre + " esta comiendo");
            System.out.println(nombre + " suelta los cubiertos...");
            izq.Soltar();
            der.Soltar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void Esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
