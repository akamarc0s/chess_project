package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Cavalo extends Peca {
    
    public Cavalo(String c){
        super(c);
    }
    
  @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "C+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "C-";
            }
        }
        return representacao;       
    }

  @Override
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino)  
    {
        int diffColuna = colunaDestino - colunaOrigem;
        int diffLinha = linhaDestino - linhaOrigem;         
        
        if (isStatus())
        {
            if (Math.abs(diffColuna) == 2 && Math.abs(diffLinha) == 1) // cavalo pode se mover em 2-1 (2 linha 1 coluna) ou (1 linha 2 coluna)
            {
                return true;
            }
            else if (Math.abs(diffColuna) == 1 && Math.abs(diffLinha) == 2) 
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
