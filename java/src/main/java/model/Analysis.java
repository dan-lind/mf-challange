package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by danlin on 2016-06-26.
 */
public class Analysis {

    public Analysis(BigDecimal buyPrice, LocalDate buyDate, BigDecimal sellPrice, LocalDate sellDate) {
        this.sellPrice = sellPrice;
        this.buyPrice = buyPrice;
        this.sellDate = sellDate;
        this.buyDate = buyDate;
    }

    private final LocalDate buyDate;
    private final LocalDate sellDate;
    private final BigDecimal buyPrice;
    private final BigDecimal sellPrice;

    public LocalDate getBuyDate() {
        return buyDate;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }
}