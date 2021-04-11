package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {


    @Test
    void testTransacao() {
        Transacao a = new Transacao(007, 50);
        Transacao b = new Transacao(-44, 32);

        assertEquals(50.0, a.getValor());
        Exception exception = assertThrows(RuntimeException.class, () ->
                b.getId());
        assertEquals("tente um id positivo", exception.getMessage());
        assertEquals(32.0, b.getValor());
    }
}
