package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by danlin on 2016-06-26.
 */
public class Quote implements Comparable<Quote> {

    @JsonCreator
    public Quote(@JsonProperty("quote_date") @JsonFormat(pattern = "yyyyMMdd") LocalDate quoteDate,
                 @JsonProperty("paper") String paper,
                 @JsonProperty("exch") String exch,
                 @JsonProperty("open") BigDecimal open,
                 @JsonProperty("high") BigDecimal high,
                 @JsonProperty("low") BigDecimal low,
                 @JsonProperty("close") BigDecimal close,
                 @JsonProperty("volume") long volume,
                 @JsonProperty("value") long value) {
        this.quoteDate = quoteDate;
        this.paper = paper;
        this.exch = exch;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.value = value;
    }

    private final LocalDate quoteDate;

    private final String paper;
    private final String exch;
    private final BigDecimal open;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal close;
    private final long volume;
    private final long value;

    public long getValue() {
        return value;
    }

    public long getVolume() {
        return volume;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public String getExch() {
        return exch;
    }

    public String getPaper() {
        return paper;
    }

    public LocalDate getQuoteDate() {
        return quoteDate;
    }

    public int compareTo(Quote o) {
        return this.getQuoteDate().compareTo(o.getQuoteDate());
    }
}
