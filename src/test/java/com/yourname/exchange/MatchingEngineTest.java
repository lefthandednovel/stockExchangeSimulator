package com.yourname.exchange; // Не забудь указать свой пакет!

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class MatchingEngineTest {

    @Test
    public void testSimpleFullMatch() {
        OrderBook book = new OrderBook("AAPL");
        Order buyOrder = new Order(1L, 1L, "AAPL", OrderSide.BUY, OrderType.LIMIT,
                 "100", "10", LocalDateTime.now());
        Order sellOrder = new Order(2L, 2L, "AAPL", OrderSide.SELL, OrderType.LIMIT,
                "100", "10", LocalDateTime.now().plusSeconds(1));

        book.addOrder(buyOrder);
        book.addOrder(sellOrder);

        MatchingEngine engine = new MatchingEngine();

        engine.match(book);
        
        assertEquals(1, engine.getTrades().size(), "Должна быть совершена одна сделка");
        assertNull(book.getBestBuyOrder(), "Стакан покупок должен быть пуст");
        assertNull(book.getBestSellOrder(), "Стакан продаж должен быть пуст");
    }
}