public class TesteVetorDinamico {
    public static void main(String[] args) {

        VetorDinamico vetor = new VetorDinamico();

        for (int i = 1; i <= 10; i++) {
            vetor.adicionar(new Processo("Pessoa " + i, "Servico", (i % 3) + 1));
            System.out.println("Capacidade: " + vetor.getCapacidade() + " | Tamanho: " + vetor.getTamanho());
        }

        System.out.println("\n=== Lista ===");
        vetor.listar();

        while (vetor.getTamanho() > 0) {
            vetor.removeUltimo();
            System.out.println("Capacidade: " + vetor.getCapacidade() + " | Tamanho: " + vetor.getTamanho());
        }
    }
}