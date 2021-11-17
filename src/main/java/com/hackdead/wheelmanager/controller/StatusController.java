package com.hackdead.wheelmanager.controller;

import com.hackdead.wheelmanager.core.entities.Status;
import com.hackdead.wheelmanager.core.service.IStatusService;
import com.hackdead.wheelmanager.maps.mapper.StatusMapper;
import com.hackdead.wheelmanager.maps.request.StatusRequest;
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
@RequestMapping("/api/statuses")
@Api(tags = "Status", value = "Service Web RESTful of status")
public class StatusController {
    @Autowired
    private IStatusService statusService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List Statuses", notes = "Method to list all statuses")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status found"),
            @ApiResponse(code = 404, message = "Status not found")
    })
    public ResponseEntity<List<Status>> findAll() {
        try {
            List<Status> statuses = statusService.getAll();
            if (!statuses.isEmpty())
                return new ResponseEntity<>(statuses, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Status by Id", notes = "Method to find a Status by Id")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Status found"),
            @ApiResponse(code = 404, message = "Status not found")
    })
    public ResponseEntity<Status> findById(@PathVariable("id") Long id) {
        try {
            Optional<Status> status = statusService.getById(id);
            return status.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/searchByStatusName/{statusName}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search Status by name", notes = "Method to find Status by name")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Status found"),
            @ApiResponse(code = 404, message = "Status not found")
    })
    public ResponseEntity<List<Status>> findByStatusName(@PathVariable("statusName") String statusName) {
        try {
            List<Status> statuses = statusService.findByStatusName(statusName);
            if (!statuses.isEmpty())
                return new ResponseEntity<>(statuses, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registration of Statuses", notes = "Method to register Statuses in the BD")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Status found"),
            @ApiResponse(code = 404, message = "Status not found")
    })
    public ResponseEntity<Status> insertStatus(@Valid @RequestBody StatusRequest statusRequest) {
        try {
            Status statusNew = statusService.save(StatusMapper.toStatus(statusRequest));
            return ResponseEntity.status(HttpStatus.CREATED).body(statusNew);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Statuses data", notes = "Method to update Statuses")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status updated"),
            @ApiResponse(code = 404, message = "Status not updated")
    })
    public ResponseEntity<Status> updateStatus(
            @PathVariable("id") Long id, @Valid @RequestBody StatusRequest statusRequest) {
        try {
            Optional<Status> statusUp = statusService.getById(id);
            if (!statusUp.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            Status statusUpdate = StatusMapper.toStatus(statusRequest);
            statusUpdate.setId(id);
            statusService.save(statusUpdate);
            return new ResponseEntity<>(statusUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete Status", notes = "Method to delete Status")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Status deleted"),
            @ApiResponse(code = 404, message = "Status not deleted")
    })
    public ResponseEntity<Status> deleteStatus(@PathVariable("id") Long id) {
        try {
            Optional<Status> statusDelete = statusService.getById(id);
            if (!statusDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            statusService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
