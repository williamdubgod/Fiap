package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class Realiza {

    @NotBlank
    @JsonProperty("idContaBancaria")
    private String idContaBancaria;
    @NotBlank
    @JsonProperty("idDoacao")
    private String idDoacao;
    @NotBlank
    @JsonProperty("idFinanca")
    private String idFinanca;
    @NotBlank
    @JsonProperty("idProduto")
    private String idProduto;
    
    public Realiza() {
    	
    }
	
    public Realiza(@NotBlank @JsonProperty("idContaBancaria") String idContaBancaria, @NotBlank @JsonProperty("idDoacao") String idDoacao,
                   @NotBlank @JsonProperty("idFinanca") String idFinanca, @NotBlank @JsonProperty("idProduto") String idProduto) {
        super();
        this.idContaBancaria = idContaBancaria;
        this.idDoacao = idDoacao;
        this.idFinanca = idFinanca;
        this.idProduto = idProduto;
    }
	
    public String getIdContaBancaria() {
        return idContaBancaria;
    }
    public void setIdContaBancaria(String idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }
    public String getIdDoacao() {
        return idDoacao;
    }
    public void setIdDoacao(String idDoacao) {
        this.idDoacao = idDoacao;
    }
    public String getIdFinanca() {
        return idFinanca;
    }
    public void setIdFinanca(String idFinanca) {
        this.idFinanca = idFinanca;
    }
    public String getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContaBancaria, idDoacao, idFinanca, idProduto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Realiza other = (Realiza) obj;
        return Objects.equals(idContaBancaria, other.idContaBancaria) && Objects.equals(idDoacao, other.idDoacao)
                && Objects.equals(idFinanca, other.idFinanca) && Objects.equals(idProduto, other.idProduto);
    }
	
}

