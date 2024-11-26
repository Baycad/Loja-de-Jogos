package view;

import model.Jogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class MainView {
    private JFrame frame;
    private JList<String> jogosList;
    private DefaultListModel<String> listModel;
    private JList<String> carrinhoList; // Nova lista para o carrinho
    private DefaultListModel<String> carrinhoListModel;
    private JComboBox<String> plataformaComboBox;
    private JButton adicionarButton;
    private JButton continuarButton;
    private JButton filtrarButton;
    private JButton finalizarButton;
    private JButton removerButton;

    public MainView() {
        frame = new JFrame("Loja de Jogos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        JLabel plataformaLabel = new JLabel("Selecione a plataforma:");
        plataformaComboBox = new JComboBox<>(new String[]{"PS4", "PS5", "PC", "Xbox One", "Xbox Series X", "Nintendo Switch", "Mobile"});
        filtrarButton = new JButton("Filtrar");
        topPanel.add(plataformaLabel);
        topPanel.add(plataformaComboBox);
        topPanel.add(filtrarButton);

        frame.add(topPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        jogosList = new JList<>(listModel);
        jogosList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane jogosScrollPane = new JScrollPane(jogosList);
        frame.add(jogosScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        adicionarButton = new JButton("Adicionar ao Carrinho");
        continuarButton = new JButton("Ver Todos");
        finalizarButton = new JButton("Finalizar Compra");
        removerButton = new JButton("Remover do Carrinho");

        carrinhoListModel = new DefaultListModel<>();
        carrinhoList = new JList<>(carrinhoListModel);
        carrinhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane carrinhoScrollPane = new JScrollPane(carrinhoList);

        bottomPanel.add(adicionarButton);
        bottomPanel.add(removerButton);
        bottomPanel.add(continuarButton);
        bottomPanel.add(finalizarButton);
        bottomPanel.add(carrinhoScrollPane);

        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void exibirJogosDisponiveis(List<Jogo> jogos) {
        listModel.clear();
        for (Jogo jogo : jogos) {
            listModel.addElement(jogo.toString());
        }
    }

    public void exibirCarrinho(List<Jogo> carrinho) {
        carrinhoListModel.clear();
        if (carrinho.isEmpty()) {
            carrinhoListModel.addElement("Seu carrinho está vazio.");
        } else {
            for (Jogo jogo : carrinho) {
                carrinhoListModel.addElement(jogo.toString());
            }
        }
    }

    public String obterPlataformaSelecionada() {
        return (String) plataformaComboBox.getSelectedItem();
    }

    public int obterJogoSelecionado() {
        return jogosList.getSelectedIndex();
    }

    public int obterIndiceSelecionadoCarrinho() {
        return carrinhoList.getSelectedIndex();
    }

    public void adicionarCarrinhoActionListener(ActionListener listener) {
        adicionarButton.addActionListener(listener);
    }

    public void continuarComprandoActionListener(ActionListener listener) {
        continuarButton.addActionListener(listener);
    }

    public void filtrarJogosActionListener(ActionListener listener) {
        filtrarButton.addActionListener(listener);
    }

    public void finalizarCompraActionListener(ActionListener listener) {
        finalizarButton.addActionListener(listener);
    }

    public void removerDoCarrinhoActionListener(ActionListener listener) {
        removerButton.addActionListener(listener);
    }

    public Component getFrame() {
        return frame;
    }
}
