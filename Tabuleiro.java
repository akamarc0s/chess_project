package chess;
// Marcos Antonio de Santana Júnior
// 771040
public class Tabuleiro{
    
    private Posicao[][] posicoes = new Posicao[8][8];
    
    public Tabuleiro(Peca[] pecas) // o construtor do tabuleiro recebe as peças da classe jogo para que elas possam ser referenciadas no tabuleiro.
    {   
        this.inicializar(pecas);
    }
    
    public Posicao getPosicao(int x, char y){
        int colunaInt = y - 97;
        return posicoes[x][colunaInt];
    }
    
    private void inicializar(Peca[] pecas) // inicialização das 64 posições do tabuleiro por meio da varredura de uma matriz
    {
        for (int i = 7; i >= 0; --i)
        {
            char colunaChar = (char) ('h');
            for (int j = 7; j >=0; --j) // ao se percorrer uma condição do double for deve ser criado uma posição.
            {
                if (i == 6 || i == 7 || i == 1 || i == 0 ) // posicões em que haverá peças inicialmente
                {
                    if (i == 7) // primeira linha das peças pretas (Torre,Cavalo,Bispo,Rainha,Rei)
                    {
                        if ( j == 0 || j == 7) // coluna das Torres pretas
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 0)
                            {
                                this.posicoes[i][j].setPeca(pecas[16]); // primeira torre preta
                            }
                            if (j == 7)
                            {
                                this.posicoes[i][j].setPeca(pecas[23]); // segunda torre preta   
                            } 
                        }
                        if ( j == 1 || j == 6) // coluna dos Cavalos pretos
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 1)
                            {    
                                this.posicoes[i][j].setPeca(pecas[17]);// primeiro cavalo preto
                            }
                            if (j == 6)
                            {
                                this.posicoes[i][j].setPeca(pecas[22]);  // segundo cavalo preto   
                            }
                        }
                        if ( j == 2 || j == 5) // coluna dos Bispos pretos
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 2)
                            {
                                this.posicoes[i][j].setPeca(pecas[18]); // primeiro bispo preto 
                            }
                            if (j == 5)
                            {
                                this.posicoes[i][j].setPeca(pecas[21]);//primeiro bispo preto
                            }
                        }
                        if (j == 3) // coluna da Rainha preta
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            this.posicoes[i][j].setPeca(pecas[19]); 
                        }
                        if (j == 4) // coluna do Rei preto
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            this.posicoes[i][j].setPeca(pecas[20]);
                        }       
                    }
                    
                    if (i == 6) // criando um Peao preto (i = 6) todos da linha sao peãos.
                    {
                        this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                        this.posicoes[i][j].setPeca(pecas[j+24]); 
                    }
                    
                    if (i == 1) // criando um Peao branco (i = 1) todos da linha são peãos.
                    {
                        this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                        this.posicoes[i][j].setPeca(pecas[j+8]);     
                    }
                    
                    if (i == 0) // primeira linha das peças brancas (Torre,Cavalo,Bispo,Rainha,Rei)
                    {
                        if ( j == 0 || j == 7) // criando torres brancas 
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 0)
                            {
                                this.posicoes[i][j].setPeca(pecas[0]); // primeira torre branca
                            }
                            if (j == 7)
                            {
                                this.posicoes[i][j].setPeca(pecas[7]); // segunda torre branca
                            }
                        }
                        if ( j == 1 || j == 6) // criando cavalos brancos
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 1)
                            {
                                this.posicoes[i][j].setPeca(pecas[1]); // primeiro cavalo branco
                            }
                            if (j == 6)
                            {    
                                this.posicoes[i][j].setPeca(pecas[6]); // segundo cavalo branco
                            }
                        }
                        if ( j == 2 || j == 5) // criando bispos brancos
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            if (j == 2)
                            {    
                                this.posicoes[i][j].setPeca(pecas[2]); // primeiro bispo branco
                            }
                            if (j == 5)
                            {
                                this.posicoes[i][j].setPeca(pecas[5]); // segundo bispo branco    
                            }    
                        }
                        if (j == 3) //criando rainha branca
                        { 
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            this.posicoes[i][j].setPeca(pecas[3]); 
                        }
                        if (j == 4) // criando rei branco 
                        {
                            this.posicoes[i][j] = new Posicao(i,colunaChar,true);
                            this.posicoes[i][j].setPeca(pecas[4]); 
                        }                               
                    }
                }
                else // se nenhuma das condições de ocupação de posição é verdadeira deve se criar uma posição com o boolean de ocupado falso
                {
                    posicoes[i][j] = new Posicao(i,colunaChar,false);  
                }
                colunaChar--;   
            }
        }
        
    }
    
    public void carregarPosicao(int linhaInt, char coluna, String desenho){ // posição com peça
        int colunaInt = coluna - 97;      
        this.posicoes[linhaInt][colunaInt] = new Posicao(linhaInt, coluna,true); // criação de uma nova posição com os parametros passados
        
        // o método deve verificar o desenho da peça e setar na posição passada uma nova instancia dela.
        if (desenho.charAt(0) == 'P')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Peao("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Peao("preto")); 
            }
        }
        if (desenho.charAt(0) == 'T')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Torre("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Torre("preto")); 
            }
        }
        if (desenho.charAt(0) == 'B')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Bispo("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Bispo("preto")); 
            }
        }
        if (desenho.charAt(0) == 'C')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Cavalo("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Cavalo("preto")); 
            }
        }
        if (desenho.charAt(0) == 'R')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Rei("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Rei("preto")); 
            }
        }
        if (desenho.charAt(0) == 'D')
        {
            if (desenho.charAt(1) == '+')
            {
                this.posicoes[linhaInt][colunaInt].setPeca(new Rainha("branco"));
            }
            else if (desenho.charAt(1) == '-')
            {
               this.posicoes[linhaInt][colunaInt].setPeca(new Rainha("preto")); 
            }
        }        
    }

    
    public void carregarPosicao(int linhaInt, char coluna){ // posição vazia
        int colunaInt = (int) coluna - 97;
        this.posicoes[linhaInt][colunaInt] = new Posicao(linhaInt, coluna,false); // criação de uma posição para conhecimento do jogo/tabuleiro.
    }
    
    public void desenhoTab() // desenho do momento atual do tabuleiro
     {
        System.out.println( "   a    b    c     d    e    f    g    h  ");    
        for (int i = 7; i >= 0; --i)
        {
            System.out.print(i+1 + " ");
            for (int j = 0; j <=7; j++)
            {
                if(posicoes[i][j].getCor().equals("branco")){System.out.print("00");}
                if(posicoes[i][j].getCor().equals("preto")){System.out.print("11");}
                if (posicoes[i][j].getPeca() == null)
                {
                    System.out.print("   ");
                }
                else
                {
                    System.out.print( posicoes[i][j].getPeca().desenho() + " ");
                }
            }
            System.out.println(" " + (1+i));
        }
        System.out.println("   a    b    c     d    e    f    g    h  ");  
    }
      
    public boolean movimenta(int linhaOrigem, char colunaOrigem, int linhaMovimento, char colunaMovimento, boolean movimenta)
    {   
        int auxColunaOrigem = (int) colunaOrigem - 'a' ; // conversão da coluna (Char) para um inteiro para sua devida manipulação 
        int auxColunaMovimento = (int) colunaMovimento - 'a'; // conversão da coluna (Char) para um inteiro para sua devida manipulação
        
        if(checaPosicao(linhaOrigem,auxColunaOrigem) && checaPosicao(linhaMovimento,auxColunaMovimento)) // verifica se as posições passadas existem
        {
            int diffLinha = linhaMovimento - linhaOrigem;
            int diffColuna = auxColunaMovimento - auxColunaOrigem;
            Posicao origem, destino; // referencias de posições criadas para auxiliar na movimentação
            origem = posicoes[linhaOrigem][auxColunaOrigem];
            destino = posicoes[linhaMovimento][auxColunaMovimento];

                if (destino.isOcupada()) // se o local de destino da peça tiver um peça ocupando a posição da mesma cor o movimento não é possível
                {
                    if (destino.getPeca().getCor() == origem.getPeca().getCor())
                        return false;
                }
                
                // verificação para os peões
                if (origem.getPeca().desenho().equals("P+") || origem.getPeca().desenho().equals("P-"))
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {

                        // movimento diagonal
                        if (Math.abs(diffLinha) == Math.abs(diffColuna))
                        {
                            if(destino.isOcupada()) // se o destino esta ocupado e as cores são diferentes, então é possivel a movimentação
                            {
                                if (movimenta){moverPeca(origem,destino);}
                                return true;
                            }
                            else // caso ele tente se movimentar diagonalmente e não haja peças nesse lugar, deve ser retornado false
                            {
                                return false;
                            }
                        }                        
                        else if (diffColuna == 0 && !destino.isOcupada())
                        {
                            if (movimenta){moverPeca(origem,destino);}
                            return true;
                        }
                    }
                }
                
                if(origem.getPeca().desenho().equals("C+") || origem.getPeca().desenho().equals("C-")) // o cavalo tem um tratamento específico, ele pode pular as peças do tabuleiro.
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {
                        if (movimenta){moverPeca(origem,destino);}
                        return  true;
                    }
                    else
                    {
                        return false;
                    }
                }
                
                if(origem.getPeca().desenho().equals("R+") || origem.getPeca().desenho().equals("R-")) // o rei se move em 1 de diferença, então precisamos apenas verificar se seu movimento é possível
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {
                        if (movimenta){moverPeca(origem,destino);}
                        return true;
                    }    
                }
                
                
                if(origem.getPeca().desenho().equals("T+") || origem.getPeca().desenho().equals("T-")) // movimento para uma torre
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {
                        if (diffLinha == 0) // caso se move em colunas
                        {
                            if(!this.moveEmColunas(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento))// verifica se há alguma peça na frente do seu destino
                            {
                                return false;
                            }    
                        }
                        if (diffColuna == 0) // caso se mova em linhas 
                        {
                            if(!this.moveEmLinhas(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento)) // verifica se há alguma peça na frente do seu destino
                            {
                                return false;
                            }                             
                        }                            
                        if (movimenta){moverPeca(origem,destino);}
                        return true;    
                    }
                }
               
                if(origem.getPeca().desenho().equals("B+") || origem.getPeca().desenho().equals("B-")) // movimento para uma torre
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {
                        if(!this.moveEmDiagonal(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento)) // verifica se há alguma peça na frente do seu destino
                        {
                            return false;
                        }                             
                        if (movimenta){moverPeca(origem,destino);}
                        return true;    
                    }
                }
                if(origem.getPeca().desenho().equals("RA+") || origem.getPeca().desenho().equals("RA-")) // rainha
                {
                    if(origem.getPeca().checaMovimento(linhaOrigem, colunaOrigem, linhaMovimento, colunaMovimento))
                    {
                        if (Math.abs(diffLinha) == Math.abs(diffColuna)) // pode se mover em diagonal 
                        {
                            if(!this.moveEmDiagonal(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento)) // checagem para ver se há alguem na frente
                            {
                                return false;
                            }                             
                        }
                        if (diffLinha == 0) // pode se mover em em colunas
                        {
                            if(!this.moveEmColunas(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento))// checagem para ver se há alguem na frente
                            {
                                return false;
                            }    
                        }
                        if (diffColuna == 0) // pode se mover em linhas
                        {
                            if(!this.moveEmLinhas(diffLinha, diffColuna, posicoes, linhaOrigem, linhaMovimento, auxColunaOrigem, auxColunaMovimento))// checagem para ver se há alguem na frente
                            {
                                return false;
                            }                             
                        }                            
                        if (movimenta){moverPeca(origem,destino);}
                        return true;    
                    }                        
                        
                    }         
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
        return false;
    }
    
    private boolean checaPosicao(int linha, int coluna) // recebe dois inteiro e verifica se eles respeitam os limites do tabuleiro
    {
        if ( linha < 0 || linha > 7 || coluna < 0 || coluna > 7) // verificação dos limites do tabuleiro
        {
            return false;
        }
        
        return true;
    }
    
    private boolean moveEmLinhas(int diffLinha, int diffColuna, Posicao posicoes[][], int linhaOrigem, int linhaMovimento, int auxColunaOrigem, int auxColunaMovimento) // verifica se é possivel se mover em linhas, caso haja alguma peça na frente do caminho entre origem-destino deve se retornar falso
    {
        if (diffLinha < 0 && diffColuna == 0) // movimento em linha negativa
        {
            for (int i = linhaOrigem  - 1; i > linhaMovimento; i--)
            {
                if(posicoes[i][auxColunaOrigem].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
            }
            return true;
        }
        if (diffLinha > 0 && diffColuna == 0) // movimento em linha positiva
        {
            for (int i = linhaOrigem  + 1; i < linhaMovimento; i++)
            {
                if(posicoes[i][auxColunaOrigem].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
            }
            return true;
        }
    return false;
    }    
    
    private boolean moveEmColunas(int diffLinha, int diffColuna, Posicao posicoes[][], int linhaOrigem, int linhaMovimento, int auxColunaOrigem, int auxColunaMovimento)// verifica se é possivel se mover em colunas, caso haja alguma peça na frente do caminho entre origem-destino deve se retornar falso
    {
        if (diffColuna < 0 && diffLinha == 0) // movimento em coluna negativa
        {
            for (int j = auxColunaOrigem  - 1; j > auxColunaMovimento; j--) 
            {
               if(posicoes[linhaOrigem][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
               {
                    return false;
               }
            }
            return true;
        }
        if (diffColuna > 0 && diffLinha == 0) // movimento em coluna positiva 
        {
            for (int j = auxColunaOrigem  + 1; j < auxColunaMovimento; j++)
            {
                if(posicoes[linhaOrigem][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
            }
            return true;
        }
    return false;
    }
    
    private boolean moveEmDiagonal(int diffLinha, int diffColuna, Posicao posicoes[][], int linhaOrigem, int linhaMovimento, int auxColunaOrigem, int auxColunaMovimento)// verifica se é possivel se mover em diagonais, caso haja alguma peça na frente do caminho entre origem-destino deve se retornar falso
    {
        if (diffLinha < 0 && diffColuna < 0) // movimento em linhas negativas e colunas negativas
        {
            int j = auxColunaOrigem - 1;
            for (int i = linhaOrigem - 1; i > linhaMovimento; i--)
            {
                if(posicoes[i][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
                j--;
            }
        return true;
        }
        if (diffLinha < 0 && diffColuna > 0)// movimento em linhas negativas e colunas positivas
        {
            int j = auxColunaOrigem + 1;
            for (int i = linhaOrigem - 1; i > linhaMovimento; i--)
            {
                if(posicoes[i][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
                j++;
            }
        return true;    
        }
        if (diffLinha > 0 && diffColuna > 0)// movimento em linhas positivas e colunas positivas
        {
            int j = auxColunaOrigem + 1;
            for (int i = linhaOrigem + 1 ; i < linhaMovimento; i++)
            {
                if(posicoes[i][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
                 j++;                                
            }
        return true;    
        }
        if (diffLinha > 0 && diffColuna < 0)// movimento em linhas positivas e colunas negativas
        {
            int j = auxColunaOrigem - 1;
            for (int i = linhaOrigem + 1; i < linhaMovimento; i++)
            {
                if(posicoes[i][j].isOcupada())  // se há algum elemento no caminho não é possivel realizar o roque
                {
                    return false;
                }
                j--;                                
            }
        return true;    
        }
    return false;
    }
    
    private void moverPeca(Posicao origem, Posicao destino){ // função que realiz a troca de posiçoes
        if (destino.isOcupada()) // caso o destino esteja ocupado a peça que ocupava o destino deve ser setada como falsa
        {
            destino.getPeca().setStatus(false);
        }
        destino.setPeca(origem.getPeca()); // a peça nova no destino é a que estava na origem
        origem.setPeca(null); // a origem agora nao possui peça
        destino.setOcupada(true); // a posição de destino está ocupada após a movimentação
        origem.setOcupada(false); // a posição de origem está desocupada após a movimentação
    }
    
     public boolean verificaXeque(String c){ // recebe uma cor que deve ser verifica se o rei dessa cor está em xeque
        Posicao posRei = acharRei(c);            
        for (int i = 7; i >=0 ; i--)
        {
            for (int j = 0; j <= 7; j++)
            {
                if (posicoes[i][j].isOcupada())
                {
                    if(movimenta(posicoes[i][j].getLinha(), posicoes[i][j].getColuna(), posRei.getLinha(), posRei.getColuna(),false)) // se alguma peça consegue se mover até o rei, o xeque é verdadeiro
                    {
                         return true;
                    }                  
                }
            }
        }
        return false;
     }
     
     public boolean verificaXequeMate(String c) // recebe uma cor que deve ser verificada se o rei dessa cor está no jogo
     {
        Posicao posRei = acharRei(c); 
        if (posRei == null) // se não é achado o rei desse cor, o xeque-mate é verdadeiro
        {
            return true;
        }
        return false;
     }
     
     private Posicao acharRei(String c) // receber uma cor para auxiliar na procura do rei da cor passada.
     {
       for (int i = 7; i >=0; i--)
       {
            for (int j = 0; j <= 7; j++)
            {
                if (posicoes[i][j].isOcupada())
                {
                    if (posicoes[i][j].getPeca().desenho().equals("R+") || posicoes[i][j].getPeca().desenho().equals("R-"))
                    {
                        if (posicoes[i][j].getPeca().getCor() == c) // caso a peça seja um rei e a cor da peça seja igual a cor de parâmetro, este é o rei.
                        return posicoes[i][j];
                    }                    
                }
            }
       }    
      return null; 
     }
}

