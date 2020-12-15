package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meformando.web.modelo.Formando;
import com.meformando.web.util.ConexaoMySQL;

public class FormandoDAO {
	
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
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
			ps.setString(3, f.getEmail());
			ps.setString(4, f.getCpf());
			ps.setString(5, f.getSenha()); 
			ps.setBoolean(6, f.isComissao());
			ps.setInt(7, f.getId());
					
			ps.execute();
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
	}
	
	public Formando selecionar(Integer id) {
		conexao = ConexaoMySQL.getConexao();
		Formando f = null;
		try {
			ps = conexao.prepareCall("SELECT * FROM formando f WHERE f.id = ?");
		
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				f = new Formando();
				
				f.setId(rs.getInt("id"));
				f.setuNome(rs.getString("unome"));
				f.setpNome(rs.getString("pnome"));
				f.setCpf(rs.getString("cpf"));
				f.setEmail(rs.getString("email"));
				f.setComissao(rs.getBoolean("is_comissao"));
				f.setSenha(rs.getString("senha"));
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
		return f;
	}
	
	public List<Formando> listar() {
		conexao = ConexaoMySQL.getConexao();
		List<Formando> flist = new ArrayList<Formando>();
		try {
			ps = conexao.prepareCall("SELECT * FROM formando");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Formando f = new Formando();
				
				f.setId(rs.getInt("id"));
				f.setuNome(rs.getString("unome"));
				f.setpNome(rs.getString("pnome"));
				f.setCpf(rs.getString("cpf"));
				f.setEmail(rs.getString("email"));
				f.setComissao(rs.getBoolean("is_comissao"));
				f.setSenha(rs.getString("senha"));
				
				flist.add(f);
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
		return flist;
	}
}
