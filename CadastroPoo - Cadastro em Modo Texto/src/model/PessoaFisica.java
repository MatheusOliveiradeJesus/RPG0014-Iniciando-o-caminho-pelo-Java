package model;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private int idade;

    // Construtor padrão
    public PessoaFisica() {
        super(GeradorID.getNextId(), ""); // Gera um novo ID
    }

    // Construtor completo
    public PessoaFisica(String nome, String cpf, int idade) {
        super(GeradorID.getNextId(), nome); // Gera um novo ID
        this.cpf = cpf;
        this.idade = idade;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Método exibir polimórfico
    @Override
    public void exibir() {
        super.exibir(); // Chama o método exibir da classe Pessoa
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
    }
}
