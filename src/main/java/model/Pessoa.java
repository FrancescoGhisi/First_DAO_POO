package model;

public abstract class Pessoa {
    private static final int faseFinal = 10;
    private int id;
    private String nome;
    private int idade;

    public Pessoa() {

    }

    public Pessoa(int id, int idade, String nome) {
        this.id = id;
        this.idade = idade;
        this.nome = nome;
    }

    public int getFaseFinal() {
        return faseFinal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void fazerAniversario() {
        this.idade++;
    }

    public abstract void mostrarDados();
}
