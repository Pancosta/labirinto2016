package projetoifpe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Tela {
    private JFrame mapa;
    private JTable table;
    private JScrollPane scrollPane;
    private String[][] dados;
    private Object[] colunas = {"", "", "", "", "", "", "T", "H", "E", "", "", "M", "A", "Z", "E", "", "", "", "", "", "",};

    public Tela(String[][] dadosIniciais) {
        this.dados = dadosIniciais;
        mapa = new JFrame();
        table = new JTable(dados, colunas);
        scrollPane = new JScrollPane(table);
        configurarTela();
    }

    private void configurarTela() {
        table.getTableHeader().setFont(new Font("Wide Latin", Font.PLAIN, 13));
        table.getTableHeader().setForeground(Color.black);
        table.setBackground(Color.black);
        table.setForeground(Color.yellow);
        table.setFocusable(false); // Impede que a tabela roube o foco das teclas
        mapa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void atualizarMapa() {
        mapa.add(scrollPane, BorderLayout.CENTER);
        mapa.setSize(600, 406);
        mapa.setResizable(false);
        mapa.setVisible(true);
        mapa.setAlwaysOnTop(true);
        mapa.repaint();
    }

    public void adicionarOuvinteTeclado(KeyListener ouvinte) {
        mapa.addKeyListener(ouvinte);
        mapa.setFocusable(true);
        mapa.requestFocusInWindow();
    }
}