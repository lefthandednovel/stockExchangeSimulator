package com.yourname.exchange;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderBook {

    Comparator<Order> sellComparator = Comparator.comparing(Order::getPrice)
            .thenComparing(Order::getDateTime);
    Comparator<Order> buyComparator = Comparator.comparing(Order::getPrice, Comparator.reverseOrder())
            .thenComparing(Order::getDateTime);

    private String ticker;
    private PriorityQueue<Order> buyBook = new PriorityQueue<>(buyComparator);
    private PriorityQueue<Order> sellBook = new PriorityQueue<>(sellComparator);

    public OrderBook(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return this.ticker;
    }


    public void addOrder(Order order) {
        if (order.getSide().equals(OrderSide.BUY)) {
            buyBook.add(order);
        }
        else {
            sellBook.add(order);
        }
    }

    public Order getBestSellOrder() {
        return sellBook.peek();
    }

    public Order getBestBuyOrder() {
        return buyBook.peek();
    }

    public Order pollBestSellOrder() {
        return sellBook.poll();
    }

    public Order pollBestBuyOrder() {
        return buyBook.poll();
    }





}
