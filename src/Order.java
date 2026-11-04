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
    private BigDecimal filledQuantity;
    private LocalDateTime dateTime;


    public Order(Long userId, Long id, String ticker,
                 OrderSide side, OrderType type, String price,
                 String quantity, LocalDateTime dateTime) {
        this.userId = userId;
        this.id = id;
        this.ticker = ticker;
        this.side = side;
        this.type = type;
        this.status = OrderStatus.OPEN;
        this.price = new BigDecimal(price);
        this.quantity = new BigDecimal(quantity);
        this.filledQuantity = BigDecimal.ZERO;
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

    public BigDecimal getFilledQuantity() {
        return filledQuantity;
    }

    public BigDecimal getRemainingQuantity() {
        return quantity.subtract(filledQuantity);
    }

    public void addFilledQuantity(BigDecimal amount) {
        this.filledQuantity.add(amount);
        if (this.filledQuantity.compareTo(this.quantity) == 0 ) {
            this.status = OrderStatus.FILLED;
        }
        else {
            this.status = OrderStatus.PARTIALLY_FILLED;
        }
    }
}
