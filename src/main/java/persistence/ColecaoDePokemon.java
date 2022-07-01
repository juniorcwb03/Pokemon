package persistence;



import model.Pokemon;

public interface ColecaoDePokemon extends Colecao<Pokemon> {
	
	public Pokemon porNome(String nome)throws Exception;
	public Pokemon porTipo(String nome)throws Exception;
	public Pokemon porNum(int num)throws Exception;
}
