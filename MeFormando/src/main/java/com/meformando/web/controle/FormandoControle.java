package com.meformando.web.controle;

import java.sql.SQLException;

import com.meformando.dao.FormandoDAO;
import com.meformando.web.modelo.Formando;

public class FormandoControle {
	FormandoDAO formandoDAO = new FormandoDAO();
	
	public void adicionar(Formando formando) {
		formandoDAO.inserir(formando);
	}
	
	public void editar(Formando formando) {
		formandoDAO.atualizar(formando);
	}
	
	public Formando getPorID(Integer id) {
		return formandoDAO.selecionar(id);
	}
}
