package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.calebe.ticketmachine.core.TicketMachine;

public class TicketMachineTest {
    
    @Test
    public void inserir_zero_test(){
        int initial_value = 100;
        int inserted_value = 0;
        TicketMachine tm = new TicketMachine(initial_value);

        // Lidar com a Exception do método PapelMoeda 
        try{
            tm.inserir(inserted_value);
        }
        catch(Exception e){
            ;
        }

        int curr_value = tm.getSaldo();
        int expected = inserted_value;

        assertEquals(expected, curr_value);

    }

    @Test
    public void inserir_negativo_test(){
        int initial_value = 0;
        int inserted_value = -10;
        TicketMachine tm = new TicketMachine(initial_value);

        // Lidar com a Exception do método PapelMoeda 
        try{
            tm.inserir(inserted_value);
        }
        catch(Exception e){
            ;
        }

        int curr_value = tm.getSaldo();
        int expected = 0;

        assertEquals(expected, curr_value);

    }

}
