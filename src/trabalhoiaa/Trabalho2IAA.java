/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoiaa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class Trabalho2IAA {

    long inversao;

    public static void main(String[] args) throws IOException {
        Trabalho2IAA tabalho = new Trabalho2IAA();
    }

    public Trabalho2IAA() throws IOException {
        Scanner ler = new Scanner(System.in);
        int cont = 0;
        BufferedReader arquivo = new BufferedReader(new FileReader("C:\\Users\\Juliana\\Documents\\NetBeansProjects\\Trabalho2IAA\\dist\\inv1.txt"));
        String primeira = arquivo.readLine();
        int tamanho = Integer.parseInt(primeira);

        int v[] = new int[tamanho];
        int w[] = new int[tamanho];

        while (arquivo.ready()) {
            String numero = arquivo.readLine();
            int valor = Integer.parseInt(numero);
            v[cont] = valor;
            cont++;
        }

        inversao = mergeSort(v, w, 0, tamanho - 1);
        System.out.println("Inversão: " + inversao);

    }

    public long mergeSort(int[] v, int[] w, int ini, int fim) {
        long cont = 0;
        if (ini < fim) {
            int meio = (ini + fim) / 2;
            cont = mergeSort(v, w, ini, meio)
                    + mergeSort(v, w, meio + 1, fim)
                    + intercalar(v, w, ini, meio, fim);

        }
        return cont;
    }

    private long intercalar(int[] v, int[] w, int ini, int meio, int fim) {
        for (int k = ini; k <= fim; k++) {
            w[k] = v[k];
        }
        
        int i = ini;
        int j = meio + 1;
        long cont = 0;

        for (int k = ini; k <= fim; k++) {
            if (i > meio) {
                v[k] = w[j++];
            } else if (j > fim) {
                v[k] = w[i++];
            } else if (w[i] < w[j]) {
                v[k] = w[i++];
            } else {
                v[k] = w[j++];
                cont += meio - i + 1;
            }
        }
        return cont;
    }
}
