import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {

    private Long id;
    private Long userId;
    private String ticker;
    private OrderSide side;
    private OrderType type;
    private OrderStatus status;
    private BigDecimal price;
    private BigDecimal quantity;
    private LocalDateTime dateTime;


    public Order(Long userId, Long id, String ticker,
                 OrderSide side, OrderType type, OrderStatus status, BigDecimal price,
                 BigDecimal quantity, LocalDateTime dateTime) {
        this.userId = userId;
        this.id = id;
        this.ticker = ticker;
        this.side = side;
        this.type = type;
        this.status = status;
        this.price = price;
        this.quantity = quantity;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getTicker() {
        return ticker;
    }

    public OrderSide getSide() {
        return side;
    }

    public OrderType getType() {
        return type;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
