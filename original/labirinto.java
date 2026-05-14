package projetoifpe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Labirinto {

// Variáveis globais
static Scanner input = new Scanner(System.in);
static JFrame mapa = new JFrame();
static String dados[][] = new String[22][22];
static Object colunas[] = {"", "", "", "", "", "", "T", "H", "E", "", "", "M", "A", "Z", "E", "", "", "", "", "", "",};
static JTable table = new JTable(dados, colunas);
static JScrollPane scrollPane = new JScrollPane(table);
static int flag = 0;

public static void main(String[] args) {
    
    table.getTableHeader().setFont(new Font("Wide Latin", Font.PLAIN, 13));
    table.getTableHeader().setForeground(Color.black);
    table.setBackground(Color.black);
    table.setForeground(Color.yellow);


    mapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    menu();

}

public static void nivel() {
    System.out.println("Use W, A, S, D para se mover no Labirinto!!!");
    System.out.print("Cuidado com as armadilhas, Boa Sorte!!\nDigite Qualquer coisa para continuar...\n");
    String n = input.nextLine();

    mapa1();
    mover(6, 6, 15, 15);

}

public static void mover(int x, int y, int z, int k) {
    int contador = 0;
    int a = x;
    int b = y;

    while (!dados[z][k].equals("  ツ")) {
        System.out.print("Se mova !!! ( W, A, S, D)\n");
        String sentido = input.nextLine().toUpperCase();

        switch (sentido) {
            case "W":
                dados[a][b] = "";
                a = a - 1;
                if (dados[a][b].equals("▇▇")) {
                    System.out.println("Parede, Cego!");
                    a = a + 1;
                }
                if (dados[a][b].equals(" ")) {
                    System.out.println("Você caiu em uma armadilha, volte ao início!!! muahahaha");
                    a = x;
                    b = y;
                }
                dados[a][b] = "  ツ";
                break;
            case "S":
                dados[a][b] = "";
                a = a + 1;
                if (dados[a][b].equals("▇▇")) {
                    System.out.println("Parede, Cego!");
                    a = a - 1;
                }
                if (dados[a][b].equals(" ")) {
                    System.out.println("Você caiu em uma armadilha, volte ao início !!! muahahah");
                    a = x;
                    b = y;
                }
                dados[a][b] = "  ツ";
                break;
            case "D":
                dados[a][b] = "";
                b = b + 1;
                if (dados[a][b].equals("▇▇")) {
                    System.out.println("Parede, Cego!");
                    b = b - 1;
                }
                if (dados[a][b].equals(" ")) {
                    System.out.println("Você caiu em uma armadilha, volte ao início !!! muahahaha");
                    a = x;
                    b = y;
                }
                dados[a][b] = "  ツ";
                break;
            case "A":
                dados[a][b] = "";
                b = b - 1;
                if (dados[a][b].equals("▇▇")) {
                    System.out.println("Parede, Cego!");
                    b = b + 1;
                }
                if (dados[a][b].equals(" ")) {
                    System.out.println("Você caiu em uma armadilha, volte ao início !!! muahahahah");
                    a = x;
                    b = y;
                }
                dados[a][b] = "  ツ";
                break;
            default:
                System.out.println("Tá nojento isso aê...");
                break;
        }
        mostrarmapa(scrollPane);
        contador++;
    }

    if (flag == 0) {
        flag++;
        System.out.println("Você Completou a fase 1, Não há nenhum mérito nisso... Fase 2 is comming");
        ranking1(contador);
        mapa2();
        mover(3, 17, 17, 11);

    }
    if (flag == 1) {
        flag++;
        System.out.println("Você completou a fase 2, Provavelmente já está um pouco nervoso... Essa é a intenção :D");
        ranking2(contador);
        jogarnovamente();
    }

}

public static void mostrarmapa(JScrollPane scrollPane) {
    mapa.add(scrollPane, BorderLayout.CENTER);
    mapa.setSize(600, 406);
    mapa.setResizable(false);
    mapa.setVisible(true);
    mapa.setAlwaysOnTop(true);
}

public static void ranking1(int C) {
    if (C == 22) {
        System.out.println("Você não é um cacto leproso! Rank: S.\n");

    } else if (C > 22 && C <= 25) {
        System.out.println("Nhé... Rank: C.\n");

    } else if (C > 25) {
        System.out.println("Dedaro? Rank: F.\n");
    }
}

public static void ranking2(int B) {
    if (B == 51) {
        System.out.println("É o maior nerd do IFPE! Rank: S.\n");

    } else if (B > 51 && B <= 70) {
        System.out.println("Tá pistola? Rank: C.\n");

    } else if (B > 70) {
        System.out.println("Pelo menos você conseguiu, né? Rank: F. \n");
    }
}

public static void jogarnovamente() {
    System.out.print("\nJogar novamente? (S/N) \n");
    String p = input.nextLine();
    switch (p) {
        case "Não":
        case "N":
        case "n":
        case "NÃO":
        case "nao":
            System.exit(0);
        case "Sim":
        case "S":
        case "s":
        case "SIM":
        case "sim":
            nivel();
            break;
        default:
            System.out.println("Trollou!");
            jogarnovamente();
            break;
    }

}

public static void mapa1() {
    int[][] maposo = {
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 0, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 1, 0, 0, 0, 0, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 8, 8, 8, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 0, 0, 0, 0, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 8, 8, 3, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 0, 0, 8, 8, 0, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 0, 8, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 3, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 2, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}
    };

    conversor(maposo);
    mostrarmapa(scrollPane);

}

