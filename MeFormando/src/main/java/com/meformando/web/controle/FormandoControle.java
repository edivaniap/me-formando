package com.meformando.web.controle;

import java.sql.SQLException;

import com.meformando.dao.FormandoDAO;
import com.meformando.web.modelo.Formando;

public class FormandoControle {
	FormandoDAO formandoDAO = new FormandoDAO();
	
	public void adicionar(Formando formando) {
		formandoDAO.inserir(formando);
	}
}
