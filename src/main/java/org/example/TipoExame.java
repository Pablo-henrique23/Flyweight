package org.example;

import java.util.Objects;

public final class TipoExame {
    private final String codigo;
    private final String descricao;
    private final String preparo;

    TipoExame(String codigo, String descricao, String preparo) {
        this.codigo = Objects.requireNonNull(codigo);
        this.descricao = Objects.requireNonNull(descricao);
        this.preparo = Objects.requireNonNull(preparo);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getPreparo() {
        return preparo;
    }
}
