package projmavenhiber;

import org.junit.Test;

import dao.DaoGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(33);
		pessoa.setLogin("teste2");
		pessoa.setName("Gise");
		pessoa.setSobreNome("Pimentel");
		pessoa.setSenha("123");
		pessoa.setEmail("gils@yahoo.com.br");
		
		daoGeneric.salvar(pessoa);
		
	}
	
	@Test
	public void testeBusacar() {
		
DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		pessoa.setId(2L);
		
		pessoa = daoGeneric.pesquisar(pessoa);
		
		System.out.println(pessoa);
	}
	
	@Test
	public void testeBusacar2() { // outro metodo 
		
DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		
	UsuarioPessoa	pessoa = daoGeneric.pesquisar(2L, UsuarioPessoa.class);
		
		System.out.println(pessoa);
	}

}
