package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Rainha extends Peca{

    public Rainha(String cor){
      super(cor);
    }  
  @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "RA+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "RA-";
            }
        }
        return representacao;       
    }

  @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) 
    {
        int diffColuna = colunaDestino - colunaOrigem;
        int diffLinha = linhaDestino - linhaOrigem;
        
        if(isStatus())
        {
            if (Math.abs(diffLinha) == Math.abs(diffColuna) || diffColuna == 0 || diffLinha == 0) // A rainha seria uma peça com as capacidades do do bispo + torre, pode se mover em linhas, colunas e diagonal
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
  
  
}
    

