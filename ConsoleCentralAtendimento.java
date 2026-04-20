import java.util.Scanner;

public class ConsoleCentralAtendimento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CentralAtendimento central = new CentralAtendimento();

        while (true) {

            System.out.println("\n1- Abrir processo");
            System.out.println("2- Atender próximo");
            System.out.println("3- Desfazer atendimento");
            System.out.println("4- Pendentes");
            System.out.println("5- Histórico");
            System.out.println("0- Sair");

            int op = sc.nextInt();
            sc.nextLine();

            if (op == 0) break;

            try {
                if (op == 1) {

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Servico: ");
                    String servico = sc.nextLine();

                    System.out.print("Prioridade (1-3): ");
                    int prio = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Data/Hora: ");
                    String data = sc.nextLine();

                    Processo p = new Processo(nome, servico, prio);
                    p.setDataHora(data);
                    central.abrirProcesso(p);
                }

                if (op == 2) {
                    central.atenderProximo();
                    System.out.println("Processo atendido com sucesso.");
                }

                if (op == 3) {
                    central.desfazerUltimoAtendimento();
                    System.out.println("Último atendimento desfeito.");
                }

                if (op == 4) {
                    central.listarPendentes();
                }

                if (op == 5) {
                    central.listarHistorico();
                }

            } catch (PilhaVaziaException e) {

                if (op == 2) {
                    System.out.println("Erro: não há processos para atender.");
                } else if (op == 3) {
                    System.out.println("Erro: não há atendimento para desfazer.");
                }
            }
        }

        sc.close();
    }
}