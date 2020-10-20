package com.altimetrik.ee.demo.controller;

import com.altimetrik.ee.demo.dto.PropertyResponseDTO;
import com.altimetrik.ee.demo.dto.ProperyDTO;
import com.altimetrik.ee.demo.dto.UserDataDTO;
import com.altimetrik.ee.demo.dto.UserResponseDTO;
import com.altimetrik.ee.demo.entity.Property;
import com.altimetrik.ee.demo.entity.User;
import com.altimetrik.ee.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
@Api(tags = "users")
public class UserController {

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @PostMapping("/signin")
  @ApiOperation(value = "${UserController.signIn}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 422, message = "Invalid username/password supplied")})
  public String signIn(//
                      @ApiParam("Username") @RequestParam String username, //
                      @ApiParam("Password") @RequestParam String password) {
    return userService.signIn(username, password);
  }

  @PostMapping("/signup")
  @ApiOperation(value = "${UserController.signUp}")
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 422, message = "Username is already in use")})
  public String signUp(@ApiParam("Signup User") @RequestBody UserDataDTO user) {
    return userService.signUp(modelMapper.map(user, User.class));
  }



  @PostMapping("/property")
  @ApiOperation(value = "${UserController.addProperty}")
  @ApiResponses(value = {//
          @ApiResponse(code = 400, message = "Something went wrong"), //
          @ApiResponse(code = 403, message = "Access denied"), //
          @ApiResponse(code = 422, message = "Username is already in use")})
  public Property addProperty(@RequestBody ProperyDTO properyDTO) {
    return userService.addProperty(modelMapper.map(properyDTO, Property.class));
  }


  @GetMapping(value = "/{username}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_BUYER') or hasRole('ROLE_SELLER')")
  @ApiOperation(value = "${UserController.search}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 404, message = "The user doesn't exist"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO search(@ApiParam("Username") @PathVariable String username) {
    return modelMapper.map(userService.search(username), UserResponseDTO.class);
  }

  @GetMapping(value = "/property/{id}")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_BUYER') or hasRole('ROLE_SELLER')")
  @ApiOperation(value = "${PropertyController.search}", response = PropertyResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
          @ApiResponse(code = 400, message = "Something went wrong"), //
          @ApiResponse(code = 403, message = "Access denied"), //
          @ApiResponse(code = 404, message = "The Property doesn't exist"), //
          @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public PropertyResponseDTO getProperty(@ApiParam("Property Details:-") @PathVariable Integer id) {
    return modelMapper.map(userService.findProperty(id), PropertyResponseDTO.class);
  }

  @GetMapping(value = "/me")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_BUYER') or hasRole('ROLE_SELLER')")
  @ApiOperation(value = "${UserController.me}", response = UserResponseDTO.class, authorizations = { @Authorization(value="apiKey") })
  @ApiResponses(value = {//
      @ApiResponse(code = 400, message = "Something went wrong"), //
      @ApiResponse(code = 403, message = "Access denied"), //
      @ApiResponse(code = 500, message = "Expired or invalid JWT token")})
  public UserResponseDTO me(HttpServletRequest req) {
    return modelMapper.map(userService.findCurrentUser(req), UserResponseDTO.class);
  }

  @GetMapping("/refresh")
  @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or  hasRole('ROLE_BUYER') or hasRole('ROLE_SELLER')")
  public String refresh(HttpServletRequest req) {
    return userService.refresh(req.getRemoteUser());
  }

}
