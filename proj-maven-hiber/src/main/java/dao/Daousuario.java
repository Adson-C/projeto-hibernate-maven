package dao;

import java.util.List;

import javax.persistence.Query;

import model.UsuarioPessoa;

public class Daousuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();

		getEntityManager().remove(pessoa);
		
		getEntityManager().getTransaction().commit();
		
		
	}

	public List<UsuarioPessoa> pesquisar(String campoPesquisa) {
		Query query = super.getEntityManager().createQuery("from UsuarioPessoa where name like '%"+ campoPesquisa +"%'");
		
		return query.getResultList();
	}
	
}
