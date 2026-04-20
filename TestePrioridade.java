public class TestePrioridade {
    public static void main(String[] args) {

        CentralAtendimento c = new CentralAtendimento();

        c.abrirProcesso(new Processo("A", "Servico", 1));
        c.abrirProcesso(new Processo("B", "Servico", 2));
        c.abrirProcesso(new Processo("C", "Servico", 3));

        System.out.println("=== Pendentes ===");
        c.listarPendentes();

        System.out.println("\n=== Ordem de Atendimento ===");
        c.atenderProximo();
        c.atenderProximo();
        c.atenderProximo();
    }
}