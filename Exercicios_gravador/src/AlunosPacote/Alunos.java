package AlunosPacote;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Formatter;

public class Alunos {
    public static void alunos_arquivo() throws FileNotFoundException, IOException{
        int count = 0, aprovados = 0, reprovados = 0;
        float media = 0, menor = 0, maior = 0;

        String alunos_csv = "D:\\VSCODE PROJECTS\\Exercicios_gravador\\alunos.csv";
        File AlunosCSV = new File(alunos_csv);
        Scanner leitor = new Scanner(AlunosCSV);

        String turma = "D:\\VSCODE PROJECTS\\Exercicios_gravador\\resultado_turma.txt";
        Formatter gravador = new Formatter(turma);


        leitor.nextLine();

        Boolean UmaVez = true;
        while(leitor.hasNextLine()){
            String linha = leitor.nextLine();
            String vetor[] = linha.split(";");

            System.out.println("Matricula: " + vetor[0]);
            System.out.println("Nome: " + vetor[1]);
            System.out.println("Nota: " + vetor[2]);

            if(UmaVez == true){
                menor = Float.parseFloat(vetor[2]);
                maior = Float.parseFloat(vetor[2]);
                UmaVez = false;
            }

            
            if(Float.parseFloat(vetor[2].replace(',','.')) >= 6.0){
                aprovados++;
            } else{
                reprovados++;
            }

            if(Float.parseFloat(vetor[2].replace(',','.')) < menor){
                menor = Float.parseFloat(vetor[2].replace(',','.'));
            }

            if(Float.parseFloat(vetor[2].replace(',','.')) > maior){
                maior = Float.parseFloat(vetor[2].replace(',','.'));
            }
            count++;
            
            media += Float.parseFloat(vetor[2].replace(',','.'));

        }
        media = media/count;
        gravador.format("Quantidade de alunos na turma: %d\n", count);
        gravador.format("Quantidade de alunos APROVADOS: %d\n", aprovados);
        gravador.format("Quantidade de alunos REPROVADOS: %d\n", reprovados);
        gravador.format("MENOR nota da turma: %.2f\n", menor);
        gravador.format("MAIOR nota da turma: %.2f\n", maior);
        gravador.format("media da turma: %.2f\n", media);

        gravador.close();
        leitor.close();
    }
}
