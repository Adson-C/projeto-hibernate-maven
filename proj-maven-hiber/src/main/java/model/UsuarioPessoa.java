package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "consultarTodosUser", query =
 * "select u from UsuarioPessoa u"),
 * 
 * @NamedQuery(name = "UsuarioPessoa.buscarPoName", query =
 * "select u from UsuarioPessoa u where u.name = :name")
 * 
 * 
 * })
 */
@Entity
public class UsuarioPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String sobreNome;
	private String login;
	private String senha;
	private String sexo;
	private int idade;
	private Double salario;
	
	@Column(columnDefinition = "text")
	private String imagem;
	
	
	@OneToMany(mappedBy = "usuarioPessoa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<TelefoneUser> telefoneUsers = new ArrayList<TelefoneUser>();
	
	@OneToMany(mappedBy = "usuarioPessoa", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
	private List<EmailUser> emails = new ArrayList<EmailUser>();
	
	
	
	  private String cep; private String logradouro; private String complemento;
	  private String bairro; private String localidade; private String uf; private
	  String undidade; private String ibge; private String gia;
	 
	
	
	
	
	
	  public String getCep() { return cep; } public void setCep(String cep) {
	  this.cep = cep; } public String getLogradouro() { return logradouro; } public
	  void setLogradouro(String logradouro) { this.logradouro = logradouro; }
	  public String getComplemento() { return complemento; } public void
	  setComplemento(String complemento) { this.complemento = complemento; } public
	  String getBairro() { return bairro; } public void setBairro(String bairro) {
	  this.bairro = bairro; } public String getLocalidade() { return localidade; }
	  public void setLocalidade(String localidade) { this.localidade = localidade;
	  } public String getUf() { return uf; } public void setUf(String uf) { this.uf
	  = uf; } public String getUndidade() { return undidade; } public void
	  setUndidade(String undidade) { this.undidade = undidade; } public String
	  getIbge() { return ibge; } public void setIbge(String ibge) { this.ibge =
	  ibge; } public String getGia() { return gia; } public void setGia(String gia)
	  { this.gia = gia; }
	 
	public List<TelefoneUser> getTelefoneUsers() {
		return telefoneUsers;
	}
	public void setTelefoneUsers(List<TelefoneUser> telefoneUsers) {
		this.telefoneUsers = telefoneUsers;
		
	}
	
	
	public List<EmailUser> getEmails() {
		return emails;
	}
	public void setEmails(List<EmailUser> emails) {
		this.emails = emails;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", name=" + name + ", sobreNome=" + sobreNome + 
				", login=" + login + ", senha=" + senha + ", idade=" + idade + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioPessoa other = (UsuarioPessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
