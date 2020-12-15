package com.meformando.web.visao;

import java.util.Scanner;

import com.meformando.web.controle.FormandoControle;
import com.meformando.web.modelo.Formando;

public class Main {
	public static void main(String[] args) {
		
		atualizarFormando();
		System.out.println("Fim por fim feito por mim");
	}
	
	public static void cadastrarFormando() {
		Formando formando = new Formando();
		FormandoControle formandoControle = new FormandoControle();
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("--- Cadastro de formando ---");
		
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
		leia.close();
	}
	
	public static void atualizarFormando() {
		Formando formando = null;
		FormandoControle formandoControle = new FormandoControle();
		System.out.println("--- Atualizar dados do formando ---");
		System.out.println("Aperte apenas Enter quando não quiser atualizar elemento");
		Scanner leia = new Scanner(System.in);

		System.out.println("ID: ");
		
		Integer id = null;
		id = leia.nextInt();
		
		
		formando = formandoControle.getPorID(id);
		
		if(formando != null) {
			String resposta = "";
			
			do {
				System.out.println("Deseja alterar o primeiro nome (sim/nao)? (" + formando.getpNome() +")");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					System.out.println("Informe o novo primeiro nome: ");
					leia = new Scanner(System.in);
					formando.setpNome(leia.nextLine());
				} else if(!resposta.toLowerCase().equals("nao")) {
					System.out.println("Inválido");
				}				
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
			
			resposta = "";
			
			do {
				System.out.println("Deseja alterar o ultimo nome (sim/nao)? (" + formando.getuNome() +")");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					System.out.println("Informe o novo ultimo nome: ");
					leia = new Scanner(System.in);
					formando.setuNome(leia.nextLine());
				} else if(!resposta.toLowerCase().equals("nao")) {
					System.out.println("Inválido");
				}				
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
			
			do {
				System.out.println("Deseja alterar o CPF (sim/nao)? (" + formando.getCpf() +")");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					System.out.println("Informe o novo CPF: ");
					leia = new Scanner(System.in);
					formando.setCpf(leia.nextLine());
				} else if(!resposta.toLowerCase().equals("nao")) {
					System.out.println("Inválido");
				}				
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
						
			do {
				System.out.println("Deseja alterar o Email (sim/nao)? (" + formando.getEmail() +")");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					System.out.println("Informe o novo Email: ");
					leia = new Scanner(System.in);
					formando.setEmail(leia.nextLine());
				} else if(!resposta.toLowerCase().equals("nao")) {
					System.out.println("Inválido");
				}				
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
			
			do {
				System.out.println("Deseja alterar a Senha (sim/nao)? ");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					System.out.println("Informe a nova Senha: ");
					leia = new Scanner(System.in);
					formando.setSenha(leia.nextLine());
				} else if(!resposta.toLowerCase().equals("nao")) {
					System.out.println("Inválido");
				}				
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
			
			do {
				System.out.println("Confirmar alteração (sim/nao)? ");
				
				resposta = leia.next();
				
				if(resposta.toLowerCase().equals("sim")) {
					formandoControle.editar(formando);
				} else if(resposta.toLowerCase().equals("nao")) {
					System.out.println("Cancelado");
				} else {
					System.out.println("Inválido");
				}
			} while(!resposta.toLowerCase().equals("sim") && !resposta.toLowerCase().equals("nao"));
			
		} else {
			System.out.println("Usuario nao encontrado");
		}
		leia.close();
	}

}
