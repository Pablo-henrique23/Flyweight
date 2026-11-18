package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class SolicitacaoExame {
    private final String paciente;
    private final LocalDate data;
    private final TipoExame tipo;

    public SolicitacaoExame(String paciente, LocalDate data, TipoExame tipo) {
        if (paciente == null || paciente.isBlank()) {
            throw new IllegalArgumentException("Paciente deve ser informado");
        }
        this.paciente = paciente;
        this.data = Objects.requireNonNull(data, "data nao pode ser nula");
        this.tipo = Objects.requireNonNull(tipo, "tipo nao pode ser nulo");
    }

    public TipoExame getTipo() {
        return tipo;
    }

    public String getPaciente() {
        return paciente;
    }

    public LocalDate getData() {
        return data;
    }

    public String resumo() {
        return paciente + " - " + tipo.getDescricao() + " (" + tipo.getCodigo() + ") - " + data;
    }
}
