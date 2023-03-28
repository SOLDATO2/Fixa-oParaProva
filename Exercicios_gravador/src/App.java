

import java.io.File;
import java.util.Scanner;

import AlunosPacote.Alunos;

import java.io.FileNotFoundException;

import java.util.Formatter;
import java.io.IOException;



//Dado o arquivo de texto grupos-tabulados.txt, crie um programa para fazera leitura do arquivo e:
//1. Somar o valor total de todos os registros;
//2. Somar o valor total de cada grupo;
//3. Imprimir o valor total de cada grupo e de todos os registros.

public class App {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        // LEITURA DE ARQUIVO

        String grupos_tabulados = "D:\\VSCODE PROJECTS\\Exercicios_gravador\\grupos-tabulados.txt";
        File gruposTabulados = new File(grupos_tabulados);
        Scanner leitor = new Scanner(gruposTabulados);

        int GrupoA = 0, GrupoB = 0, GrupoC = 0, GrupoD = 0, GrupoE = 0, GrupoF = 0;



        leitor.nextLine();

        int sum = 0;
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
            // soma total
            String vetor[] = linha.split("\t");
            sum+= Integer.parseInt(vetor[1]);


            // soma por grupos
            if(vetor[0].equals("A")){
                GrupoA += Integer.parseInt(vetor[1]);
            }else if(vetor[0].equals("B")){
                GrupoB += Integer.parseInt(vetor[1]);
            }else if(vetor[0].equals("C")){
                GrupoC += Integer.parseInt(vetor[1]);
            }else if(vetor[0].equals("D")){
                GrupoD += Integer.parseInt(vetor[1]);
            }else if(vetor[0].equals("E")){
                GrupoE += Integer.parseInt(vetor[1]);
            } else if(vetor[0].equals("F")){
                GrupoF += Integer.parseInt(vetor[1]);
            }
            



        }

        System.out.println("Soma Grupo A: " + GrupoA);
        System.out.println("Soma Grupo B: " + GrupoB);
        System.out.println("Soma Grupo C: " + GrupoC);
        System.out.println("Soma Grupo D: " + GrupoD);
        System.out.println("Soma Grupo E: " + GrupoE);
        System.out.println("Soma Grupo F: " + GrupoF);
        System.out.println("Soma total: " + sum);

        
        leitor.close();   



        // GRAVAÇÃO DE ARQUIVO

        Formatter gravador = new Formatter("D:\\VSCODE PROJECTS\\Exercicios_gravador\\relatorio-de-grupos.txt");
        gravador.format("Soma Grupo A: %d\n", GrupoA);
        gravador.format("Soma Grupo B: %d\n", GrupoB);
        gravador.format("Soma Grupo C: %d\n", GrupoC);
        gravador.format("Soma Grupo D: %d\n", GrupoD);
        gravador.format("Soma Grupo E: %d\n", GrupoE);
        gravador.format("Soma Grupo F: %d\n", GrupoF);
        gravador.format("Soma total: %d\n", sum);
        gravador.close();


        Alunos.alunos_arquivo();

    }
}
