package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.ItemPricesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link ItemPrices} and its DTO {@link ItemPricesDTO}.
 */
@Mapper(componentModel = "spring", uses = {LevelsMapper.class})
public interface ItemPricesMapper extends EntityMapper<ItemPricesDTO, ItemPrices> {

    @Mapping(source = "levels.id", target = "levelsId")
    ItemPricesDTO toDto(ItemPrices itemPrices);

    @Mapping(source = "levelsId", target = "levels")
    ItemPrices toEntity(ItemPricesDTO itemPricesDTO);

    default ItemPrices fromId(Long id) {
        if (id == null) {
            return null;
        }
        ItemPrices itemPrices = new ItemPrices();
        itemPrices.setId(id);
        return itemPrices;
    }
}
