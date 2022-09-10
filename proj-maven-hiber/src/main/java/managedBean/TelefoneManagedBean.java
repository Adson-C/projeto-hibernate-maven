package managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.Daousuario;
import model.UsuarioPessoa;

@ManagedBean(name = "telefoneManagedBean")
@ViewScoped
public class TelefoneManagedBean {
	
	private UsuarioPessoa user  = new UsuarioPessoa();
	private Daousuario<UsuarioPessoa> daoUser = new Daousuario<UsuarioPessoa>();
	
	@PostConstruct
	public void init() {
		
		String coduser = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("codigouser");
		
		user = daoUser.pesquisar(Long.parseLong(coduser), UsuarioPessoa.class);
		
	}

	public UsuarioPessoa getUser() {
		return user;
	}

	public void setUser(UsuarioPessoa user) {
		this.user = user;
	}

}
