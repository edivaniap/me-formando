package com.meformando.web.visao;

import java.util.List;
import java.util.Scanner;

import com.meformando.web.controle.ConviteControle;
import com.meformando.web.controle.FormandoControle;
import com.meformando.web.controle.TurmaControle;
import com.meformando.web.modelo.Convite;
import com.meformando.web.modelo.Formando;
import com.meformando.web.modelo.Turma;

public class Main {
	public static void main(String[] args) {
		Scanner leia;
		int opcao = 0;
		do {
			System.out.println("    SISTEMA DE GERENCIAMENTO DE FORMATURAS");
			System.out.println("1 - Entrar no sistema");
			System.out.println("2 - Cadastrar-se");
			System.out.println("3 - Encerrar");
			
			leia = new Scanner(System.in);
			opcao = leia.nextInt();
			
			if(opcao == 1) {
				entrarSistema();
			} else if(opcao == 2) {
				cadastrarFormando();
			}else if(opcao == 3) {
				System.out.println("Encerrando...");
			} else {
				System.out.println("Inválido");
			}
			
		} while(opcao != 3);
		leia.close();
		System.out.println("Encerrado");
	}
	
	public static void entrarSistema() {
		Formando flogado = null;
		FormandoControle formandoControle = new FormandoControle();
		ConviteControle conviteControle;
		
		Scanner leia = new Scanner(System.in);
		
		String email; String senha;
		
		//login
		System.out.println("--- Entrar no sistema ---");
		System.out.println("Email: ");
		email = leia.nextLine();
		System.out.println("Senha: ");
		senha = leia.nextLine();
		
		flogado = formandoControle.login(email, senha);
		
		// se login NAO deu certo
		if(flogado == null) {
			System.err.println("Usuario não encontrado. Email ou senha podem estar errados.");	
		
		// se login deu certo
		} else {
			System.out.println("    SISTEMA DE GERENCIAMENTO DE FORMATURAS");
			System.out.println("Olá, " + flogado.getpNome() + "\n");			
			
			conviteControle = new ConviteControle();
			List<Convite> convites = conviteControle.getConvitesByFormandoId(flogado.getId());
			
			Integer opcao = 0;
			
			// se usuario possui uma turma
			if(flogado.getTurma() != null) {
				System.out.println("<Turma: " + flogado.getTurma().getTitulo() + ", Curso: " + flogado.getTurma().getCurso() + ", Semestre: " + flogado.getTurma().getSemestre_formacao() +">\n");
							
				if(flogado.isComissao()) {
					System.out.println("-- Você faz parte da comissão da turma --");
					System.out.println("1 - Convidar formando para turma");
					System.out.println("2 - Criar votação ");
					System.out.println("4 - Visualizar mensalidades");
					System.out.println("...");
					System.out.println("N - Sair");
				} else {
					System.out.println("1 - Convidar formando para turma");
					System.out.println("2 - Criar votação ");
					System.out.println("4 - Visualizar mensalidades");
					System.out.println("...");
					System.out.println("N - Sair");
				}
				
				System.out.println("Informe qualquer coisa para sair... Funcoes ainda nao implementadas");
				String parar = leia.nextLine();
			} else {
				//se nao possui uma turma
				do {
					System.out.println("-- Você ainda não está em uma turma. --");
					System.out.println("1 - Criar nova turma");
					System.out.println("2 - Ver convites ("+ convites.size() +")");
					System.out.println("3 - Sair");
					opcao = leia.nextInt();
					
					if(opcao == 1) {
						//CADASTRAR TURMA
						cadastrarTurma(flogado.getId());
						opcao = 3; //sair pra reiniciar
					} else if(opcao == 2) {
						//VER CONVITES
						for(int i = 0; i < convites.size(); i++) {
							System.out.println("Convite "+ (i+1) +"/" + convites.size() +":");
							System.out.println(convites.get(i).toString());
							System.out.println(">> Aceitar (sim/nao/pular)? ");
							
							leia = new Scanner(System.in);
							String aceitar = leia.nextLine();
							
							if(aceitar.toLowerCase().equals("sim")) {
								conviteControle.aceitarConvite(convites.get(i));
								System.out.println("Aceito");
								opcao = 3; //sair pra reiniciar
								break;
							} else if(aceitar.toLowerCase().equals("nao")) {
								conviteControle.recusarConvite(convites.get(i));
								System.out.println("Recusado");
							}
						}
					} 
					
					if(opcao == 3) {
						flogado = null;
						System.out.println("Logout...");
					}
				} while(opcao != 3);
			}
		}
	}
	
	public static void cadastrarTurma(Integer id_super_formando) {
		Turma turma = new Turma();
		TurmaControle turmaControle = new TurmaControle();
		
		Scanner leia = new Scanner(System.in);
		
		System.out.println("--- Cadastro de turma ---");
		
		System.out.println("Titulo: ");
		turma.setTitulo(leia.nextLine());
		System.out.println("Curso: ");
		turma.setCurso(leia.nextLine());
		System.out.println("Instituicao: ");
		turma.setInstituicao(leia.nextLine());
		System.out.println("Semestre (ano.periodo): ");
		turma.setSemestre_formacao(leia.nextLine());
		
		turmaControle.adicionar(turma, id_super_formando);
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
	}

}
