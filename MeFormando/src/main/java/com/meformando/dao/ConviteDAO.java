package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.meformando.web.modelo.Formando;
import com.meformando.web.modelo.Turma;
import com.meformando.web.modelo.Convite;
import com.meformando.web.util.ConexaoMySQL;

import java.util.ArrayList;
import java.util.List;

public class ConviteDAO {
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
	/* @param id ID do Formando convidado */
	public List<Convite> selecionaPorIDConvidado(Integer id) {
		conexao = ConexaoMySQL.getConexao();
		
		List<Convite> clist = new ArrayList<Convite>();
		try {
			ps = conexao.prepareCall(""
					+ "SELECT c.*, t.*, fsuper.pnome, fsuper.unome, fsuper.email FROM convite c "
					+ "JOIN formando fsuper ON c.super_formando_id = fsuper.id "
					+ "JOIN turma t ON t.id = c.turma_id "
					+ "WHERE c.formando_id = ?");
		
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Convite c = new Convite();
				Turma t = new Turma();
				Formando fsuper = new Formando();
				Formando f = new Formando();
				
				f.setId(id);
												
				fsuper.setId(rs.getInt("c.super_formando_id"));
				fsuper.setuNome(rs.getString("fsuper.unome"));
				fsuper.setpNome(rs.getString("fsuper.pnome"));
				fsuper.setEmail(rs.getString("fsuper.email"));
				
				t.setId(rs.getInt("c.turma_id"));
				t.setTitulo(rs.getString("t.titulo"));
				t.setInstituicao(rs.getString("t.instituicao"));
				t.setCurso(rs.getString("t.curso"));
				t.setSemestre_formacao(rs.getString("t.semestre_formacao"));
				
				c.setStatus(rs.getString("c.status"));
				c.setSuper_formando(fsuper);
				c.setFormando(f);
				c.setTurma(t);
				
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
	
	/* @param id identificacao do convite a ser atualizado
	 * @param novoStatus palavra do novo status */
	public void atualizarStatus(Integer id, String novoStatus) {
		conexao = ConexaoMySQL.getConexao();
		
		try {
			ps = conexao.prepareCall("UPDATE convite SET status = ? WHERE formando_id = ?");
			
			ps.setString(1, novoStatus);
			ps.setInt(2, id);
			
			ps.execute();
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		ConexaoMySQL.fecharConexao();
	}
	
	/* @param id ID do Formando convidado */
	public Convite selecionaAceitoById(Integer id) {
		conexao = ConexaoMySQL.getConexao();
		
		Convite c = null;
		try {
			ps = conexao.prepareCall(""
					+ "SELECT c.*, t.*, fsuper.pnome, fsuper.unome, fsuper.email FROM convite c "
					+ "JOIN formando fsuper ON c.super_formando_id = fsuper.id "
					+ "JOIN turma t ON t.id = c.turma_id "
					+ "WHERE c.formando_id = ? AND c.status = 'Aceito'");
		
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Convite();
				Turma t = new Turma();
				Formando fsuper = new Formando();
				Formando f = new Formando();
				
				f.setId(id);
												
				fsuper.setId(rs.getInt("c.super_formando_id"));
				fsuper.setuNome(rs.getString("fsuper.unome"));
				fsuper.setpNome(rs.getString("fsuper.pnome"));
				fsuper.setEmail(rs.getString("fsuper.email"));
				
				t.setId(rs.getInt("c.turma_id"));
				t.setTitulo(rs.getString("t.titulo"));
				t.setInstituicao(rs.getString("t.instituicao"));
				t.setCurso(rs.getString("t.curso"));
				t.setSemestre_formacao(rs.getString("t.semestre_formacao"));
				
				c.setStatus(rs.getString("c.status"));
				c.setSuper_formando(fsuper);
				c.setFormando(f);
				c.setTurma(t);
			}
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
		
		return c;
	}
	
	public void inserir(String status, Integer id_superf, Integer id_f, Integer id_t) {
		conexao = ConexaoMySQL.getConexao();

		try {
			ps = conexao.prepareCall("INSERT INTO convite (status, formando_id, super_formando_id, turma_id) VALUES (?,?,?,?)");
			
			ps.setString(1, status);
			ps.setInt(2, id_f);
			ps.setInt(3, id_superf);
			ps.setInt(4, id_t);
			ps.execute();
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
			
		ConexaoMySQL.fecharConexao();
	}
}
