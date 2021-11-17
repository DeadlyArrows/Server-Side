package com.hackdead.wheelmanager.controller;

import com.hackdead.wheelmanager.core.entities.Brand;
import com.hackdead.wheelmanager.core.service.IBrandService;
import com.hackdead.wheelmanager.maps.mapper.BrandMapper;
import com.hackdead.wheelmanager.maps.request.BrandRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/api/brands")
@Api(tags = "Brand", value = "Service Web RESTful of brands")
public class BrandController {
    @Autowired
    private IBrandService brandService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List Brands", notes = "Method to list all brands")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Brands found"),
            @ApiResponse(code = 404, message = "Brands not found")
    })
    public ResponseEntity<List<Brand>> findAll() {
        try {
            List<Brand> brands = brandService.getAll();
            if (!brands.isEmpty())
                return new ResponseEntity<>(brands, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Brand by Id", notes = "Method to find an brand by Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Brand found"),
            @ApiResponse(code = 404, message = "Brand not found")
    })
    public ResponseEntity<Brand> findById(@PathVariable("id") Long id) {
        try {
            Optional<Brand> brand = brandService.getById(id);
            if (!brand.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(brand.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/searchByBrandName/{brandName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Brand by name", notes = "Method to find Brand by name")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Brands found"),
            @ApiResponse(code = 404, message = "Brands not found")
    })
    public ResponseEntity<List<Brand>> findByBrandName(@PathVariable("brandName") String brandName) {
        try {
            List<Brand> brands = brandService.findByBrandName(brandName);
            if (!brands.isEmpty())
                return new ResponseEntity<>(brands, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registration of Brands", notes = "Method to register Brands in the BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Brand found"),
            @ApiResponse(code = 404, message = "Brand not found")
    })
    public ResponseEntity<Brand> insertBrand(@Valid @RequestBody BrandRequest brandRequest) {
        try {
            Brand brandNew = brandService.save(BrandMapper.toBrand(brandRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(brandNew);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Brands data", notes = "Method to update Brands")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Brand updated"),
            @ApiResponse(code = 404, message = "Brand not updated")
    })
    public ResponseEntity<Brand> updateBrand(
            @PathVariable("id") Long id, @Valid @RequestBody BrandRequest brandRequest) {
        try {
            Optional<Brand> brandUp = brandService.getById(id);
            if (!brandUp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Brand brandUpdate = BrandMapper.toBrand(brandRequest);
            brandUpdate.setId(id);
            brandService.save(brandUpdate);
            return new ResponseEntity<>(brandUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Brand", notes = "Method to delete Brand")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Brand deleted"),
            @ApiResponse(code = 404, message = "Brand not deleted")
    })
    public ResponseEntity<Brand> deleteBrand(@PathVariable("id") Long id) {
        try {
            Optional<Brand> brandDelete = brandService.getById(id);
            if (!brandDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            brandService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
