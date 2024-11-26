package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;

public class PaymentView {

    private JFrame frame;
    private JTextField nomeField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JButton confirmarButton;

    private String senhaGerada;

    public PaymentView() {
        frame = new JFrame("Finalizar Compra - Informações de Pagamento");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2));

        // Labels
        frame.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        frame.add(nomeField);

        frame.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        frame.add(cpfField);

        frame.add(new JLabel("Senha de Pagamento:"));
        senhaField = new JPasswordField();
        frame.add(senhaField);

        confirmarButton = new JButton("Confirmar Pagamento");
        frame.add(confirmarButton);

        frame.setLocationRelativeTo(null);
    }

    public void exibirTelaPagamento(ActionListener listener) {
        confirmarButton.addActionListener(listener);
        frame.setVisible(true);
    }

    public void fecharTela() {
        frame.dispose();
    }

    public String obterNome() {
        return nomeField.getText();
    }

    public String obterCpf() {
        return cpfField.getText();
    }

    public String obterSenha() {
        return new String(senhaField.getPassword());
    }


    public String gerarSenha() {
        Random random = new Random();
        int senha = 100+ random.nextInt(900);
        senhaGerada = String.valueOf(senha);
        System.out.println("Sua senha gerada é: " + senhaGerada);
        return senhaGerada;
    }

    public String getSenhaGerada() {
        return senhaGerada;
    }
}
