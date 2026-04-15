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
        duplicarCapacidade(); // chama direto
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

    public void remover(int indice) {

        if (indice < 0 || indice >= tamanho) {
            return;
        }

        for (int i = indice; i < tamanho - 1; i++) {
            processo[i] = processo[i + 1];
        }

        processo[--tamanho] = null;

        reduzirCapacidade(); // chama direto
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
}