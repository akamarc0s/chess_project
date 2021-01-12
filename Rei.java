package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Rei extends Peca{

  public Rei(String c){
      super(c);
  }

  @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "R+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "R-";
            }
        }
        return representacao;
    }
    
  @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) 
    {
        int diffColuna = colunaDestino - colunaOrigem;
        int diffLinha = linhaDestino - linhaOrigem;

        if(this.isStatus()) // se o rei está no jogo 
        {
            if (Math.abs(diffLinha) == 1 || diffLinha == 0) // se o movimento da linha for 0,1,-1 e o da coluna também, o rei está se movimentando corretamente
            {
               if(Math.abs(diffColuna) == 1 || diffColuna == 0)
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
