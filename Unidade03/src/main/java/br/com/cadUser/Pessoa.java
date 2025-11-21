package br.com.cadUser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named // Substitui o antigo @ManagedBean conforme o roteiro
@RequestScoped
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    // Lista estática para manter os nomes salvos mesmo mudando de página/requisição
    private static List<String> nomes = new ArrayList<>();

    // Método chamado pelo botão para salvar o nome na lista
    public void adicionar() {
        if (this.nome != null && !this.nome.isEmpty()) {
            nomes.add(this.nome);
            this.nome = ""; // Limpa o campo após adicionar
        }
    }

    // --- Getters e Setters ---
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getNomes() {
        return nomes;
    }

    public void setNomes(List<String> nomes) {
        Pessoa.nomes = nomes;
    }
}