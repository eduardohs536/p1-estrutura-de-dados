public class TesteVetorDinamico {

    public static void main(String[] args) {

        VetorDinamico vetor = new VetorDinamico();

        for (int i = 0; i < 8; i++) {

            Processo p = new Processo("Pessoa " + i, "Servico", 1, "10/04/2026 10:00");

            vetor.adicionar(p);

            System.out.println("Inseriu protocolo: " + p.getProtocolo());
            System.out.println("Tamanho: " + vetor.getTamanho());
            System.out.println("Capacidade: " + vetor.getCapacidade());
            System.out.println("-------------------------");
        }

        while (vetor.getTamanho() > 2) {

            vetor.remover(0);

            System.out.println("Removeu 1 elemento");
            System.out.println("Tamanho: " + vetor.getTamanho());
            System.out.println("Capacidade: " + vetor.getCapacidade());
            System.out.println("-------------------------");
        }
    }
}