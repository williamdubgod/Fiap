package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class Doacao {

    @NotBlank
    @JsonProperty("dataDoacao")
    private String dataDoacao;
    @NotBlank
    @JsonProperty("tipoDoacao")
    private String tipoDoacao;
    @NotBlank
    @JsonProperty("valorPagamento")
    private String valorPagamento;
    @NotBlank
    @JsonProperty("valor")
    private String valor;
    @NotBlank
    @JsonProperty("idDoacao")
    private String idDoacao;
    @NotBlank
    @JsonProperty("idFinanca")
    private String idFinanca;
    @NotBlank
    @JsonProperty("tipoFinanca")
    private String tipoFinanca;
    @NotBlank
    @JsonProperty("idProduto")
    private String idProduto;
    @NotBlank
    @JsonProperty("tipoProduto")
    private String tipoProduto;
    @NotBlank
    @JsonProperty("quantidade")
    private String quantidade;
    @NotBlank
    @JsonProperty("doacaoTipo")
    private String doacaoTipo;
    @NotBlank
    @JsonProperty("doadorCPF")
    private String doadorCPF;
	
    public Doacao() {
    	
    }
    
	public Doacao(@NotBlank @JsonProperty("dataDoacao") String dataDoacao, @NotBlank @JsonProperty("tipoDoacao") String tipoDoacao,
	              @NotBlank @JsonProperty("valorPagamento") String valorPagamento, @NotBlank @JsonProperty("valor") String valor,
	              @NotBlank @JsonProperty("idDoacao") String idDoacao, @NotBlank @JsonProperty("idFinanca") String idFinanca,
	              @NotBlank @JsonProperty("tipoFinanca") String tipoFinanca, @NotBlank @JsonProperty("idProduto") String idProduto,
	              @NotBlank @JsonProperty("tipoProduto") String tipoProduto, @NotBlank @JsonProperty("quantidade") String quantidade,
	              @NotBlank @JsonProperty("doacaoTipo") String doacaoTipo, @NotBlank @JsonProperty("doadorCPF") String doadorCPF) {
		super();
		this.dataDoacao = dataDoacao;
		this.tipoDoacao = tipoDoacao;
		this.valorPagamento = valorPagamento;
		this.valor = valor;
		this.idDoacao = idDoacao;
		this.idFinanca = idFinanca;
		this.tipoFinanca = tipoFinanca;
		this.idProduto = idProduto;
		this.tipoProduto = tipoProduto;
		this.quantidade = quantidade;
		this.doacaoTipo = doacaoTipo;
		this.doadorCPF = doadorCPF;
	}
	
	public String getDataDoacao() {
		return dataDoacao;
	}
	public void setDataDoacao(String dataDoacao) {
		this.dataDoacao = dataDoacao;
	}
	public String getTipoDoacao() {
		return tipoDoacao;
	}
	public void setTipoDoacao(String tipoDoacao) {
		this.tipoDoacao = tipoDoacao;
	}
	public String getValorPagamento() {
		return valorPagamento;
	}
	public void setValorPagamento(String valorPagamento) {
		this.valorPagamento = valorPagamento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
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
	public String getTipoFinanca() {
		return tipoFinanca;
	}
	public void setTipoFinanca(String tipoFinanca) {
		this.tipoFinanca = tipoFinanca;
	}
	public String getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(String idProduto) {
		this.idProduto = idProduto;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDoacaoTipo() {
		return doacaoTipo;
	}
	public void setDoacaoTipo(String doacaoTipo) {
		this.doacaoTipo = doacaoTipo;
	}
	public String getDoadorCPF() {
		return doadorCPF;
	}
	public void setDoadorCPF(String doadorCPF) {
		this.doadorCPF = doadorCPF;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDoacao, doacaoTipo, doadorCPF, idDoacao, idFinanca, idProduto, quantidade, tipoDoacao,
				tipoFinanca, tipoProduto, valor, valorPagamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doacao other = (Doacao) obj;
		return Objects.equals(dataDoacao, other.dataDoacao) && Objects.equals(doacaoTipo, other.doacaoTipo)
				&& Objects.equals(doadorCPF, other.doadorCPF) && Objects.equals(idDoacao, other.idDoacao)
				&& Objects.equals(idFinanca, other.idFinanca) && Objects.equals(idProduto, other.idProduto)
				&& Objects.equals(quantidade, other.quantidade) && Objects.equals(tipoDoacao, other.tipoDoacao)
				&& Objects.equals(tipoFinanca, other.tipoFinanca) && Objects.equals(tipoProduto, other.tipoProduto)
				&& Objects.equals(valor, other.valor) && Objects.equals(valorPagamento, other.valorPagamento);
	}
	
}
