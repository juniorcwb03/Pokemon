package resource;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Pokemon;
import persistence.ColecaoDePokemon;
import persistence.ColecaoDePokemonEmBDR;
import persistence.ConexaoSingleton;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class PokemonResource {
	
	@GET
	@Path("/")
	public List<Pokemon> todos() throws Exception{
		Connection con = ConexaoSingleton.getConexao();
		ColecaoDePokemon cp = new ColecaoDePokemonEmBDR(con);
		return cp.todos();
	
	}	
	
	@GET
	@Path("/{num:[0-9]+}")
	public Pokemon porNum(@PathParam("num") int num) throws Exception{
		Connection con = ConexaoSingleton.getConexao();
		ColecaoDePokemon cp = new ColecaoDePokemonEmBDR(con);
		return cp.porNum(num);
	
	}
	
	
	@GET
	@Path("/{nome}")
	public Pokemon porNome(@PathParam("nome") String nome) throws Exception{
		Connection con = ConexaoSingleton.getConexao();
		ColecaoDePokemon cp = new ColecaoDePokemonEmBDR(con);
		return cp.porNome(nome);
	
	}
	
		
	@GET
	@Path("/{tipo}")
	public Pokemon porTipo(@PathParam("tipo") String tipo) throws Exception{
		Connection con = ConexaoSingleton.getConexao();
		ColecaoDePokemon cp = new ColecaoDePokemonEmBDR(con);
		return cp.porTipo(tipo);
	
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Pokemon p) throws Exception{
		Connection con = ConexaoSingleton.getConexao();
		ColecaoDePokemon cp = new ColecaoDePokemonEmBDR(con);
		cp.inserir(p);
	
	}
	
}
