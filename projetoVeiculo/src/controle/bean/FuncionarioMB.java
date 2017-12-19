package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.FilialDAO;
import modelo.dao.FuncionarioDAO;
import modelo.dominio.Filial;
import modelo.dominio.Funcionario;

@ManagedBean(name = "funcionarioMB")
@RequestScoped
public class FuncionarioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{logimMB}")
	private LoginMB logimMB;

	private Funcionario funcionario = new Funcionario();

	private FuncionarioDAO dao = new FuncionarioDAO();
	private FilialDAO daoFilial = new FilialDAO();
	
	private List<Funcionario> funcionarios = null;
	
	private List<Filial> filiais = null;

	public List<Funcionario> getFuncionarios() {

		this.funcionarios = this.dao.lerTodos();

		return funcionarios;
	}

	public List<Filial> getFiliais() {
		
		this.filiais = this.daoFilial.lerTodos();
		
		return filiais;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LoginMB getLogimMB() {
		return logimMB;
	}

	public void setLogimMB(LoginMB logimMB) {
		this.logimMB = logimMB;
	}

	public String acaoListar() {
		return "funcionarioListar.jsf?faces-redirect=true";
	}

	public String acaoAbrirInclusao() {

		this.funcionario = new Funcionario();

		return "funcionarioEditar.jsf";
	}

	public String acaoAbrirAlteracao(Long codigo) {

		this.funcionario = dao.lerPorId(codigo);

		return "funcionarioEditar.jsf";
	}

	public String acaoExcluir(Long codigo) {

		// ler objeto do banco
		this.funcionario = dao.lerPorId(codigo);

		this.dao.excluir(this.funcionario);

		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.funcionario);

		return acaoListar();
	}

	public String acaoCancelar() {

		return acaoListar();
	}
}
