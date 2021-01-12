package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Torre extends Peca{
    
    public Torre(String c){
        super(c);
  }

    @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "T+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "T-";
            }
        }
        return representacao;       
    }

    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) 
    {
        int diffColuna = colunaDestino - colunaOrigem;
        int diffLinha = linhaDestino - linhaOrigem;
        
        if(isStatus())
        {
            if (diffColuna == 0 && diffLinha == 0)
            { // a torre não se move ficando parado.
                return false;
            }
            
            if ((diffColuna == 0) || diffLinha == 0 )
            { // se a coluna ou a linha fica zerado, a torre está correta, visto que pode se mover livremante para um campo sem modificar o outro
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
  
  
  
}
