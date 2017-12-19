package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import validadores.CaracterMax;
@Entity
@Table(name="tab_funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ID_FUNCIONARIO")
	@SequenceGenerator(name="ID_FUNCIONARIO",sequenceName="SEQ_FUNCIONARIO",allocationSize=1)
	private Long codigo;
	
	@Column(name="nome", length=40, nullable=false)
	@NotEmpty(message="O nome não pode ser vazio.")
	@CaracterMax(value="40", message="Nome inválido: permitido apenas letras de até 40 caracteres.")
	private String nomeFunc;
	
	@Column(length=40)
	@CaracterMax(value="40", message="Cargo inválido: permitido apenas letras de até 40 caracteres.")
	private String cargo;
	
	@ManyToOne
	@JoinColumn(name="fk_filial")
	private Filial filial;
	
	public Funcionario() {
		
	}
	
	public Funcionario(String nome) {
		this.setNomeFunc(nome);
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeFunc() {
		return nomeFunc;
	}

	public void setNomeFunc(String nomeFunc) {
		this.nomeFunc = nomeFunc;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}	

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nomeFunc=" + nomeFunc + ", cargo=" + cargo + ", filial=" + filial
				+ "]";
	}	

}
