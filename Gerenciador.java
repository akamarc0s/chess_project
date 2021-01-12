package chess;
import java.util.InputMismatchException;
import java.util.Scanner;
// Marcos Antonio de Santana Júnior
// 771040
public class Gerenciador {
    
    public static void main(String[] args) {
       Jogo j;
        Scanner sc = new Scanner(System.in);
        System.out.println("===============  XADREZ ====================");
        j = new Jogo();
        System.out.println("===========  SEJA BEM VINDO! ===============");
        int escolha;
        
        while (true)
        {
            try
            {
            System.out.println("============================================");
            System.out.println("1- Iniciar um novo jogo");
            System.out.println("2- Carregar um jogo");
            System.out.println("============================================"); 
            escolha = sc.nextInt();

                if (escolha == 1){
                sc.nextLine();
                System.out.println("DIGITE O NOME DO PRIMEIRO JOGADOR! (PEÇAS BRANCAS)");
                j.getJogador1().setNome(sc.nextLine());
                System.out.println("JOGADOR (" + j.getJogador1().getNome().toUpperCase() + ") DAS PEÇAS DE CORES BRANCA CADASTRADO COM SUCESSO!");
                System.out.println("=============================================");
                System.out.println("DIGITE O NOME DO SEGUNDO JOGADOR! (PEÇAS PRETAS)");
                j.getJogador2().setNome(sc.nextLine());
                System.out.println("JOGADOR (" + j.getJogador2().getNome().toUpperCase() + ") DAS PEÇAS DE CORES PRETA CADASTRADO COM SUCESSO!");
                System.out.println("=============================================");
                j.inicializaJogo();
                sc.close();
                System.exit(0);
                }

                if (escolha == 2){ // caso deseja ler um arquivo
                    j.carregarJogo();
                }
                
                if (escolha > 2){ 
                    System.out.println("DIGITE UMA ENTRADA VÁLIDA!");
                    sc.nextLine();
                } 

            }catch(InputMismatchException e){
                System.out.println("DIGITE UMA ENTRADA VÁLIDA!");
                sc.nextLine();
            }
        }
    }
}
