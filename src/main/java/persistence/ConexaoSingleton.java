package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSingleton {
	
 private static Connection conexao; 
		
 private static Connection novaConexao() throws Exception {
	Connection con = null;
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/basepokemon?useTimezone=true&serverTimezone=UTC","root","root");
	}catch(SQLException e) {
		throw new Exception("Erro ao conectar com o banco de dados!", e);		
	}catch(ClassNotFoundException e) {
		throw new Exception("Erro no driver do banco de dados!", e);	
	}
	return con;
 }
 public static Connection getConexao() throws Exception{
	 if(conexao == null)
		 conexao = novaConexao();
	 return conexao;
	 
 }
 public static void finalizarConexao() throws Exception{
	 try {
		 conexao.close();
	 }catch (SQLException e) {
		throw new Exception("Erro ao fechar a conexao com o banco de dados", e);
		
	}
		 conexao = null;
 
 }
}







