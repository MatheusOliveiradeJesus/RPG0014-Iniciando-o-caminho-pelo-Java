package model;

public class PessoaJuridica extends Pessoa {
    private String cnpj;

    // Construtor padrão
    public PessoaJuridica() {
        super(GeradorID.getNextId(), ""); // Gera um novo ID
    }

    // Construtor completo
    public PessoaJuridica(int id, String nome, String cnpj) {
        super(GeradorID.getNextId(), nome); // Gera um novo ID
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Método exibir polimórfico
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da classe Pessoa
        System.out.println("CNPJ: " + cnpj);
    }
}
