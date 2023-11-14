/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.0).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.iot.technicaltest.apirest.api;

import com.iot.technicaltest.apirest.api.ErrorResponseDTO;
import java.time.LocalDateTime;
import com.iot.technicaltest.apirest.api.PricesDTO;
import com.iot.technicaltest.apirest.api.PricesResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-14T22:43:57.372404400+01:00[Europe/Madrid]")

@Api(value = "prices", description = "the prices API")
public interface PricesApi {

    Logger log = LoggerFactory.getLogger(PricesApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Create new price list.", nickname = "createPrice", notes = "Create new price list.", response = PricesDTO.class, tags={ "prices", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PricesDTO.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
    @RequestMapping(value = "/prices",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<PricesDTO> createPrice(@ApiParam(value = "Price list content" ,required=true )  @Valid @RequestBody PricesDTO body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Returns price.", nickname = "getPrice", notes = "Returns price of a product between dates.", response = PricesResponseDTO.class, tags={ "prices", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = PricesResponseDTO.class),
        @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponseDTO.class),
        @ApiResponse(code = 404, message = "Not Found", response = ErrorResponseDTO.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorResponseDTO.class) })
    @RequestMapping(value = "/prices",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<PricesResponseDTO> getPrice(@ApiParam(value = "",required=true) @PathVariable("productId") Long productId,@ApiParam(value = "",required=true) @PathVariable("brandId") Long brandId,@ApiParam(value = "",required=true) @PathVariable("date") LocalDateTime date) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default PricesApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
