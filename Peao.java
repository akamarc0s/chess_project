package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Peao extends Peca{

    public Peao(String c){
        super(c);
  }

    @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "P+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "P-";
            }
        }
        return representacao;       
    }

    @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino)  
    {
        int diffColuna = colunaDestino - colunaOrigem;
        int diffLinha = linhaDestino - linhaOrigem;  
        
        if (isStatus() == true)
        {
            if (getCor().equals("branco")) // o peão branco necessita ser tratado diferentemente do peão preto
            {
                if (linhaOrigem == 7 && diffLinha >= 1) // o peão nao pode se mover para cima pois está no limite
                {
                    return false;
                }
                
                if ((linhaOrigem == 1) && (diffColuna == 0 && (diffLinha <= 2 && diffLinha > 0))) // se ele estiver na posição inicial, ele pode se mover 2 casas na Linha, nao coluna
                {
                    return true;
                }
                else if (diffLinha == 1 && diffColuna == 0) // se ele estiver fora da posição inicial, pode se mover 1 linha
                {
                    return true;
                }
                else if (diffLinha == 1 && Math.abs(diffColuna) == 1) // movimento caso o peao irá comer uma peça, precisa ser melhorado depois.
                {
                    return true;
                }
                else{
                    return false;
                }
            }
            else if (getCor().equals("preto")) // o peão preto necessita ser tratado diferentemente do peão branco
            {

                if ((linhaOrigem == 0 && diffLinha <= -1))  // o peão nao pode se mover para baixo pois está no limite
                {
                    return false;
                }
                
                if ((linhaOrigem == 6) && (diffColuna == 0 && (diffLinha >= -2 && diffLinha <= 0))) //  se ele estiver na posição inicial, ele pode se mover -2 casas (movimento inverso) na Linha, nao coluna
                {
                    return true;
                }
                else if (diffLinha == -1 && diffColuna == 0)// se ele estiver fora da posição inicial, pode se mover -1 linha
                {
                    return true;
                }
                else if(diffLinha == -1 && Math.abs(diffColuna) == 1)
                {
                    return true;
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
        }
        else
        {
            return false;
        }   
    }
}

