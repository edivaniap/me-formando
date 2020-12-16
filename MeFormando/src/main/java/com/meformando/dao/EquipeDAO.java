package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meformando.web.modelo.Equipe;
import com.meformando.web.util.ConexaoMySQL;

public class EquipeDAO {
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void inserir(Equipe e) {
		conexao = ConexaoMySQL.getConexao();

		try {
			ps = conexao.prepareCall("INSERT INTO equipe (titulo, tarefa_id) VALUES (?, ?)");
			
			ps.setString(1, e.getTitulo());
			ps.setInt(2, e.getTarefa().getId());
			
			ps.execute();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception ex) {
			System.err.println("Erro: " + ex);
		}
			
		ConexaoMySQL.fecharConexao();
	}
	
	public List<Equipe> listar() {
		conexao = ConexaoMySQL.getConexao();
		List<Equipe> elist = new ArrayList<Equipe>();
		try {
			ps = conexao.prepareCall("SELECT * FROM equipe");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Equipe e = new Equipe();
				
				e.setId(rs.getInt("id"));
				e.setTitulo(rs.getString("titulo"));				
				//-- pegar tarefa para e.setTarefa()
				
				elist.add(e);
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception ex) {
			System.err.println("Erro: " + ex);
		}
		
		ConexaoMySQL.fecharConexao();
		return elist;
	}
}
