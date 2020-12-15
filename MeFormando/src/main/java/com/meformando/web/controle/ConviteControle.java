package com.meformando.web.controle;

import java.util.List;

import com.meformando.dao.ConviteDAO;
import com.meformando.web.modelo.Convite;

public class ConviteControle {
	ConviteDAO conviteDAO = new ConviteDAO();
	
	public void aceitarConvite(Convite convite) {
		conviteDAO.atualizarStatus(convite.getFormando().getId(), "Aceito");
	}
	
	public void recusarConvite(Convite convite) {
		conviteDAO.atualizarStatus(convite.getFormando().getId(), "Recusado");
	}
	
	public List<Convite> getConvitesByFormandoId(Integer id_convidado) {
		return conviteDAO.selecionaPorIDConvidado(id_convidado);
	}
}
