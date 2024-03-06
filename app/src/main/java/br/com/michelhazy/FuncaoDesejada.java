package br.com.michelhazy;

import java.util.Scanner;

public class FuncaoDesejada {

    Scanner scan = new Scanner(System.in);
    FuncaoDesejadaDAO dao = new FuncaoDesejadaDAO();
    
    public void opcaoEscolhida(int n){
        if(n == 1){
            mostrarTask();
        }else if(n == 2){
            adicionarTask();
        }else if(n == 3){
            concluirTask();
        }else if(n == 4){
            deletarTask();
        }else if(n == 5){
            editarTask();
        }
    }

    private void mostrarTask(){
        dao.mostrar();
    }
    private void adicionarTask(){
        System.out.println("Escreva a task que deseja adicionar:");
        String task = scan.nextLine();
        dao.adicionar(task);
    }
    private void concluirTask(){
        System.out.println("Digite o ID da task que deseja concluir");
        dao.mostrar();
        int task = scan.nextInt();
        dao.concluir(task);
    }
    private void deletarTask(){
        System.out.println("Digite o ID da task que deseja remover");
        dao.mostrar();
        int task = scan.nextInt();
        dao.deletar(task);
    }
    private void editarTask(){
        System.out.println("Digite o ID da task que deseja editar:");
        dao.mostrar();
        int task = scan.nextInt();
        scan.nextLine();
        System.out.println("Escreva a edicao que deseja:");
        String edicao = scan.nextLine();
        dao.editar(task, edicao);
    }

}
