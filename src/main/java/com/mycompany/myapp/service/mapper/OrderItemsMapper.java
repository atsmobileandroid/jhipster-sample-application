package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.OrderItemsDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link OrderItems} and its DTO {@link OrderItemsDTO}.
 */
@Mapper(componentModel = "spring", uses = {OrdersMapper.class})
public interface OrderItemsMapper extends EntityMapper<OrderItemsDTO, OrderItems> {

    @Mapping(source = "orders.id", target = "ordersId")
    OrderItemsDTO toDto(OrderItems orderItems);

    @Mapping(source = "ordersId", target = "orders")
    OrderItems toEntity(OrderItemsDTO orderItemsDTO);

    default OrderItems fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrderItems orderItems = new OrderItems();
        orderItems.setId(id);
        return orderItems;
    }
}
