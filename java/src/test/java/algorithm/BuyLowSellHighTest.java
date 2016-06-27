package algorithm;

import algorithm.BuyLowSellHigh;
import model.Analysis;
import model.Quote;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danlin on 2016-06-26.
 */
public class BuyLowSellHighTest {

    List<Quote> data = new ArrayList<>();
    LocalDate date = LocalDate.now();

    @Before
    public void setUp() {
        Quote quote1 = new Quote(date, "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(20), 1L, 1L);
        Quote quote2 = new Quote(date.plusDays(1), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(21), 1L, 1L);;
        Quote quote3 = new Quote(date.plusDays(2), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(22), 1L, 1L);;
        Quote quote4 = new Quote(date.plusDays(3), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(23), 1L, 1L);;
        Quote quote5 = new Quote(date.plusDays(4), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(24), 1L, 1L);;

        data.add(quote1);
        data.add(quote2);
        data.add(quote3);
        data.add(quote4);
        data.add(quote5);
    }

    @Test
    public void findBuyAndSellCloseUpOnlyTest() {
        Analysis analysis = BuyLowSellHigh.findBuyAndSellClose(data);

        Assert.assertEquals(date, analysis.getBuyDate());
        Assert.assertEquals(date.plusDays(4), analysis.getSellDate());
        Assert.assertEquals(BigDecimal.valueOf(20), analysis.getBuyPrice());
        Assert.assertEquals(BigDecimal.valueOf(24), analysis.getSellPrice());
    }

    @Test
    public void findBuyAndSellCloseTestLate() {
        Quote quote6 = new Quote(date.plusDays(5), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(1), 1L, 1L);;
        Quote quote7 = new Quote(date.plusDays(6), "TestPaper", "TestExchange", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE, BigDecimal.valueOf(15), 1L, 1L);;

        data.add(quote6);
        data.add(quote7);

        Analysis analysis = BuyLowSellHigh.findBuyAndSellClose(data);

        Assert.assertEquals(date.plusDays(5), analysis.getBuyDate());
        Assert.assertEquals(date.plusDays(6), analysis.getSellDate());
        Assert.assertEquals(BigDecimal.valueOf(1), analysis.getBuyPrice());
        Assert.assertEquals(BigDecimal.valueOf(15), analysis.getSellPrice());
    }

}
