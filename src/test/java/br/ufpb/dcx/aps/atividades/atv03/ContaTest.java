package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {
    Correntista a;
    Banco b;
    Conta c;
    @BeforeEach
    void setUp(){
        a = new Correntista();
        b = new Banco();
        c = new Conta();
    }

    @Test
    void name() throws ContaException{
        c = new Conta(a,12,b);
        c.depositar(335.9);
        assertEquals(335.9, c.saldo());
        c.sacar(55.9);
        assertEquals(280.0, c.saldo());


    }
}
