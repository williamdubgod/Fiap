package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

import jakarta.validation.constraints.NotBlank;

public class ContaBancaria {

    @NotBlank
    @JsonProperty("codVerificacao")
    private String codVerificacao;
    @NotBlank
    @JsonProperty("agencia")
    private String agencia;
    @NotBlank
    @JsonProperty("numCartao")
    private String numCartao;
    @NotBlank
    @JsonProperty("conta")
    private String conta;
    @NotBlank
    @JsonProperty("id")
    private String id;
	
    public ContaBancaria() {
    	
    }
    
	public ContaBancaria(@NotBlank @JsonProperty("codVerificacao") String codVerificacao, @NotBlank @JsonProperty("agencia") String agencia, 
	                     @NotBlank @JsonProperty("numCartao") String numCartao, @NotBlank @JsonProperty("conta") String conta,
	                     @NotBlank @JsonProperty("id") String id) {
		super();
		this.codVerificacao = codVerificacao;
		this.agencia = agencia;
		this.numCartao = numCartao;
		this.conta = conta;
		this.id = id;
	}
	
	public String getCodVerificacao() {
		return codVerificacao;
	}
	public void setCodVerificacao(String codVerificacao) {
		this.codVerificacao = codVerificacao;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getNumCartao() {
		return numCartao;
	}
	public void setNumCartao(String numCartao) {
		this.numCartao = numCartao;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, codVerificacao, conta, id, numCartao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(codVerificacao, other.codVerificacao)
				&& Objects.equals(conta, other.conta) && Objects.equals(id, other.id)
				&& Objects.equals(numCartao, other.numCartao);
	}
	
}
