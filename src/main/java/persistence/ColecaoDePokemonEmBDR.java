package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import model.Pokemon;

public class ColecaoDePokemonEmBDR implements ColecaoDePokemon {
	
	private Connection conexao; 
    
	public ColecaoDePokemonEmBDR(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public List<Pokemon> todos() throws Exception {
	  PreparedStatement ps = null;
	  ResultSet rs = null;
	  List<Pokemon> lp = null;
	  try {
		lp = new ArrayList<Pokemon>();
		String sql = "SELECT NUM, namePokemon, TIPO, PRE_EVOLUTION, NEXT_EVOLUTION from pokemon";
		ps = this.conexao.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next() ) {
			Pokemon p = new Pokemon( rs.getInt("NUM"), rs.getString("namePokemon"), rs.getString("TIPO"),rs.getString("PRE_EVOLUTION"),rs.getString("NEXT_EVOLUTION"));
			lp.add(p);
		}	
	}catch (SQLException e) {
		throw new Exception("Erro ao obter os Pokemons do banco de dados", e);
	}finally {
		try {
			ps.close();
			if (rs != null) 
				rs.close();
		}catch (SQLException e) {
			throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
		}
	}
	return lp;  
		
	}

	
	@Override
	public Pokemon porNome(String nome) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pokemon p = null;
		try {
			String sql = "SELECT NUM, namePokemon, TIPO, PRE_EVOLUTION, NEXT_EVOLUTION from pokemon  WHERE namepokemon like ?";
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1, "%" +nome+ "%");
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new Pokemon( rs.getInt("NUM"), rs.getString("namePokemon"), rs.getString("TIPO"),rs.getString("PRE_EVOLUTION"),rs.getString("NEXT_EVOLUTION")); 
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao obter os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
				if (rs != null) 
					rs.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		return p;
	}

	@Override
	public void inserir(Pokemon pokemon) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = ("INSERT INTO POKEMON (num,namePokemon,TIPO,PRE_EVOLUTION,NEXT_EVOLUTION) VALUES (?,?,?,?,?)");
			ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, pokemon.getNum());
			ps.setString(2, pokemon.getName());
			ps.setString(3, pokemon.getNext_evolution());
			ps.setString(4, pokemon.getPre_evolution());
			ps.setString(5, pokemon.getTipo());
			ps.execute();

		} catch (SQLException e) {
			throw new Exception("Erro ao obter os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
				if (rs != null) 
					rs.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		
		
	}

	@Override
	public void alterar(Pokemon pokemon) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE POKEMON SET  namePokemon=?, TIPO=?, PRE_EVOLUTION=?,NEXT_EVOLUTION=? WHERE NUM=? ";
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1, pokemon.getName());
			ps.setString(2, pokemon.getNext_evolution());
			ps.setString(3, pokemon.getPre_evolution());
			ps.setString(4, pokemon.getTipo());
			ps.setInt(5, pokemon.getNum());
			ps.execute();
		} catch(SQLException e) {
			throw new Exception("Erro ao alterar os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		
	}
		

	@Override
	public void remover(Pokemon pokemon) throws Exception {
		PreparedStatement ps = null;
		try {
			String sql = "DELETE FROM POKEMON WHERE NUM=? ";
			ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, pokemon.getNum());
			ps.execute();
		} catch(SQLException e) {
			throw new Exception("Erro ao remover os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		
	}

	
	@Override
	public Pokemon porNum(int num) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pokemon p = null;
		try {
			String sql = "SELECT NUM, namePokemon, TIPO, PRE_EVOLUTION, NEXT_EVOLUTION from pokemon  WHERE NUM=?";
			ps = this.conexao.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new Pokemon( rs.getInt("NUM"), rs.getString("namePokemon"), rs.getString("TIPO"),rs.getString("PRE_EVOLUTION"),rs.getString("NEXT_EVOLUTION")); 
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao obter os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
				if (rs != null) 
					rs.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		return p;
	}
	
	
	public Pokemon porTipo(String tipo) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Pokemon p = null;
		try {
			String sql = "SELECT NUM, namePokemon, TIPO, PRE_EVOLUTION, NEXT_EVOLUTION from pokemon  WHERE tipo like ?";
			ps = this.conexao.prepareStatement(sql);
			ps.setString(1, "%" +tipo+ "%");
			rs = ps.executeQuery();
			if(rs.next()) {
				p = new Pokemon( rs.getInt("NUM"), rs.getString("namePokemon"), rs.getString("TIPO"),rs.getString("PRE_EVOLUTION"),rs.getString("NEXT_EVOLUTION")); 
			}
		} catch (SQLException e) {
			throw new Exception("Erro ao obter os Pokemons do banco de dados", e);
		}finally {
			try {
				ps.close();
				if (rs != null) 
					rs.close();
			}catch (SQLException e) {
				throw new Exception("Erro ao fechar manipuladores de banco de dados", e);
			}
		}
		return p;
	}

}
	
