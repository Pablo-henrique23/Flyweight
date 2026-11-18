package org.example;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class FabricaTiposExame {
    private final Map<CategoriaExame, TipoExame> cache = new EnumMap<>(CategoriaExame.class);

    public TipoExame obter(CategoriaExame categoria) {
        Objects.requireNonNull(categoria, "categoria nao pode ser nula");
        return cache.computeIfAbsent(categoria, this::criarTipo);
    }

    public int quantidadeTiposCriados() {
        return cache.size();
    }

    private TipoExame criarTipo(CategoriaExame categoria) {
        return switch (categoria) {
            case HEMOGRAMA -> new TipoExame("HEM", "Hemograma completo", "Sem preparo especial");
            case RAIO_X -> new TipoExame("RX", "Raio-X", "Retirar objetos metalicos");
            case ELETROCARDIOGRAMA -> new TipoExame("ECG", "Eletrocardiograma", "Evitar cremes na pele");
        };
    }
}
