import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Trade(Long id, String ticker, BigDecimal price, BigDecimal quantity,
                    Long buyOrderId, Long sellOrderId, LocalDateTime timestamp) {
}
