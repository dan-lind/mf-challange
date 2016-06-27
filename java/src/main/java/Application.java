import algorithm.BuyLowSellHigh;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Analysis;
import model.Puzzle;
import model.Quote;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by danlin on 2016-06-26.
 */
public class Application {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        Puzzle obj = mapper.readValue(new File(".." + File.separator + "buy-sell.json"), Puzzle.class);

        Analysis analysis = BuyLowSellHigh.findBuyAndSellClose(obj.getData());

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("EEE, d MMM yyyy", Locale.US);
        System.out.println("------- Finding best buy and sell at close -------");
        System.out.println("Buy at close price " + analysis.getBuyPrice() + " on " + formatter.format(analysis.getBuyDate()));
        System.out.println("Sell at close price " + analysis.getSellPrice() + " on " + formatter.format(analysis.getSellDate()));
        System.out.println("Profit: " + analysis.getSellPrice().subtract(analysis.getBuyPrice()) + " SEK per share");

    }
}
