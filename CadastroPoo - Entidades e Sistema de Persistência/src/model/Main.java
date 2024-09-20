package model;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
   
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            
            PessoaFisica pessoa1 = new PessoaFisica("Ana", "11111111111", 25);
            PessoaFisica pessoa2 = new PessoaFisica("Carlos", "22222222222", 52);
            repo1.inserir(pessoa1);
            repo1.inserir(pessoa2);
            
            String arquivoPF = "pessoas_fisicas.dat";
            repo1.persistir(arquivoPF);
            
            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            
            repo2.recuperar(arquivoPF);
            
            System.out.println("Dados de Pessoa Física Armazenados.");
            System.out.println("Dados de Pessoa Física Recuperados.");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }
            
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            
            PessoaJuridica pj1 = new PessoaJuridica(1, "XPTO Sales","33333333333333");
            PessoaJuridica pj2 = new PessoaJuridica(2, "XPTO Soluctions", "44444444444444");
            repo3.inserir(pj1);
            repo3.inserir(pj2);
            
            String arquivoPJ = "pessoas_juridicas.dat";
            repo3.persistir(arquivoPJ);
            
            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            
            repo4.recuperar(arquivoPJ);
            
            System.out.println("Dados de Pessoa Jurídica Armazenados.");
            System.out.println("Dados de Pessoa Jurídica Recuperados.");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
