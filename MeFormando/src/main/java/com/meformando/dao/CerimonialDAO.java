package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meformando.web.modelo.Cerimonial;
import com.meformando.web.util.ConexaoMySQL;

public class CerimonialDAO {
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void inserir(Cerimonial c) {
		conexao = ConexaoMySQL.getConexao();

		try {
			ps = conexao.prepareCall("INSERT INTO cerimonial (nome, descricao) VALUES (?, ?)");
			
			ps.setString(1, c.getNome());
			ps.setString(2, c.getDescricao());
			
			ps.execute();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
			
		ConexaoMySQL.fecharConexao();
	}
	
	public List<Cerimonial> listar() {
		conexao = ConexaoMySQL.getConexao();
		List<Cerimonial> clist = new ArrayList<Cerimonial>();
		try {
			ps = conexao.prepareCall("SELECT * FROM cerimonial");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cerimonial c = new Cerimonial();
				
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setDescricao(rs.getString("descricao"));
				
				clist.add(c);
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
		return clist;
	}
}
