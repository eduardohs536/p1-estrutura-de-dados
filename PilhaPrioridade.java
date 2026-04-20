public class PilhaPrioridade {

    private PilhaProcesso prioridadeBaixa;
    private PilhaProcesso prioridadeNormal;
    private PilhaProcesso prioridadeUrgente;

    public PilhaPrioridade() {
        this.prioridadeBaixa = new PilhaProcesso();
        this.prioridadeNormal = new PilhaProcesso();
        this.prioridadeUrgente = new PilhaProcesso();
    }

    public void push(Processo p) {
        if (p.getPrioridade() == 3) {
            prioridadeUrgente.push(p);
        } else if (p.getPrioridade() == 2) {
            prioridadeNormal.push(p);
        } else {
            prioridadeBaixa.push(p);
        }
    }

    public Processo pop() {
        if (prioridadeUrgente.getTamanho() > 0) {
            return prioridadeUrgente.pop();
        } else if (prioridadeNormal.getTamanho() > 0) {
            return prioridadeNormal.pop();
        } else {
            return prioridadeBaixa.pop();
        }
    }

    public Processo peek() {
        if (prioridadeUrgente.getTamanho() > 0) {
            return prioridadeUrgente.peek();
        } else if (prioridadeNormal.getTamanho() > 0) {
            return prioridadeNormal.peek();
        } else {
            return prioridadeBaixa.peek();
        }
    }

    public int tamanho() {
        return prioridadeUrgente.getTamanho()
             + prioridadeNormal.getTamanho()
             + prioridadeBaixa.getTamanho();
    }

    public void listar() {
        System.out.println("URGENTE:");
        prioridadeUrgente.imprimir();

        System.out.println("NORMAL:");
        prioridadeNormal.imprimir();

        System.out.println("BAIXA:");
        prioridadeBaixa.imprimir();
    }
}