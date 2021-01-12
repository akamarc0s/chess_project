package chess;
// Marcos Antonio de Santana Júnior
// 771040

public class Jogador {
    private String nome;
    private String cor;
    private Peca[] pecas = new Peca[16];
    
    Jogador(String c, Peca[] pecas) { 
        this.cor = c;
        setPecas(pecas);
    }

    private void setPecas(Peca[] p) { // recebe o vetor de peças do jogo e de acordo com a cor do jogador referencia 16 peças a esse jogador.
        if(this.cor == "branco")
        {
            System.arraycopy(p, 0, this.pecas, 0, 16);
        }
        if (this.cor == "preto")
        {
            System.arraycopy(p, 16, pecas, 0, 16);
        }           
    }
        
    public Peca[] getPecas() {
        return pecas;
    }
    
    public void setNome(String n){
        this.nome = n;
    }

    public String getNome() {
        return nome;
    }    

    public String getCor() {
        return cor;
    }

}
