package model;

import java.io.*;
import java.util.*;

public class Jogos {

    // Carregar jogos a partir de um arquivo CSV
    public static List<Jogo> carregarJogos() {
        List<Jogo> jogos = new ArrayList<>();
        // Utilizando um caminho relativo
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\zande\\IdeaProjects\\LojaDeJogos2.0\\src\\data\\jogos.csv"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0].trim();
                String plataforma = dados[1].trim();
                int estoque = Integer.parseInt(dados[2].trim());
                double preco = Double.parseDouble(dados[3].trim());
                jogos.add(new Jogo(nome, plataforma, estoque, preco));
            }
        } catch (IOException e) {

            System.err.println("Erro ao ler o arquivo jogos.csv: " + e.getMessage());
            e.printStackTrace();  // Exibe o stack trace completo para mais detalhes
        }
        return jogos;
    }

    public static List<Jogo> obterJogosPorPlataforma(String plataforma) {
        List<Jogo> jogos = carregarJogos();  // Carrega todos os jogos
        List<Jogo> jogosFiltrados = new ArrayList<>();

        for (Jogo jogo : jogos) {
            if (jogo.getPlataforma().equalsIgnoreCase(plataforma)) {
                jogosFiltrados.add(jogo);
            }
        }
        return jogosFiltrados;
    }
}
