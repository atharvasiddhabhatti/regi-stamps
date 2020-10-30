package com.altimetrik.ee.demo.controller;

import com.altimetrik.ee.demo.dto.PropertyDTO;
import com.altimetrik.ee.demo.entity.Property;
import com.altimetrik.ee.demo.service.AdminService;
import com.altimetrik.ee.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Api(tags = "admin")

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private ModelMapper modelMapper;
    @PatchMapping("/property")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiOperation(value = "${AdminController.patchProperty}")
    @ApiResponses(value = {//
            @ApiResponse(code = 400, message = "Something went wrong"), //
            @ApiResponse(code = 403, message = "Access denied"), //
            @ApiResponse(code = 422, message = "Property is already Approved")})

    public ResponseEntity<?> patchProperty(@RequestBody PropertyDTO propertyDTO) {
        return ResponseEntity.ok().body(adminService.patchProperty(modelMapper.map(propertyDTO, Property.class)));
    }

}
