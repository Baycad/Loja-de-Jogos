package controller;

import model.Carrinho;
import model.Jogo;
import model.Jogos;
import view.MainView;
import view.PaymentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainController {
    private MainView view;
    private Carrinho carrinho;
    private PaymentView paymentView;  // Instância da view de pagamento

    public MainController() {
        view = new MainView();
        carrinho = new Carrinho();
        paymentView = new PaymentView();  // Inicializa a view de pagamento

        final List<Jogo>[] jogosDisponiveis = new List[]{Jogos.carregarJogos()};
        view.exibirJogosDisponiveis(jogosDisponiveis[0]);

        view.adicionarCarrinhoActionListener(e -> {
            int jogoSelecionado = view.obterJogoSelecionado();
            if (jogoSelecionado >= 0) {
                Jogo jogo = jogosDisponiveis[0].get(jogoSelecionado);
                if (jogo.getEstoque() > 0) {
                    carrinho.adicionarAoCarrinho(jogo);
                    jogo.setEstoque(jogo.getEstoque() - 1);
                    view.exibirCarrinho(carrinho.getCarrinho());
                } else {
                    JOptionPane.showMessageDialog(view.getFrame(), "Este jogo está fora de estoque.");
                }
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "Selecione um jogo para adicionar ao carrinho.");
            }
        });

        view.removerDoCarrinhoActionListener(e -> {
            int indiceSelecionado = view.obterIndiceSelecionadoCarrinho();
            if (indiceSelecionado >= 0) {
                Jogo jogo = carrinho.getCarrinho().get(indiceSelecionado);
                jogo.setEstoque(jogo.getEstoque() + 1);
                carrinho.limparCarrinho();
                view.exibirCarrinho(carrinho.getCarrinho());
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "Selecione um jogo no carrinho para remover.");
            }
        });

        view.continuarComprandoActionListener(e -> {
            jogosDisponiveis[0] = Jogos.carregarJogos();
            view.exibirJogosDisponiveis(jogosDisponiveis[0]);
        });

        view.finalizarCompraActionListener(e -> {
            if (!carrinho.estaVazio()) {
                // Gerar senha de pagamento
                String senhaGerada = paymentView.gerarSenha();

                paymentView.exibirTelaPagamento(evt -> {
                    String senhaInserida = paymentView.obterSenha();

                    if (senhaInserida.equals(senhaGerada)) {
                        JOptionPane.showMessageDialog(view.getFrame(), "Compra finalizada! Obrigado.");
                        carrinho.limparCarrinho();
                        view.exibirCarrinho(carrinho.getCarrinho());
                        paymentView.fecharTela();
                    } else {
                        JOptionPane.showMessageDialog(view.getFrame(), "Senha incorreta. Tente novamente.");
                    }
                });
            } else {
                JOptionPane.showMessageDialog(view.getFrame(), "Seu carrinho está vazio!");
            }
        });

        view.filtrarJogosActionListener(e -> {
            String plataformaSelecionada = view.obterPlataformaSelecionada();
            List<Jogo> jogosFiltrados = Jogos.obterJogosPorPlataforma(plataformaSelecionada);
            view.exibirJogosDisponiveis(jogosFiltrados);
        });
    }

    public void iniciar() {
        view.exibirJogosDisponiveis(Jogos.carregarJogos());
    }
}
