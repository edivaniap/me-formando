package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meformando.web.modelo.Decisao;
import com.meformando.web.util.ConexaoMySQL;

public class DecisaoDAO {
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void inserir(Decisao d) {
		conexao = ConexaoMySQL.getConexao();

		try {
			ps = conexao.prepareCall("INSERT INTO decisao (titulo, descricao, is_finalizada, is_arquivada, turma_id) VALUES (?, ?, ?, ?, ?)");
			
			ps.setString(1, d.getTitulo());
			ps.setString(2, d.getDescricao());
			ps.setBoolean(3, d.isIs_finalizada());
			ps.setBoolean(4, d.isIs_finalizada());
			ps.setInt(5, d.getTurma().getId());
			
			ps.execute();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
			
		ConexaoMySQL.fecharConexao();
	}
	
	public List<Decisao> listar() {
		conexao = ConexaoMySQL.getConexao();
		List<Decisao> dlist = new ArrayList<Decisao>();
		try {
			ps = conexao.prepareCall("SELECT * FROM decisao");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Decisao d = new Decisao();
				
				d.setId(rs.getInt("id"));
				d.setTitulo(rs.getString("titulo"));
				d.setDescricao(rs.getString("descricao"));
				d.setIs_finalizada(rs.getBoolean("is_finalizada"));
				d.setIs_arquivada(rs.getBoolean("is_arquivada"));				
				//-- pegar turma para d.setTurma()
				
				dlist.add(d);
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
		return dlist;
	}
}
