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
			Pensar(); // Pascal case o muerte
			Comer();
		}
	}

	private void Pensar() {
		System.out.println(nombre + " Pensando");
		Esperar(rand.nextInt(2000, 3000));
	}

	private void Comer() {
		System.out.println(nombre + " Agarrar cubierto de la izquierda");
		Esperar(rand.nextInt(400, 600));

		synchronized (izq) {
			System.out.println(nombre + " Ahora agarrae cubierto de la derecha");
			Esperar(rand.nextInt(400, 600));

			synchronized (der) {
				System.out.println(nombre + " agarra el cubierto de la derecha");
				System.out.println(nombre + " Comer");
				Esperar(rand.nextInt(2000, 3000));
			}
			System.out.println(nombre + " Cedo mi cubierto derecho");
		}
		System.out.println(nombre + " Dejo cubierto izquierdo");
	}

	private void Esperar(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
