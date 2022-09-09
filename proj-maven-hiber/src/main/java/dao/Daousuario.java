package dao;

import model.UsuarioPessoa;

public class Daousuario<E> extends DaoGeneric<UsuarioPessoa> {
	
	public void removerUsuario(UsuarioPessoa pessoa) throws Exception {
		getEntityManager().getTransaction().begin();

		String sqlDeleleFone = "delete from telefoneuser where usuariopessoa_id  = " + pessoa.getId();
		getEntityManager().createNativeQuery(sqlDeleleFone).executeUpdate();
		getEntityManager().getTransaction().commit();
		
		super.deletarPorId(pessoa);
		
	}
	
}
