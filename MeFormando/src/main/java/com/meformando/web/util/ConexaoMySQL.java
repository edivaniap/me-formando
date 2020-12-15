package com.meformando.web.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQL {
	private static Connection conexao;
	private static final String mySQLDriver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/me_formando?useTimezone=true&amp&serverTimezone=UTC";
	private static final String user = "edivania";
	private static final String pass = "654321";
    
	public static Connection getConexao() {
    	if(conexao == null) {
	    	try {
	    		Class.forName(mySQLDriver);
	    		conexao = DriverManager.getConnection(url, user, pass);
	    	} catch (SQLException ex) {
	    		Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
	    	} catch (ClassNotFoundException ex) {
	    		Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
			}
    	}
    	
    	return conexao;        
    }
	
	public static void fecharConexao() {
		if(conexao != null) {
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException ex) {
	    		Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, ex);
	    	}
		}
	}
}
