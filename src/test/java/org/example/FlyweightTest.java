package org.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class FlyweightTest {

    @Test
    void deveReutilizarMesmoTipoDeExame() {
        FabricaTiposExame fabrica = new FabricaTiposExame();
        TipoExame primeiro = fabrica.obter(CategoriaExame.HEMOGRAMA);
        TipoExame segundo = fabrica.obter(CategoriaExame.HEMOGRAMA);
        assertSame(primeiro, segundo);
        assertEquals(1, fabrica.quantidadeTiposCriados());
    }

    @Test
    void deveManterTiposDiferentesSeparados() {
        FabricaTiposExame fabrica = new FabricaTiposExame();
        assertNotSame(fabrica.obter(CategoriaExame.HEMOGRAMA),
                      fabrica.obter(CategoriaExame.RAIO_X));
        assertEquals(2, fabrica.quantidadeTiposCriados());
    }

    @Test
    void solicitacoesDiferentesDevemCompartilharDadosDoExame() {
        FabricaTiposExame fabrica = new FabricaTiposExame();
        TipoExame tipo = fabrica.obter(CategoriaExame.ELETROCARDIOGRAMA);
        SolicitacaoExame ana = new SolicitacaoExame("Ana", LocalDate.of(2026, 11, 18), tipo);
        SolicitacaoExame bruno = new SolicitacaoExame("Bruno", LocalDate.of(2026, 11, 19), tipo);

        assertSame(ana.getTipo(), bruno.getTipo());
        assertEquals("Ana", ana.getPaciente());
        assertEquals("Bruno", bruno.getPaciente());
        assertTrue(ana.resumo().contains("Eletrocardiograma"));
    }

    @Test
    void deveCadastrarApenasTresTiposMesmoComVariasSolicitacoes() {
        FabricaTiposExame fabrica = new FabricaTiposExame();
        for (int i = 0; i < 50; i++) {
            fabrica.obter(CategoriaExame.HEMOGRAMA);
            fabrica.obter(CategoriaExame.RAIO_X);
            fabrica.obter(CategoriaExame.ELETROCARDIOGRAMA);
        }
        assertEquals(3, fabrica.quantidadeTiposCriados());
    }

    @Test
    void deveRejeitarCategoriaNula() {
        FabricaTiposExame fabrica = new FabricaTiposExame();
        assertThrows(NullPointerException.class, () -> fabrica.obter(null));
    }
}
