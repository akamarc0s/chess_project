package chess;

abstract public class Peca {

  private boolean status;
  private final String cor;

    public Peca(String c) { // construtor "super" das peças, recebe sua cor e seta seu status como verdadeiro.
        this.setStatus(true);
        if (c.equals("branco") || c.equals("preto")){
            this.cor = c;
        }
        else{
            this.cor = null;
        }
    }
  
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
  
    public String getCor(){
        return this.cor;
    }
  
  abstract public String desenho(); // metódo abstrato do desenho das peças
  abstract public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino); // método abstrato da checagem de momviento das peças
  
}
