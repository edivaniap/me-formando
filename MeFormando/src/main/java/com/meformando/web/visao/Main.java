package com.meformando.web.visao;

import java.util.Scanner;

import com.meformando.web.controle.FormandoControle;
import com.meformando.web.modelo.Formando;

public class Main {
	public static void main(String[] args) {
		
		Formando formando = new Formando();
		FormandoControle formandoControle = new FormandoControle();
		
		Scanner leia = new Scanner(System.in);
				
		System.out.println("Informe o primeiro nome: ");
		formando.setpNome(leia.nextLine());
		System.out.println("Informe o ultimo nome: ");
		formando.setuNome(leia.nextLine());
		System.out.println("Informe o CPF: ");
		formando.setCpf(leia.nextLine());
		System.out.println("Informe o email: ");
		formando.setEmail(leia.nextLine());
		System.out.println("Crie uma senha: ");
		formando.setSenha(leia.nextLine());
		
		formandoControle.adicionar(formando);
		
		System.out.println("Fim por fim feito por mim");
	}



}
