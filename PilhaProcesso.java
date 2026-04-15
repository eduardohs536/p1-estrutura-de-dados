public class PilhaProcesso {

    private VetorDinamico vetor;

    public PilhaProcesso() {
        this.vetor = new VetorDinamico();
    }

    public void push(Processo p) {
        vetor.adicionar(p);
    }

    public Processo pop() {
        if (vetor.getTamanho() == 0) {
            throw new PilhaVaziaException("Pilha vazia");
        }

        return vetor.removeUltimo();
    }

    public Processo peek() {
        if (vetor.getTamanho() == 0) {
            throw new PilhaVaziaException("Pilha vazia");
        }

        return vetor.buscarPosicao(vetor.getTamanho() - 1);
    }

    public void imprimir() {
        for (int i = vetor.getTamanho() - 1; i >= 0; i--) {
            System.out.println(vetor.buscarPosicao(i));
        }
    }

    public int getTamanho() {
        return vetor.getTamanho();
    }
}