public static void mapa2() {
    int[][] maposo = {
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 8, 8, 0, 0, 0, 1, 8, 8, 8, 8},
        {8, 8, 8, 0, 0, 0, 0, 0, 8, 0, 8, 0, 8, 8, 0, 8, 8, 0, 8, 8, 8, 8},
        {8, 8, 8, 0, 8, 8, 8, 0, 8, 0, 8, 0, 0, 0, 0, 8, 8, 0, 8, 8, 8, 8},
        {8, 8, 8, 0, 8, 8, 8, 0, 8, 0, 8, 8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8},
        {8, 8, 8, 0, 8, 8, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8},
        {8, 8, 8, 0, 8, 8, 0, 8, 0, 8, 8, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 3, 8, 8, 0, 8, 3, 8, 8, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 0, 0, 0, 0, 8, 0, 8, 8, 8, 8, 8, 8, 8, 3, 8, 8, 8, 8, 8},
        {8, 8, 8, 0, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 3, 8, 0, 0, 0, 8, 0, 0, 0, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 0, 0, 8, 0, 8, 0, 8, 8, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 8, 0, 8, 0, 0, 0, 8, 8, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 8, 0, 8, 0, 8, 3, 8, 8, 8, 8, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 0, 0, 0, 3, 3, 0, 2, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8},
        {8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8}

    };

    conversor(maposo);
    mostrarmapa(scrollPane);

}

public static void conversor(int numer[][]) {
    for (int k = 0; k < 22; k++) {
        for (int l = 0; l < 22; l++) {
            switch (numer[k][l]) {
                case 8:
                    dados[k][l] = "▇▇";
                    break;
                case 0:
                    dados[k][l] = "";
                    break;
                case 3:
                    dados[k][l] = " ";
                    break;
                case 1:
                    dados[k][l] = "  ツ";
                    break;
                case 2:
                    dados[k][l] = "  ✩";
                    break;
                default:
                    System.out.println(k + l + ("nojento"));
                    break;
            }

        }
    }

}

public static void menu() {
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
                nivel();
                break;
            case "2":
                System.out.println("THE MAZE");
                System.out.println("07/10/2016");
                System.out.println("Instituto Federal de Educação, Ciencia e Tecnologica de Pernambuco");
                System.out.println("Curso Técnico de Informática para Internet");
                System.out.println("Logica de Programacao e Estrutura de Dados");
                System.out.println("Alunos: Maria Eduarda, Gustavo Dantas.");
                System.out.println("\n Digite qualquer coisa para continuar...");
                String h = input.nextLine();
                break;
            case "3":
                System.out.println("Tem certeza que deseja sair? (S/N)");
                String resposta = input.nextLine();
                if (resposta.equals("S") || resposta.equals("s")) {
                    executando = false;
                }   break;
            default:
                System.out.println("Tá nojento isso aê !!");
                System.out.println("\n Digite qualquer coisa para continuar...");
                String o = input.nextLine();
                break;
        }

    } while (executando);
}
}

