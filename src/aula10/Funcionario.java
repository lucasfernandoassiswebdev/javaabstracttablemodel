/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula10;

/**
 *
 * @author LUCASFERNANDODEASSIS
 */
public class Funcionario {
    public String Matricula;
    private String Nome;
    private String CPF;
    
    public Funcionario(){
    }
    
    public Funcionario(String Matricula, String Nome, String CPF){
        this.Matricula = Matricula;
        this.Nome = Nome;
        this.CPF = CPF;
    }

    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }   
}
