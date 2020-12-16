package com.meformando.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.meformando.web.modelo.Turma;
import com.meformando.web.util.ConexaoMySQL;

public class TurmaDAO {
	private Connection conexao;
	private PreparedStatement ps;
	private ResultSet rs;
	
	//retorna o ID da turma inserida
	public Integer inserir(Turma t) {
		conexao = ConexaoMySQL.getConexao();
		Integer last_inserted_id = null;
		try {
			ps = conexao.prepareCall("INSERT INTO turma (titulo, instituicao, semestre_formacao, curso) VALUES (?, ?, ?, ?)");
			
			ps.setString(1, t.getTitulo());
			ps.setString(2, t.getInstituicao());
			ps.setString(3, t.getSemestre_formacao());
			ps.setString(4, t.getCurso());
			
			ps.execute();
			
			rs = ps.getGeneratedKeys();
            if(rs.next())
            {
                last_inserted_id = rs.getInt(1);
            }
			
			System.out.println("Cadastrado com sucesso!");
		} catch (SQLException se) {
			System.err.println("Erro de SQL: " + se);
		} catch(Exception e) {
			System.err.println("Erro: " + e);
		}
			
		ConexaoMySQL.fecharConexao();
		return last_inserted_id;
	}
}
