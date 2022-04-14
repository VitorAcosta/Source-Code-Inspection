package br.calebe.ticketmachine.tests;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.Troco;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;


public class TrocoTest {

  @Test
  public void retornoTrocoValidoTest(){
    int valor_troco = 187;
    PapelMoeda[] check_papel_moeda = {
      new PapelMoeda(100, 1),
      new PapelMoeda(50, 1),
      new PapelMoeda(20, 1),
      new PapelMoeda(10, 1),
      new PapelMoeda(5, 1),
      new PapelMoeda(2, 1),
    };

    Iterator<PapelMoeda> itr = new Troco(valor_troco).getIterator();

    int idx = 0;
    while(itr.hasNext()){
      PapelMoeda curr_value = itr.next();
      assertEquals(check_papel_moeda[idx++].getValor(), curr_value.getValor());
      assertEquals(check_papel_moeda[idx++].getQuantidade(), curr_value.getQuantidade());
    }

  }

  @Test
  public void retornoTrocoZeroTest(){
    int valor_troco = 0;
    Iterator<PapelMoeda> itr = new Troco(valor_troco).getIterator();

    while(itr.hasNext()){
      PapelMoeda curr_value = itr.next();
      assertEquals(0, curr_value.getQuantidade());
    }
  }

}
