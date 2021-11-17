package com.hackdead.wheelmanager.controller;

import com.hackdead.wheelmanager.core.entities.Offer;
import com.hackdead.wheelmanager.core.service.IOfferService;
import com.hackdead.wheelmanager.maps.mapper.OfferMapper;
import com.hackdead.wheelmanager.maps.request.OfferRequest;
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
@RequestMapping("/api/offers")
@Api(tags = "Offer", value = "Service Web RESTFul of offers")
public class OfferController {
    @Autowired
    private IOfferService offerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List Offers", notes = "Method to list all offers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Offers found"),
            @ApiResponse(code = 404, message = "Offers not found")
    })
    public ResponseEntity<List<Offer>> findAll() {
        try {
            List<Offer> offers = offerService.getAll();
            if (!offers.isEmpty())
                return new ResponseEntity<>(offers, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Offer by Id", notes = "Method to find an offer by Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Offer found"),
            @ApiResponse(code = 404, message = "Offer not found")
    })
    public ResponseEntity<Offer> findById(@PathVariable("id") Long id) {
        try {
            Optional<Offer> offer = offerService.getById(id);
            if (!offer.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(offer.get(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/searchByOfferName/{offerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Offer by name", notes = "Method to find Offer by name")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Offers found"),
            @ApiResponse(code = 404, message = "Offers not found")
    })
    public ResponseEntity<List<Offer>> findByOfferName(@PathVariable("offerName") String offerName) {
        try {
            List<Offer> offers = offerService.findByOfferName(offerName);
            if (!offers.isEmpty())
                return new ResponseEntity<>(offers, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registration of Offers", notes = "Method to register Offers in the BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Offer found"),
            @ApiResponse(code = 404, message = "Offer not found")
    })
    public ResponseEntity<Offer> insertOffer(@Valid @RequestBody OfferRequest offerRequest) {
        try {
            Offer offerNew = offerService.save(OfferMapper.toOffer(offerRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(offerNew);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Offers data", notes = "Method to update Offers")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Offer updated"),
            @ApiResponse(code = 404, message = "Offer not updated")
    })
    public ResponseEntity<Offer> updateOffer(
            @PathVariable("id") Long id, @Valid @RequestBody OfferRequest offerRequest) {
        try {
            Optional<Offer> offerUp = offerService.getById(id);
            if (!offerUp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Offer offerUpdate = OfferMapper.toOffer(offerRequest);
            offerUpdate.setId(id);
            offerService.save(offerUpdate);
            return new ResponseEntity<>(offerUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Offer", notes = "Method to delete Offer")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Offer deleted"),
            @ApiResponse(code = 404, message = "Offer not deleted")
    })
    public ResponseEntity<Offer> deleteOffer(@PathVariable("id") Long id) {
        try {
            Optional<Offer> offerDelete = offerService.getById(id);
            if (!offerDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            offerService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
