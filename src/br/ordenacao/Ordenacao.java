package br.ordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ordenacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrlinha = null;
		int i = 0, in = 1;
		Scanner ler = new Scanner(System.in);
		
		String nome = "C:/Users/Departamento de TI/Desktop/English.txt";

		System.out.printf("\nConteúdo  a do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(nome);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			System.out.println(linha);
			int tamVetor = Integer.parseInt(linha);
			arrlinha = new String[tamVetor];
			System.out.println(arrlinha.length);
			while (linha != null && i < tamVetor) {
				linha = lerArq.readLine();
				// System.out.println(linha +" TAM = "+i);
				arrlinha[i] = linha;
				i++;
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
		/*
		 * for(in=0;in<arrlinha.length;in++) { System.out.println(arrlinha[in]);
		 * }
		 */
		long tempoInicio = System.nanoTime();
		String[] ordSelect = selectionSort(arrlinha.clone());
		mostrarVetor(ordSelect,tempoInicio);
	}

	private static String[] selectionSort(String[] arrlinha) {
		// TODO Auto-generated method stub
		
		int i;
		for (i = 0; i <= arrlinha.length - 2; i++) {
			int min = i;
			for (int j = i + 1; j <= arrlinha.length - 1; j++) {
				if (arrlinha[j].length() < arrlinha[min].length()) {
					min = j;
				}
			}
			String t = arrlinha[min];
			arrlinha[min] = arrlinha[i];
			arrlinha[i] = t;
		}
		
		return arrlinha;
	}
	
	
	public static void mostrarVetor(String[] v, long tempoInicio){
		FileWriter arq;
		try {
			arq = new FileWriter("C:/Users/Departamento de TI/Desktop/resultado.txt");
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf("+--Resultado--+%n");
			System.out.println("\n\nVetor:");
			for (int i = 0; i < v.length; i++) {
				gravarArq.println((v[i] + "\n length: \n"+v[i].length()));
				System.out.println(v[i] + " length: "+v[i].length());
			
			}
			long tempofinal = System.nanoTime();
			long tempos = System.currentTimeMillis();
			gravarArq.println((tempofinal-tempoInicio)+" n/s");
			System.out.println((tempofinal-tempoInicio)+" n/s");
			gravarArq.println(tempos+" m/s");
			System.out.println(tempos+" m/s");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

