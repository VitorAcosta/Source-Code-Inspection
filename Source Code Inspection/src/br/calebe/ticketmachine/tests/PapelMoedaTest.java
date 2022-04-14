package br.calebe.ticketmachine.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import br.calebe.ticketmachine.core.PapelMoeda;

public class PapelMoedaTest {
  
  @Test
  public void conferePapelMoedaValidoTest(){
    PapelMoeda p = new PapelMoeda(2, 10);
    assertEquals(2, p.getValor());
    assertEquals(10, p.getQuantidade());
  }

  @Test(expected = Exception.class)
  public void falhaPapelMoedaInexistenteTest(){
    PapelMoeda p = new PapelMoeda(-1, -10);
    assertEquals(-1, p.getValor());
    assertEquals(-10, p.getQuantidade());
  }

}
