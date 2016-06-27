package model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by danlin on 2016-06-27.
 */
public class QuoteTest {

    @Test
    public void compareToTest() {
        List<Quote> quoteList = new ArrayList<>();

        LocalDate date = LocalDate.now();
        Quote quote1 = new Quote(date,"TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE,1L, 1L);
        Quote quote2 = new Quote(date.plusDays(3),"TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE,1L, 1L);
        Quote quote3 = new Quote(date.plusDays(4),"TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE,1L, 1L);
        Quote quote4 = new Quote(date.plusDays(1),"TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE,1L, 1L);
        Quote quote5 = new Quote(date.plusDays(2),"TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE,BigDecimal.ONE,BigDecimal.ONE,1L, 1L);

        quoteList.add(quote1);
        quoteList.add(quote2);
        quoteList.add(quote3);
        quoteList.add(quote4);
        quoteList.add(quote5);

        Assert.assertEquals(date,quoteList.get(0).getQuoteDate());
        Assert.assertEquals(date.plusDays(3),quoteList.get(1).getQuoteDate());
        Assert.assertEquals(date.plusDays(4),quoteList.get(2).getQuoteDate());
        Assert.assertEquals(date.plusDays(1),quoteList.get(3).getQuoteDate());
        Assert.assertEquals(date.plusDays(2),quoteList.get(4).getQuoteDate());

        Collections.sort(quoteList);

        Assert.assertEquals(date,quoteList.get(0).getQuoteDate());
        Assert.assertEquals(date.plusDays(1),quoteList.get(1).getQuoteDate());
        Assert.assertEquals(date.plusDays(2),quoteList.get(2).getQuoteDate());
        Assert.assertEquals(date.plusDays(3),quoteList.get(3).getQuoteDate());
        Assert.assertEquals(date.plusDays(4),quoteList.get(4).getQuoteDate());
    }
}
