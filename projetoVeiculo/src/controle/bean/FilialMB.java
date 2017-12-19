package controle.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import modelo.dao.FilialDAO;
import modelo.dominio.Filial;

@ManagedBean(name = "filialMB")
@RequestScoped
public class FilialMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{logimMB}")
	private LoginMB logimMB;

	private Filial filial = new Filial();

	private FilialDAO dao = new FilialDAO();

	private List<Filial> filiais = null;

	public List<Filial> getFiliais() {

		this.filiais = this.dao.lerTodos();

		return filiais;
	}

	public Filial getFilial() {
		return filial;
	}

	public void setFilial(Filial filial) {
		this.filial = filial;
	}

	public LoginMB getLogimMB() {
		return logimMB;
	}

	public void setLogimMB(LoginMB logimMB) {
		this.logimMB = logimMB;
	}

	public String acaoListar() {
		return "filialListar.jsf?faces-redirect=true";
	}

	public String acaoAbrirInclusao() {

		this.filial = new Filial();

		return "filialEditar.jsf";
	}

	public String acaoAbrirAlteracao(Long codigo) {

		this.filial = dao.lerPorId(codigo);

		return "filialEditar.jsf";
	}

	public String acaoExcluir(Long codigo) {

		// ler objeto do banco
		this.filial = dao.lerPorId(codigo);

		this.dao.excluir(this.filial);

		return acaoListar();
	}

	public String acaoSalvar() {

		this.dao.salvar(this.filial);

		return acaoListar();
	}

	public String acaoCancelar() {

		return acaoListar();
	}
}
