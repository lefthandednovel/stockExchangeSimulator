import java.math.BigDecimal;

public class Stock {

    private String ticker;
    private BigDecimal curPrice;

    public Stock(String ticker, String curPrice) {
        this.ticker = ticker;
        this.curPrice = new BigDecimal(curPrice);
    }

}
