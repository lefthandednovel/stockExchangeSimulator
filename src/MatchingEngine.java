import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MatchingEngine {

    private ArrayList<Trade> trades = new ArrayList<>();
    private Long counter = 0L;

    public void match(OrderBook orderBook) {

        while (orderBook.getBestBuyOrder() != null && orderBook.getBestSellOrder() != null) {
            Order bestSellOrder = orderBook.getBestSellOrder();
            Order bestBuyOrder = orderBook.getBestBuyOrder();
            if (bestSellOrder.getPrice().compareTo(bestBuyOrder.getPrice()) <= 0) {
                Order sellOrder = orderBook.pollBestSellOrder();
                Order buyOrder = orderBook.pollBestBuyOrder();
                BigDecimal tradeQuantity = sellOrder.getRemainingQuantity()
                        .min(buyOrder.getRemainingQuantity());
                BigDecimal tradePrice = calcTradePrice(sellOrder, buyOrder);
                Trade trade = new Trade(counter, orderBook.getTicker(), tradePrice,
                        tradeQuantity, buyOrder.getId(), sellOrder.getId(), LocalDateTime.now());
                trades.add(trade);
                counter++;
                sellOrder.addFilledQuantity(tradeQuantity);
                buyOrder.addFilledQuantity(tradeQuantity);
                if (sellOrder.getRemainingQuantity().compareTo(BigDecimal.ZERO)!=0) {
                    orderBook.addOrder(sellOrder);
                }
                if (buyOrder.getRemainingQuantity().compareTo(BigDecimal.ZERO)!=0) {
                    orderBook.addOrder(buyOrder);
                }

            }
            else {break;}

        }

    }

    public BigDecimal calcTradePrice(Order sellOrder, Order buyOrder) {
        if (sellOrder.getDateTime().isBefore(buyOrder.getDateTime())) {
            return sellOrder.getPrice();
        }
        else {
            return buyOrder.getPrice();
        }
    }

    public ArrayList<Trade> getTrades() {
        return trades;
    }
}
