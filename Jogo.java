package chess;
// Marcos Antonio de Santana Júnior
// 771040
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {
    
    private boolean statusDoJogo; 
    private Tabuleiro tabuleiro;
    private Jogador jogador1, jogador2; 
    private Peca[] pecas = new Peca[32];

    public Jogo(){
        inicializaPecas(); // as peças devem ser inicializadas para que possa ser passada como parametro dos jogadores
        this.jogador1 = new Jogador("branco", pecas);
        this.jogador2 = new Jogador("preto", pecas);
    }
        
    public boolean isStatusDoJogo() {
        return statusDoJogo;
    }

    public void setStatusDoJogo(boolean statusDoJogo) {
        this.statusDoJogo = statusDoJogo;
    }

    public Jogador getJogador1() {
        return jogador1;
    }

    public Jogador getJogador2() {
        return jogador2;
    }
    
    public void inicializaJogo() {
        this.tabuleiro = new Tabuleiro(pecas); // será criado um tabuleiro para o jogo
        setStatusDoJogo(true); // o jogo está ativo
        jogar(); // inicio do jogo
    }
    
    private void inicializaPecas() { // inicialização manual das 32 peças (16 brancas e 16 pretas) 
        this.pecas[0] = new Torre ("branco");
        this.pecas[1] =  new Cavalo("branco");
        this.pecas[2] = new Bispo("branco");
        this.pecas[3] = new Rainha("branco");
        this.pecas[4] = new Rei("branco");
        this.pecas[5] = new Bispo("branco");
        this.pecas[6] = new Cavalo("branco");
        this.pecas[7] = new Torre("branco");
        this.pecas[8] = new Peao("branco");
        this.pecas[9] = new Peao("branco");
        this.pecas[10] = new Peao("branco");
        this.pecas[11] = new Peao("branco");
        this.pecas[12] = new Peao("branco");
        this.pecas[13] = new Peao("branco");
        this.pecas[14] = new Peao("branco");
        this.pecas[15] = new Peao("branco");
        this.pecas[16] = new Torre ("preto");
        this.pecas[17] =  new Cavalo("preto");
        this.pecas[18] = new Bispo("preto");
        this.pecas[19] = new Rainha("preto");
        this.pecas[20] = new Rei("preto");
        this.pecas[21] = new Bispo("preto");
        this.pecas[22] = new Cavalo("preto");
        this.pecas[23] = new Torre("preto");
        this.pecas[24] = new Peao("preto");
        this.pecas[25] = new Peao("preto");
        this.pecas[26] = new Peao("preto");
        this.pecas[27] = new Peao("preto");
        this.pecas[28] = new Peao("preto");
        this.pecas[29] = new Peao("preto");
        this.pecas[30] = new Peao("preto");
        this.pecas[31] = new Peao("preto");
    }
            
     private void jogar(){ // função responsável pelo acontecimento de jogo, recebe as coordenadas de movimentação, imprime status atual do tabuleiro e verifica o status do jogo - possível xeque ou xeque mate -
         Scanner ler = new Scanner(System.in);
         String jogadaOrigem,jogadaDestino; // coordenadas das jogadas
         System.out.println("INÍCIO DO JOGO!");
         System.out.println("CASO DESEJE FINALIZAR O JOGO DIGITE DUAS VEZES 00");
         System.out.println("CASO DESEJE SALVAR O JOGO DIGITE DUAS VEZES 11");
         System.out.println("==================================================");
         tabuleiro.desenhoTab();
         while (true) // primeiro while só deve ser quebrado caso haja um xeque mate
         {
            System.out.println("============ JOGADA JOGADOR BRANCO ============");
            while (true) // só deve se sair desse while caso a jogada seja efetivada com sucesso
            {
                System.out.println("DIGITE A COORDENADA DE ORIGEM:");
                jogadaOrigem = ler.nextLine();
                System.out.println("DIGITE A COORDENADA DE DESTINO:");
                jogadaDestino = ler.nextLine();
                if (movePeca(jogadaOrigem, jogadaDestino, tabuleiro,jogador1))
                {
                    break;
                }
            }
            
            tabuleiro.desenhoTab();
            if (tabuleiro.verificaXequeMate("preto")){break;}
            if (tabuleiro.verificaXeque("preto"))
            {
                System.out.println("JOGADOR PRETO EM XEQUE!");
            }
            
            System.out.println("============ JOGADA JOGADOR PRETO ============");
            while (true) // só deve se sair desse while caso a jogada seja efetivada com sucesso
            {
                System.out.println("DIGITE A COORDENADA DE ORIGEM:");
                jogadaOrigem = ler.nextLine();
                System.out.println("DIGITE A COORDENADA DE DESTINO:");
                jogadaDestino = ler.nextLine();
                if (movePeca(jogadaOrigem, jogadaDestino, tabuleiro,jogador2))
                {
                    break;
                }
            }
            
            tabuleiro.desenhoTab();
            if (tabuleiro.verificaXequeMate("branco")){break;}
            if (tabuleiro.verificaXeque("branco"))
            {
                System.out.println("JOGADOR BRANCO EM XEQUE!");
            }
        }
         System.out.println("O JOGO ACABOU");         
         if (!this.pecas[20].isStatus()) System.out.println("JOGADOR DAS PEÇAS BRANCAS ("+ jogador1.getNome().toUpperCase() + ") VENCEU!"); // caso o rei do jogador preto nao esteja ativo
         if (!this.pecas[4].isStatus()) System.out.println("JOGADOR DAS PEÇAS PRETAS (" + jogador2.getNome().toUpperCase() + ") VENCEU!"); // casoo rei do jogador branco nao esteja ativo
     }
     
    public boolean movePeca(String coordenadaOrigem, String coordenadaDestino, Tabuleiro t, Jogador j) // método responsavel pela comunicação com o tabuleiro para a execução de movimento das peças de acordo com as coordenadas
    {
        if (coordenadaOrigem.equals("00") && coordenadaDestino.equals("00"))
        {
                System.out.println("JOGO FINALIZADO!");
                System.exit(0);
        }
        if (coordenadaOrigem.equals("11") && coordenadaDestino.equals("11"))
        {
            salvarJogo(t);
        }
        try
        {
            // transforma as coordenadas passadas em variavéis
            int linhaOrigem = Integer.parseInt(String.valueOf(coordenadaOrigem.charAt(1)))-1;
            char colunaOrigem = coordenadaOrigem.charAt(0);
            int linhaDestino = Integer.parseInt(String.valueOf(coordenadaDestino.charAt(1)))-1;
            char colunaDestino = coordenadaDestino.charAt(0);
            Posicao origem = t.getPosicao(linhaOrigem, colunaOrigem); // referencia a posição de origem irá auxiliar para verificar a movimentação da peça
            if(origem.isOcupada()) // a origem precisa estar ocupada para se realizar um movimento
            {
                if(origem.getPeca().getCor() == j.getCor()) // a peça precisa ser da cor do jogador
                {    
                    if(t.movimenta(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino,true)) // chamada do método de movimentação do tabuleiro
                    {
                        return true;
                    }
                    else
                    {
                        System.out.println("ESSE MOVIMENTO É INVÁLIDO!");
                        return false;
                    }
                }
                else
                {
                    System.out.println("ESSA PEÇA NÃO PERTENCE A ESSE JOGADOR!");
                    return false;
                }
            }
            else
            {
                System.out.println("ESSA POSIÇÃO NAO POSSUÍ UMA PEÇA!");
                return false;
            }
        } catch (Exception e){
            System.out.println("ALGUMA COORDENADA INFORMADA NÃO EXISTE!");
            return false;
        }  
    }
    
    private void salvarJogo(Tabuleiro t){ // método chamado caso o jogador branco decida salvar o jogo
        System.out.println("DIGITE COMO DESEJA SALVAR O NOME DO ARQUIVO:");
        Scanner sc = new Scanner(System.in);
        try{
            FileWriter armOp = new FileWriter(sc.nextLine() + ".txt"); // será escrito em um arquivo as propriedades desse jogo para um futura leitura
            armOp.write(jogador1.getNome() + "\n"); // nome do jogador 1
            armOp.write(jogador2.getNome() + "\n");// nome do jogador 2
            for (int i = 7; i >= 0; --i)
            {
                char jChar = 'a';
                for (int j = 0; j <=7; j++)
                {
                    armOp.write(t.getPosicao(i, jChar).getLinha() + " " + t.getPosicao(i, jChar).getColuna() + " "); // é escrito em uma linha separado por espaços a linha e a coluna para futura leitura
                    
                    if (t.getPosicao(i, jChar).isOcupada())
                    {
                        armOp.write(t.getPosicao(i, jChar).getPeca().desenho()); // se a posição está ocupada se escreve tambem o desenho da peça que a ocupa
                    }
                    armOp.write("\n");
                    
                    jChar++;
                }
            }
            armOp.close();
            System.out.println("ARQUIVO REGISTRADO COM SUCESSO!");
            sc.close();
            System.exit(0);
        }catch(IOException e ){
            System.out.println("NÃO FOI POSSÍVEL CRIAR ESSE ARQUIVO!");
        }
    }
    
    public void carregarJogo(){
        this.tabuleiro = new Tabuleiro(pecas); // será criado um tabuleiro para o jogo
        while(true)
        { 
            try
            {
                Scanner sc = new Scanner(System.in);
                System.out.println("POR FAVOR, INFORME O NOME DO ARQUIVO QUE DESEJA LER: ");
                FileReader auxArquivo = new FileReader(sc.nextLine()+".txt");
                Scanner auxLeitura = new Scanner(auxArquivo);                            
                this.jogador1.setNome(auxLeitura.nextLine());
                this.jogador2.setNome(auxLeitura.nextLine());
             while (auxLeitura.hasNextLine()) 
             {
                 
                String data = auxLeitura.nextLine();
                int linhaInt = data.charAt(0) - 48;
                if (data.length() > 4)
                {
                    if (data.length() > 6)
                    {
                        if (data.charAt(6) == '+')
                        {
                            tabuleiro.carregarPosicao(linhaInt, data.charAt(2), "D+");
                        }
                        else
                        {
                           tabuleiro.carregarPosicao(linhaInt, data.charAt(2), "D-"); 
                        }
                    }
                    else
                    {
                        String auxDesenho = data.substring(4,6);                        
                        tabuleiro.carregarPosicao(linhaInt, data.charAt(2), auxDesenho);
                    }
                }
                else
                {
                    tabuleiro.carregarPosicao(linhaInt, data.charAt(2));
                }
             }
                jogar();
                break;
            } catch (FileNotFoundException e) // caso seja passado um nome de arquivo não existente, esse catch deve ser disparado
            {
                System.out.println("NÃO É POSSÍVEL CARREGAR ESTE ARQUIVO!");
            }
        }
    }
}
