package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class BeneficiarioRecebe {

    @NotBlank
    @JsonProperty("idDoacao")
    private String idDoacao;
    @NotBlank
    @JsonProperty("idFinanca")
    private String idFinanca;
    @NotBlank
    @JsonProperty("idProduto")
    private String idProduto;
    @NotBlank
    @JsonProperty("idMatricula")
    private String idMatricula;

    public BeneficiarioRecebe() {

    }

    public BeneficiarioRecebe(@NotBlank @JsonProperty("idDoacao") String idDoacao,
                              @NotBlank @JsonProperty("idFinanca") String idFinanca,
                              @NotBlank @JsonProperty("idProduto") String idProduto,
                              @NotBlank @JsonProperty("idMatricula") String idMatricula) {
        super();
        this.idDoacao = idDoacao;
        this.idFinanca = idFinanca;
        this.idProduto = idProduto;
        this.idMatricula = idMatricula;
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

    public String getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(String idMatricula) {
        this.idMatricula = idMatricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDoacao, idFinanca, idMatricula, idProduto);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BeneficiarioRecebe other = (BeneficiarioRecebe) obj;
        return Objects.equals(idDoacao, other.idDoacao) && Objects.equals(idFinanca, other.idFinanca)
                && Objects.equals(idMatricula, other.idMatricula) && Objects.equals(idProduto, other.idProduto);
    }

}
