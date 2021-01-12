package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Bispo extends Peca {
    
    public Bispo(String c){
        super(c);
    }

    @Override
    public String desenho() { // metódo para verificar como a peça deve ser desenhada no tabuleiro
        String representacao = "";
        if (isStatus() == true){
            if (this.getCor().equals("branco")){ // + branco - preto
                representacao = "B+" ;
            }
            else if (this.getCor().equals("preto")){
                representacao = "B-";
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
            if (Math.abs(diffLinha) == Math.abs(diffColuna) && !(diffLinha == 0 || diffColuna == 0))
            { // o bispo se move na diagonal, logo, suas casas de linha e coluna se modificam igual, então, se o módulo deles é igual, o checaMovimento está correto
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
