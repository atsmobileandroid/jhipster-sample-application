package com.mycompany.myapp.service.mapper;


import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.UserTypeDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link UserType} and its DTO {@link UserTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface UserTypeMapper extends EntityMapper<UserTypeDTO, UserType> {


    @Mapping(target = "users", ignore = true)
    @Mapping(target = "removeUsers", ignore = true)
    UserType toEntity(UserTypeDTO userTypeDTO);

    default UserType fromId(Long id) {
        if (id == null) {
            return null;
        }
        UserType userType = new UserType();
        userType.setId(id);
        return userType;
    }
}
