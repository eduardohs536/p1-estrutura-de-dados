public class CentralAtendimento {

    private PilhaPrioridade pendentes;
    private PilhaProcesso historico;

    public CentralAtendimento() {
        this.pendentes = new PilhaPrioridade();
        this.historico = new PilhaProcesso();
    }

    public void abrirProcesso(Processo p) {
        pendentes.push(p);

        while (historico.getTamanho() > 0) {
            historico.pop();
        }
    }

    public void atenderProximo() {
        Processo p = pendentes.pop();
        historico.push(p);
    }

    public void desfazerUltimoAtendimento() {
        Processo p = historico.pop();
        pendentes.push(p);
    }

    public void listarPendentes() {
        pendentes.listar();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}