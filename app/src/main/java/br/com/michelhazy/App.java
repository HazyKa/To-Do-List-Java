package br.com.michelhazy;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {

        Scanner scan = new Scanner(System.in);
        FuncaoDesejada metodosFuncao = new FuncaoDesejada();

        System.out.println("O que deseja fazer?\n 1 - Mostrar Task's\n 2 - Nova Task\n 3 - Concluir Task\n 4 - Deletar Task \n 5 - Editar Task");
        int funcaoDesejada = scan.nextInt();

        metodosFuncao.opcaoEscolhida(funcaoDesejada);
    }
}

//run - 1-mostrar 2-nova 3-deletar 4-concluida 5-modificar
//Digitar tarefa - captura do console - chamo funcao com sql - guarda banco de dados - dou retorno de "adicionado"