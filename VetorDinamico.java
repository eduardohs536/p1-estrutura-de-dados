public class VetorDinamico {

    private Processo[] processo;
    private int tamanho;
    private int capacidadeInicial;

    public VetorDinamico() {
        this.capacidadeInicial = 4;
        this.processo = new Processo[4];
        this.tamanho = 0;
    }

    public VetorDinamico(int capacidade) {
        this.capacidadeInicial = capacidade;
        this.processo = new Processo[capacidade];
        this.tamanho = 0;
    }

    public int getCapacidade() {
        return processo.length;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void duplicarCapacidade() {
        if (tamanho == processo.length) {

            int novaCapacidade = processo.length * 2;
            Processo[] novoArray = new Processo[novaCapacidade];

            for (int i = 0; i < tamanho; i++) {
                novoArray[i] = processo[i];
            }

            processo = novoArray;
        }
    }

    public void adicionar(Processo p) {
        duplicarCapacidade();

        processo[tamanho++] = p;
    }

    private void reduzirCapacidade() {
        if (tamanho <= processo.length / 4 && processo.length > capacidadeInicial) {

            int novaCapacidade = processo.length / 2;

            if (novaCapacidade < capacidadeInicial) {
                novaCapacidade = capacidadeInicial;
            }

            Processo[] novoArray = new Processo[novaCapacidade];

            for (int i = 0; i < tamanho; i++) {
                novoArray[i] = processo[i];
            }

            processo = novoArray;
        }
    }

    public void remover(int posicao) {

        if (posicao < 0 || posicao >= tamanho) {
            return;
        }

        for (int i = posicao; i < tamanho - 1; i++) {
            processo[i] = processo[i + 1];
        }

        processo[--tamanho] = null;

        reduzirCapacidade();
    }

    public void listar() {
        for (int i = 0; i < tamanho; i++) {
            System.out.println((i + 1) + " - " + processo[i]);
        }
    }

    public int buscarProtocolo(int protocolo) {
        for (int i = 0; i < tamanho; i++) {
            if (processo[i].getProtocolo() == protocolo) {
                return i;
            }
        }
        return -1;
    }

    public Processo buscarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }
        return processo[posicao];
    }

    public Processo removeUltimo() {
        if (tamanho == 0) {
            return null;
        }

        Processo p = processo[tamanho - 1];
        remover(tamanho - 1);
        return p;
    }
}