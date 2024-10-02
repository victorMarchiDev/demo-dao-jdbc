package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	//CRIANDO OBJETO DE CONEXAO
	public static Connection conn = null;
	
	//METODO PARA GERAR CONEXAO COM BANCO DE DADOS.
	public static Connection getConnection() {
		if(conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		return conn;
	}
	
	//METODO PARA FECHAR A CONEXAO DO BANCO.
	public static void closeConnection() {
		if(conn != null) {
			try {
			conn.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	//METODO PARA CARREGAR AS PROPRIEDADES QUE ESTAO DEFINIDAS NO ARQUIDO DB.PROPERTIES
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	//METODO PARA FECHAR UMA CONEXAO DO OBJETO STATEMENT
	public static void closeStatement(Statement st) {
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//METODO PARA FECHAR UMA CONEXAO DO OBJETO RESULT SET
	public static void closeResultSet(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}
