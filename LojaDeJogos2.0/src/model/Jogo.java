package model;

public class Jogo {
    private String nome;
    private String plataforma;
    private int estoque;
    private double preco;

    public Jogo(String nome, String plataforma, int estoque, double preco) {
        this.nome = nome;
        this.plataforma = plataforma;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void decrementarEstoque() {
        if (estoque > 0) {
            estoque--;
        } else {
            System.out.println("Estoque insuficiente para o jogo " + nome);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Plataforma: " + plataforma + ", Estoque: " + estoque + ", Preço: R$" + preco;
    }
}
