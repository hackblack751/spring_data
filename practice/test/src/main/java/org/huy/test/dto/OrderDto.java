package org.huy.test.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.huy.test.entity.Order;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {

    private Integer orderId;
    private String description;
    private LocalDateTime createdAt;
    private String status;

    public OrderDto(Order entity) {
        this.orderId = entity.getOrderId();
        this.description = entity.getDescription();
        this.createdAt = entity.getCreatedAt();
        this.status = entity.getStatus().getStatusName();
    }
}
