package trabalhoiaa;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Juliana
 */
public class TrabalhoIAA {

    private int[] peso;
    private int[] valor;
    private int linha;
    private int coluna;
    
    public TrabalhoIAA() throws IOException {
        
        Scanner ler = new Scanner(System.in);
        System.out.print("Caminho: ");
        String arq = ler.nextLine();

        int cont = 0;
        BufferedReader arquivo = new BufferedReader(new FileReader(arq));
        String[] primeira = arquivo.readLine().split(" ");
        coluna = Integer.parseInt(primeira[0]);
        linha = Integer.parseInt(primeira[1]);
                
        int[][] matriz = new int[linha][coluna];
        this.peso = new int[linha];
        this.valor = new int[linha];
       
        while (arquivo.ready()) {
            String[] vetor = arquivo.readLine().split(" ");
            valor[cont] = Integer.parseInt(vetor[0]);
            peso[cont] = Integer.parseInt(vetor[1]);
            cont++;
        }
        
        for (int col = 0; col < coluna; col++) {
            for (int lin = 1; lin < linha; lin++) {
                matriz[lin][col] = matriz[lin-1][col];
                if(peso[lin] <= col){
                    if( matriz[lin-1][col] < valor[lin] + matriz[lin-1][col-peso[lin]]){
                        matriz[lin][col] = valor[lin] + matriz[lin-1][col-peso[lin]];
                    }                    
                }                
            }
        }               
        System.out.println(matriz[linha-1][coluna-1]);
    }
    
    public static void main(String[] args) throws Exception{
       TrabalhoIAA trabalho = new TrabalhoIAA();
   }
    

}
