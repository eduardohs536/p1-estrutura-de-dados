public class CentralAtendimento {

    private PilhaProcesso pendentes;
    private PilhaProcesso historico;

    public CentralAtendimento() {
        this.pendentes = new PilhaProcesso();
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
        pendentes.imprimir();
    }

    public void listarHistorico() {
        historico.imprimir();
    }
}