package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.CountriesDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Countries} and its DTO {@link CountriesDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CountriesMapper extends EntityMapper<CountriesDTO, Countries> {


    @Mapping(target = "users", ignore = true)
    @Mapping(target = "removeUsers", ignore = true)
    Countries toEntity(CountriesDTO countriesDTO);

    default Countries fromId(Long id) {
        if (id == null) {
            return null;
        }
        Countries countries = new Countries();
        countries.setId(id);
        return countries;
    }
}
