package com.meformando.web.controle;

import com.meformando.dao.ConviteDAO;
import com.meformando.dao.FormandoDAO;
import com.meformando.dao.TurmaDAO;
import com.meformando.web.modelo.Turma;

public class TurmaControle {
	TurmaDAO turmaDAO = new TurmaDAO();
	
	public void adicionar(Turma turma, Integer id_criador) {
		Integer last_id = turmaDAO.inserir(turma);
		
		//seta um convite pra o criador pra ele ser reconhecido como integrante da turma
		ConviteDAO conviteDAO = new ConviteDAO();
		conviteDAO.inserir("Aceito", id_criador, id_criador, last_id);
		
		//torna formando um membro da comissao
		FormandoDAO formandoDAO = new FormandoDAO();
		formandoDAO.atualizarIsComissao(id_criador, true); //muda iscomissao para true
	}
}
