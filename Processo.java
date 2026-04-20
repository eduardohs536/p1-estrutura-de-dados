import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {

    private static int contador = 0;

    private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;

    public Processo(String solicitante, String tipoServico, int prioridade) {
        contador++;
        this.protocolo = contador;

        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.dataHora = LocalDateTime.now().format(fmt);
    }

    public int getProtocolo() {
        return protocolo;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        String[] prioridades = {"Baixa", "Normal", "Urgente"};
        String numero = String.format("%03d", protocolo);

        return "[#" + numero + "] " +
               solicitante + " | " +
               tipoServico + " | " +
               prioridades[prioridade - 1] + " | " +
               dataHora;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Processo outro = (Processo) obj;
        return this.protocolo == outro.protocolo;
    }
}