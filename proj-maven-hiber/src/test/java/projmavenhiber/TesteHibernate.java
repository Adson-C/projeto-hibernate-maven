package projmavenhiber;

import java.util.List;

import org.junit.Test;

import dao.DaoGeneric;
import model.TelefoneUser;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setIdade(29);
		pessoa.setLogin("pablo");
		pessoa.setName("Pablo");
		pessoa.setSobreNome("Escobar");
		pessoa.setSenha("123");
		
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
	
	@Test
	public void testeUpdate() { 
		
DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		
	UsuarioPessoa	pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
	
	pessoa.setIdade(99);
	pessoa.setName("Nome atualizado");
	
	pessoa = daoGeneric.updateMerge(pessoa);
		
		System.out.println(pessoa);
	}
	
	/*
	 * @Test public void testeDelete() { // outro metodo
	 * 
	 * DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
	 * 
	 * UsuarioPessoa pessoa = daoGeneric.pesquisar(1L, UsuarioPessoa.class);
	 * 
	 * daoGeneric.deletarPorId(pessoa);
	 * 
	 * }
	 */
	
	@Test
	public void testeConsultar() { // outro metodo 
		
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> list = daoGeneric.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : list) {
			
			System.out.println(usuarioPessoa);
			System.out.println("---------------------------------");
		}
	}
	
	@Test
	public void testeQueryList() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().createQuery(" from UsuarioPessoa where name = 'Gise'").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListMaxResult() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager()
				.createQuery(" from UsuarioPessoa order by name")
				.setMaxResults(2)
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
	}
	
	@Test
	public void testeQueryListParameter() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric
				.getEntityManager().createQuery("from UsuarioPessoa where name = :name")
				.setParameter("name", "Gise").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQuerySomaIdade() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		Double somaIdade = (Double) daoGeneric.getEntityManager().
				createQuery("select avg(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("Soma de todas as idades � ----------> " + somaIdade);
	}
	
	@Test
	public void testeNameQuery1() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().
		createNamedQuery("consultarTodosUser").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeNameQuery2() {
		DaoGeneric<UsuarioPessoa> daoGeneric = new DaoGeneric<UsuarioPessoa>();
		
		@SuppressWarnings("unchecked")
		List<UsuarioPessoa> list = daoGeneric.getEntityManager().
		createNamedQuery("UsuarioPessoa.buscarPoName")
		.setParameter("name", "Gise")
		.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : list) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeGravarTelefone() {
		@SuppressWarnings("rawtypes")
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(2L, UsuarioPessoa.class);
		
		TelefoneUser telefoneUser = new TelefoneUser();
		
		telefoneUser.setTipo("Celular");
		telefoneUser.setNumero("(11)90865185");
		telefoneUser.setUsuarioPessoa(pessoa);
		
		daoGeneric.salvar(telefoneUser);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testeConsultaTelefones() {
		@SuppressWarnings("rawtypes")
		DaoGeneric daoGeneric = new DaoGeneric();
		
		UsuarioPessoa pessoa = (UsuarioPessoa) daoGeneric.pesquisar(3L, UsuarioPessoa.class);
		
		for (TelefoneUser fone : pessoa.getTelefoneUsers()) {
			
			System.out.println(fone.getUsuarioPessoa().getName());
			System.out.println(fone.getTipo());
			System.out.println(fone.getNumero());
			System.out.println("---------------------->---------------<");
			
		}
		
		
	}
	
}