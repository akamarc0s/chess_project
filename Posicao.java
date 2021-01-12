package chess;

// Marcos Antonio de Santana Júnior
// 771040

public class Posicao {
    private int linha;
    private char coluna;
    private boolean ocupada;
    private String cor;
    private Peca peca;

    public Posicao(int l, char c, boolean o) {
        
        if ( l < 0 || l > 7 || c < 'a' || c > 'h') // verificação dos limites do tabuleiro
        {
            return;
        }
        
        setLinha(l);
        setColuna(c);
        setOcupada(o);
        setCor();
        this.setPeca(null); // ao receber uma posição deve setar a peça nesta posição como nula, futuramente, em outro método da classe tabuleiro irá setar as peças.
    }

    public int getLinha() {
        return linha;
    }

    public String getCor() {
        return cor;
    }

    private void setCor() // metódo para setar as cores das posições por meio do valor de sua coluna e de sua linha
    {
        int colunaInt = this.getColuna() - 97;
        
        if(this.linha % 2 == 0)
        {
            if(this.getColuna() % 2 == 0)
            {
                this.cor = "branco";
            }
            else
            {
                this.cor = "preto";    
            }
        }
        else if(this.linha % 2 == 1)
        {
            if (this.getColuna() % 2 == 0)
            {
               this.cor = "preto";
            }
            else
            {
                this.cor = "branco";
            }
        }
    }

    private void setLinha(int linha) {
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    private void setColuna(char coluna) {
        this.coluna = coluna;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    protected void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }
    
}
