package controle.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginMB")
@SessionScoped
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String senha;
	private boolean loginOk;

	public boolean isConectado() {
		if (this.usuario == null || "".equals(this.usuario))
			return false;

		return true;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String acaoExibirHome() {
		return "home.jsf?faces-redirect=true";
	}

	public String acaoSair() {
		this.usuario = "";
		this.senha = "";
		
		this.loginOk = false;
		return "login.jsf";
	}

	public String acaoAutenticar() {

		loginOk = "123".equals(this.senha);

		if (loginOk)
			return "home.jsf";
		else {
			
			FacesContext contexto = FacesContext.getCurrentInstance();
			String mensagem = contexto.getApplication().evaluateExpressionGet(contexto, "#{msgs.msgCreInval}",
					String.class);			
			
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
			contexto.addMessage(null, msg);

			return "login.jsf";
		}
	}
}
