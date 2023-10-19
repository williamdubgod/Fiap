package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Beneficiario {

    @JsonProperty("telefone")
    @NotBlank
    private String telefone;

    @JsonProperty("nome")
    @NotBlank
    private String nome;

    @JsonProperty("cep")
    @NotBlank
    private String cep;

    @JsonProperty("logradouro")
    @NotBlank
    private String logradouro;

    @JsonProperty("localidade")
    @NotBlank
    private String localidade;

    @JsonProperty("renda")
    @NotNull
    private double renda;

    @JsonProperty("email")
    @NotBlank
    private String email;

    @JsonProperty("idMatricula")
    @NotBlank
    private String idMatricula;

    public Beneficiario() {

    }

    public Beneficiario(@NotBlank String telefone, @NotBlank String nome, @NotBlank String cep,
                        @NotBlank String logradouro, @NotBlank String localidade, @NotNull double renda,
                        @NotBlank String email, @NotBlank String idMatricula) {
        super();
        this.telefone = telefone;
        this.nome = nome;
        this.cep = cep;
        this.logradouro = logradouro;
        this.localidade = localidade;
        this.renda = renda;
        this.email = email;
        this.idMatricula = idMatricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cep, email, idMatricula, localidade, logradouro, nome, renda, telefone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Beneficiario other = (Beneficiario) obj;
        return Objects.equals(cep, other.cep) && Objects.equals(email, other.email)
                && Objects.equals(idMatricula, other.idMatricula) && Objects.equals(localidade, other.localidade)
                && Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
                && Double.doubleToLongBits(renda) == Double.doubleToLongBits(other.renda)
                && Objects.equals(telefone, other.telefone);
    }

}
