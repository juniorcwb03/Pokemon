package persistence;

import java.util.List;

public interface Colecao<T> {
	
	public List<T> todos() throws Exception;
	public T porNum(int num) throws Exception;
	public T porNome(String nome) throws Exception;
	public void inserir( T objeto )throws Exception;
	public void alterar( T objeto )throws Exception;
	public void remover( T objeto )throws Exception;

}
