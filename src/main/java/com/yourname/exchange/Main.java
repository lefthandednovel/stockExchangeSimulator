package com.yourname.exchange;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        Order order1 = new Order(1L, 1L, "APL", OrderSide.BUY,
                OrderType.MARKET,"100", "2", LocalDateTime.now());
        Order order2 = new Order(2L, 2L, "APL", OrderSide.BUY,
                OrderType.MARKET, "105", "2", LocalDateTime.now());
        Order order3 = new Order(1L, 3L, "APL", OrderSide.SELL, OrderType.MARKET,
                "80", "1", LocalDateTime.now());

        OrderBook orderBook = new OrderBook("APL");
        orderBook.addOrder(order1);
        orderBook.addOrder(order2);
        orderBook.addOrder(order3);

        MatchingEngine matchingEngine = new MatchingEngine();
        matchingEngine.match(orderBook);
        System.out.println(matchingEngine.getTrades());
        }}