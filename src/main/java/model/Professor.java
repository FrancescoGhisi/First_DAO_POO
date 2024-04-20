package model;

import javax.swing.*;

public class Professor extends Pessoa {
    private double salario;
    private String titulo;

    public Professor() {

    }

    public Professor(double salario, String titulo) {
        this.salario = salario;
        this.titulo = titulo;
    }

    public Professor(int id, int idade, String nome, double salario, String titulo) {
        super(id, idade, nome);
        this.salario = salario;
        this.titulo = titulo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public void fazerAniversario() {
        super.fazerAniversario();
    }

    @Override
    public void mostrarDados() {
        JOptionPane.showMessageDialog(null, "ID: " + super.getId());
        JOptionPane.showMessageDialog(null, "Nome: " + super.getNome());
        JOptionPane.showMessageDialog(null, "Idade: " + super.getIdade());
        JOptionPane.showMessageDialog(null, "Salario: " + this.salario);
        JOptionPane.showMessageDialog(null, "Titulo: " + this.titulo);
    }

    public double calcularImposto(int salario) {
        return this.salario * 0.05;
    }
}