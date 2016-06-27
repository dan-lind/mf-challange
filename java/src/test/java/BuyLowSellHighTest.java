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
        Quote quote1 = new Quote();
        Quote quote2 = new Quote();
        Quote quote3 = new Quote();
        Quote quote4 = new Quote();
        Quote quote5 = new Quote();

        quote1.setClose(BigDecimal.valueOf(20));
        quote2.setClose(BigDecimal.valueOf(21));
        quote3.setClose(BigDecimal.valueOf(22));
        quote4.setClose(BigDecimal.valueOf(23));
        quote5.setClose(BigDecimal.valueOf(24));

        quote1.setQuoteDate(date);
        quote2.setQuoteDate(date.plusDays(1));
        quote3.setQuoteDate(date.plusDays(2));
        quote4.setQuoteDate(date.plusDays(3));
        quote5.setQuoteDate(date.plusDays(4));

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
        Quote quote6 = new Quote();
        Quote quote7 = new Quote();

        quote6.setClose(BigDecimal.valueOf(1));
        quote7.setClose(BigDecimal.valueOf(15));

        quote6.setQuoteDate(date.plusDays(5));
        quote7.setQuoteDate(date.plusDays(6));

        data.add(quote6);
        data.add(quote7);

        Analysis analysis = BuyLowSellHigh.findBuyAndSellClose(data);

        Assert.assertEquals(date.plusDays(5), analysis.getBuyDate());
        Assert.assertEquals(date.plusDays(6), analysis.getSellDate());
        Assert.assertEquals(BigDecimal.valueOf(1), analysis.getBuyPrice());
        Assert.assertEquals(BigDecimal.valueOf(15), analysis.getSellPrice());
    }

}
