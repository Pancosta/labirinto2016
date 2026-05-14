package projetoifpe;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Jogo {
    private Mapa mapaObj = new Mapa();
    private Tela telaObj = new Tela(mapaObj.getDados());
    private int flag = 0;
    private int posX, posY, posZ, posK, contador;
    private int startX, startY;

    public void iniciarNivel() {
        System.out.println("\n[!] Fase Iniciada! CLIQUE na janela do labirinto e use as teclas W, A, S, D para mover.");
        mapaObj.carregarFase1();
        
        startX = 6; startY = 6;
        posX = startX; posY = startY; 
        posZ = 15; posK = 15; 
        contador = 0;
        
        telaObj.atualizarMapa();
        configurarControles();
    }

    private void configurarControles() {
        telaObj.adicionarOuvinteTeclado(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                String[][] dados = mapaObj.getDados();
                dados[posX][posY] = ""; 

                if (tecla == KeyEvent.VK_W) {
                    posX--;
                    if (dados[posX][posY].equals("▇▇")) { System.out.println("Parede, Cego!"); posX++; }
                } else if (tecla == KeyEvent.VK_S) {
                    posX++;
                    if (dados[posX][posY].equals("▇▇")) { System.out.println("Parede, Cego!"); posX--; }
                } else if (tecla == KeyEvent.VK_A) {
                    posY--;
                    if (dados[posX][posY].equals("▇▇")) { System.out.println("Parede, Cego!"); posY++; }
                } else if (tecla == KeyEvent.VK_D) {
                    posY++;
                    if (dados[posX][posY].equals("▇▇")) { System.out.println("Parede, Cego!"); posY--; }
                }

                if (dados[posX][posY].equals(" ")) {
                    System.out.println("Você caiu em uma armadilha, volte ao início!!! muahahaha");
                    posX = startX; posY = startY;
                }

                dados[posX][posY] = "  ツ";
                telaObj.atualizarMapa();
                contador++;

                if (posX == posZ && posY == posK) {
                    verificarProgresso();
                }
            }
        });
    }

    private void verificarProgresso() {
        if (flag == 0) {
            flag++;
            System.out.println("\nVocê Completou a fase 1, Não há nenhum mérito nisso... Fase 2 is comming");
            ranking1(contador);
            
            mapaObj.carregarFase2();
            startX = 3; startY = 17;
            posX = startX; posY = startY;
            posZ = 17; posK = 11;
            contador = 0;
            
            mapaObj.getDados()[posX][posY] = "  ツ";
            telaObj.atualizarMapa();
        } else if (flag == 1) {
            flag++;
            System.out.println("\nVocê completou a fase 2, Provavelmente já está um pouco nervoso... Essa é a intenção :D");
            ranking2(contador);
            System.out.println("[!] Fim de Jogo! Pode fechar a janela no X.");
        }
    }

    private void ranking1(int c) {
        if (c <= 22) System.out.println("Você não é um cacto leproso! Rank: S.");
        else if (c <= 25) System.out.println("Nhé... Rank: C.");
        else System.out.println("Dedaro? Rank: F.");
    }

    private void ranking2(int b) {
        if (b <= 51) System.out.println("É o maior nerd do IFPE! Rank: S.");
        else if (b <= 70) System.out.println("Tá pistola? Rank: C.");
        else System.out.println("Pelo menos você conseguiu, né? Rank: F.");
    }
}