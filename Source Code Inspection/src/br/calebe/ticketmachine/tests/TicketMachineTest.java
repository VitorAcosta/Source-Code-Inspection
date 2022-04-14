package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;

public class TicketMachineTest {
    
    @Test(expected = PapelMoedaInvalidaException.class)
    public void falhaAoInserirZeroTest() throws PapelMoedaInvalidaException{
        int initial_value = 10;
        int inserted_value = 0;
        TicketMachine tm = new TicketMachine(initial_value);
        tm.inserir(inserted_value);
    }

    @Test
    public void inserirNotaValidaTest() throws PapelMoedaInvalidaException{
        int initial_value = 10;
        int[] inserted_value = {2, 5, 10, 20, 50, 100};
        TicketMachine tm = new TicketMachine(initial_value);

        for(int i = 0; i < inserted_value.length; i++){
            tm.inserir(inserted_value[i]);
        }

        int curr_value = tm.getSaldo();
        int expected = 187;

        assertEquals(expected, curr_value);

    }

    @Test
    public void saldoZeradoAposImpressaoBilheteTest() throws PapelMoedaInvalidaException, SaldoInsuficienteException{
        int initial_value = 10;
        int inserted_value = 10;
        TicketMachine tm = new TicketMachine(initial_value);
        tm.inserir(inserted_value);
        tm.imprimir();
        int expected = 0;
        assertEquals(expected, tm.getSaldo());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void falhaAoImpressaoBilheteSemSaldoTest() throws SaldoInsuficienteException{
        int initial_value = 10;
        TicketMachine tm = new TicketMachine(initial_value);
        tm.imprimir();
    }


}
