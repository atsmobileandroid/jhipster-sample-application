package com.mycompany.myapp.service;

import com.mycompany.myapp.service.dto.UserTypeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.mycompany.myapp.domain.UserType}.
 */
public interface UserTypeService {

    /**
     * Save a userType.
     *
     * @param userTypeDTO the entity to save.
     * @return the persisted entity.
     */
    UserTypeDTO save(UserTypeDTO userTypeDTO);

    /**
     * Get all the userTypes.
     *
     * @return the list of entities.
     */
    List<UserTypeDTO> findAll();


    /**
     * Get the "id" userType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<UserTypeDTO> findOne(Long id);

    /**
     * Delete the "id" userType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
