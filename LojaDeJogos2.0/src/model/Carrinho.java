package model;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Jogo> carrinho;

    public Carrinho() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarAoCarrinho(Jogo jogo) {
        this.carrinho.add(jogo);
        jogo.decrementarEstoque();
    }

    public void removerDoCarrinho(Jogo jogo) {
        this.carrinho.remove(jogo);  // Remover o jogo específico
    }

    public List<Jogo> getCarrinho() {
        return carrinho;
    }

    public boolean estaVazio() {
        return carrinho.isEmpty();
    }

    public void limparCarrinho() {
        carrinho.clear();
    }
}
