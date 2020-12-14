package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.CountriesService;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.service.dto.CountriesDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Countries}.
 */
@RestController
@RequestMapping("/api")
public class CountriesResource {

    private final Logger log = LoggerFactory.getLogger(CountriesResource.class);

    private static final String ENTITY_NAME = "jhipsterSampleApplicationCountries";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CountriesService countriesService;

    public CountriesResource(CountriesService countriesService) {
        this.countriesService = countriesService;
    }

    /**
     * {@code POST  /countries} : Create a new countries.
     *
     * @param countriesDTO the countriesDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new countriesDTO, or with status {@code 400 (Bad Request)} if the countries has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/countries")
    public ResponseEntity<CountriesDTO> createCountries(@RequestBody CountriesDTO countriesDTO) throws URISyntaxException {
        log.debug("REST request to save Countries : {}", countriesDTO);
        if (countriesDTO.getId() != null) {
            throw new BadRequestAlertException("A new countries cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CountriesDTO result = countriesService.save(countriesDTO);
        return ResponseEntity.created(new URI("/api/countries/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /countries} : Updates an existing countries.
     *
     * @param countriesDTO the countriesDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated countriesDTO,
     * or with status {@code 400 (Bad Request)} if the countriesDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the countriesDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/countries")
    public ResponseEntity<CountriesDTO> updateCountries(@RequestBody CountriesDTO countriesDTO) throws URISyntaxException {
        log.debug("REST request to update Countries : {}", countriesDTO);
        if (countriesDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CountriesDTO result = countriesService.save(countriesDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, countriesDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /countries} : get all the countries.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of countries in body.
     */
    @GetMapping("/countries")
    public List<CountriesDTO> getAllCountries() {
        log.debug("REST request to get all Countries");
        return countriesService.findAll();
    }

    /**
     * {@code GET  /countries/:id} : get the "id" countries.
     *
     * @param id the id of the countriesDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the countriesDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/countries/{id}")
    public ResponseEntity<CountriesDTO> getCountries(@PathVariable Long id) {
        log.debug("REST request to get Countries : {}", id);
        Optional<CountriesDTO> countriesDTO = countriesService.findOne(id);
        return ResponseUtil.wrapOrNotFound(countriesDTO);
    }

    /**
     * {@code DELETE  /countries/:id} : delete the "id" countries.
     *
     * @param id the id of the countriesDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/countries/{id}")
    public ResponseEntity<Void> deleteCountries(@PathVariable Long id) {
        log.debug("REST request to delete Countries : {}", id);
        countriesService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
