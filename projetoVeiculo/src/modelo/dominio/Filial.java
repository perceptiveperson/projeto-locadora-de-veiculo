package modelo.dominio;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import validadores.CaracterMax;
import validadores.NumeroMax;

@Entity
@Table(name="tab_filial")
public class Filial {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_FILIAL")
	@SequenceGenerator(name="ID_FILIAL", sequenceName="SEQ_FILIAL", allocationSize=1)
	private Long codigo;
	
	@Column(name="nome", length=60, nullable=false)
	@NotEmpty(message="O nome não pode ser vazio.")
	@CaracterMax(value="60", message="Nome inválido: permitido apenas letras de até 60 caracteres.")
	private String nomeFilial;
	
	@Column(name="cnpj", length=40, nullable=false)
	@NotEmpty(message="O CNPJ não pode ser vazio.")
	@NumeroMax(value="40", message="CNPJ inválido: permitido apenas números de até 40 caracteres.")
	private String cnpjFilial;
	
	@Column(name="uf", length=2, nullable=false)
	@NotEmpty(message="A UF não pode ser vazio.")
	@CaracterMax(value="2", message="UF inválido: permitido apenas 2 letras.")
	private String ufFilial;
	
	@OneToMany(mappedBy="filial")
	private Set<Funcionario> funcionarios;
	
	public Filial() {
		
	}
	
	public Filial(String nome, String cnpj, String uf) {
		this.setNomeFilial(nome);
		this.setCnpjFilial(cnpj);
		this.setUfFilial(uf);
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public String getCnpjFilial() {
		return cnpjFilial;
	}

	public void setCnpjFilial(String cnpjFilial) {
		this.cnpjFilial = cnpjFilial;
	}

	public String getUfFilial() {
		return ufFilial;
	}

	public void setUfFilial(String ufFilial) {
		this.ufFilial = ufFilial;
	}

	public Set<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Filial [codigo=" + codigo + ", nomeFilial=" + nomeFilial + ", cnpjFilial=" + cnpjFilial + ", ufFilial="
				+ ufFilial + "]";
	}
	
	
}
