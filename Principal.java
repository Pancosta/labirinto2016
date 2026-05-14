package projetoifpe;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Jogo jogo = new Jogo();
        boolean executando = true;

        do {
            System.out.println("█:::::: Labirinto ::::::█");
            System.out.println("    █   (1) Jogar   █");
            System.out.println("    █   (2) Sobre   █");
            System.out.println("    █   (3) Sair    █");
            System.out.println("█:::::::::::::::::::::::█");
            System.out.println("O que você deseja? ~Ahri: ");
            
            String opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    jogo.iniciarNivel();
                    break;
                case "2":
                    System.out.println("THE MAZE\n07/10/2016\nIFPE\nAlunos: Maria Eduarda, Gustavo Dantas.");
                    System.out.println("\nDigite qualquer coisa para continuar...");
                    input.nextLine();
                    break;
                case "3":
                    System.out.println("Tem certeza que deseja sair? (S/N)");
                    String resposta = input.nextLine();
                    if (resposta.equalsIgnoreCase("S")) {
                        executando = false;
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.println("Tá nojento isso aê !!\nDigite qualquer coisa para continuar...");
                    input.nextLine();
                    break;
            }
        } while (executando);
        
        input.close();
    }
}