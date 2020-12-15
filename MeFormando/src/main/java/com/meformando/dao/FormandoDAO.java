package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.meformando.web.modelo.Formando;
import com.meformando.web.util.ConexaoMySQL;

public class FormandoDAO {
	
	private Connection conexao;
	private PreparedStatement ps;
	
	public void inserir(Formando f) {
		conexao = ConexaoMySQL.getConexao();

		try {
			ps = conexao.prepareCall("INSERT INTO formando (pnome, unome, email, cpf, senha, is_comissao) VALUES (?,?,?,?,?,?)");
			
			ps.setString(1, f.getpNome());
			ps.setString(2, f.getuNome());
			ps.setString(3, f.getCpf());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSenha()); 
			ps.setBoolean(6, f.isComissao());
			
			ps.execute();
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
			
		ConexaoMySQL.fecharConexao();
	}
	
	public void atualizar(Formando f) {
		conexao = ConexaoMySQL.getConexao();
		
		try {
			ps = conexao.prepareCall("UPDATE formando SET pnome = ?, unome = ?, email = ?, cpf = ?, senha = ?, is_comissao = ? WHERE id = ?");
		
			ps.setString(1, f.getpNome());
			ps.setString(2, f.getuNome());
			ps.setString(3, f.getCpf());
			ps.setString(4, f.getEmail());
			ps.setString(5, f.getSenha()); 
			ps.setBoolean(6, f.isComissao());
					
			ps.execute();
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
	}
}
