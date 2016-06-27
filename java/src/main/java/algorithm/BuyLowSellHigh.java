package algorithm;

import model.Analysis;
import model.Quote;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

/**
 * Created by danlin on 2016-06-26.
 */
public class BuyLowSellHigh {

    public static Analysis findBuyAndSellClose(List<Quote> data) {
        Collections.sort(data);
        BigDecimal buyPrice = data.get(0).getClose();
        LocalDate buyDate = data.get(0).getQuoteDate();
        BigDecimal sellPrice = buyPrice;
        LocalDate sellDate = buyDate;
        BigDecimal maxDiff = BigDecimal.ZERO;

        for (Quote quote: data) {
            BigDecimal currentClose = quote.getClose();
            if (currentClose.compareTo(buyPrice) < 0) {
                buyPrice = currentClose;
                buyDate = quote.getQuoteDate();
                sellPrice = currentClose;
            }
            else if (currentClose.compareTo(sellPrice) > 0) {
                sellPrice = currentClose;
                sellDate = quote.getQuoteDate();
                maxDiff = sellPrice.subtract(buyPrice);
            }
        }

        return new Analysis(buyPrice, buyDate, sellPrice, sellDate);
    }
}
