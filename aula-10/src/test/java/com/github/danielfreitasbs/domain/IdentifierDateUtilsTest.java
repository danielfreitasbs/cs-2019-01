package com.github.danielfreitasbs.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.github.danielfreitas.domain.IdentifierDateUtils;

public class IdentifierDateUtilsTest {
  String[] argTeste1 = {"2010101", "1", "23450101", "1"};
  String[] argTeste2 = {"100000101", "", "23450101", "1"};
  String[] argTeste3 = {"20161301", "", "23450101", "1"};
  String[] argTeste4 = {"20160001", "", "23450101", "1"};
  String[] argTeste5 = {"20160931", "", "23450101", "1"};
  String[] argTeste6 = {"20160900", "", "23450101", "1"};
  String[] argTeste7 = {"", "0", "23450101", "1"};
  String[] argTeste8 = {"", "-1", "23450101", "1"};
  String[] argTeste9 = {"", "", "20191232", "1"};
  String[] argTeste10 = {"", "", "23450101", "-1"};
  String[] argTeste11 = {"", "", "23450101", "7"};
  String[] argTeste12 = {"20160928", "2016", "20160928", "2"};
  String[] argTeste13 = {"20160301", "2016", "20160228", "6"};
  String[] argTeste14 = {"20160331", "2018", "20160331", "3"};
  String[] argTeste15 = {"20160131", "2016", "20160331", "3"};
  String[] argTeste16 = {"20150131", "2016", "20160331", "5"};
  String[] argTeste17 = {"20160331", "2016", "20150131", "5"};
  String[] argTeste18 = {"2018", "20160331", "3"};
  String[] argTeste19 = {"a", "2018", "20160331", "3"};
  String[] argTeste20 = {"20160331", "2018", "20160331", "-3"};
  String[] argTeste21 = {"20160331", "2018", "20160331", "7"};
  String[] argTeste22 = {"20160331", "0", "20160331", "3"};
  String[] argTeste23 = {"20160331", "2018", "20160332", "3"};

  /*@Test
  void testSeBissexto() {
      assertTrue(IdentifierDateUtils.seBissexto(2015, 2015));
      assertTrue(IdentifierDateUtils.seBissexto(2019, 2015));
      assertFalse(IdentifierDateUtils.seBissexto(2018, 2015));
      assertTrue(IdentifierDateUtils.seBissexto(2000, 1996));
      assertFalse(IdentifierDateUtils.seBissexto(1700, 1692));
  }

  @Test
  void testUltimoDiaDoMes() {
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(1, 2015, 2015));
      assertEquals(29, IdentifierDateUtils.ultimoDiaDoMes(2, 2015, 2015));
      assertEquals(28, IdentifierDateUtils.ultimoDiaDoMes(2, 2015, 2014));
      assertEquals(29, IdentifierDateUtils.ultimoDiaDoMes(2, 1999, 1995));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(3, 2015, 2015));
      assertEquals(30, IdentifierDateUtils.ultimoDiaDoMes(4, 2015, 2015));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(5, 2015, 2015));
      assertEquals(30, IdentifierDateUtils.ultimoDiaDoMes(6, 2015, 2015));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(7, 2015, 2015));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(8, 2015, 2015));
      assertEquals(30, IdentifierDateUtils.ultimoDiaDoMes(9, 2015, 2015));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(10, 2015, 2015));
      assertEquals(30, IdentifierDateUtils.ultimoDiaDoMes(11, 2015, 2015));
      assertEquals(31, IdentifierDateUtils.ultimoDiaDoMes(12, 2015, 2015));
      assertEquals(0, IdentifierDateUtils.ultimoDiaDoMes(0, 2015, 2015));
  }

  @Test
  void testQualDataMaior() {
      assertEquals(0, IdentifierDateUtils.qualDataMaior("20180215", "20180215"));
      assertEquals(1, IdentifierDateUtils.qualDataMaior("20180215", "20180216"));
      assertEquals(-1, IdentifierDateUtils.qualDataMaior("20180215", "20180214"));
      assertEquals(1, IdentifierDateUtils.qualDataMaior("20180215", "20180315"));
      assertEquals(-1, IdentifierDateUtils.qualDataMaior("20180215", "20180114"));
      assertEquals(1, IdentifierDateUtils.qualDataMaior("20180215", "20190215"));
      assertEquals(-1, IdentifierDateUtils.qualDataMaior("20180215", "20170214"));
  }*/

  @Test
  void testDateDiscover() {
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste1));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste2));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste3));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste4));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste5));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste6));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste7));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste8));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste9));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste10));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste11));
      assertEquals(2, IdentifierDateUtils.dateDiscover(argTeste12));
      assertEquals(1, IdentifierDateUtils.dateDiscover(argTeste13));
      assertEquals(3, IdentifierDateUtils.dateDiscover(argTeste14));
      assertEquals(6, IdentifierDateUtils.dateDiscover(argTeste15));
      assertEquals(0, IdentifierDateUtils.dateDiscover(argTeste16));
      assertEquals(3, IdentifierDateUtils.dateDiscover(argTeste17));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste18));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste19));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste20));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste21));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste22));
      assertEquals(-1, IdentifierDateUtils.dateDiscover(argTeste23));
  }

 /* @Test
  void testAvancaERecuaData() {
      assertEquals(1, IdentifierDateUtils.avancaData("20190101", "20190102", 2018));
      assertEquals(0, IdentifierDateUtils.avancaData("20190101", "20190101", 2018));
      assertEquals(1, IdentifierDateUtils.recuaData("20190102", "20190101", 2018));
      assertEquals(0, IdentifierDateUtils.recuaData("20190101", "20190101", 2018));
  }*/
}
