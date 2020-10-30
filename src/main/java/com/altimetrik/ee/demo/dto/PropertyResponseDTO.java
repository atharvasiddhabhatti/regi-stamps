package com.altimetrik.ee.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyResponseDTO {
    @ApiModelProperty(position = 0)
    Integer id;
    @ApiModelProperty(position = 1)
    String firstName;
    @ApiModelProperty(position = 2)
    String lastName;
    @ApiModelProperty(position = 3)
    String address;
    @ApiModelProperty(position = 4)
    String city;
    @ApiModelProperty(position = 5)
    String State;
    @ApiModelProperty(position = 6)
    int zip;
    @ApiModelProperty(position = 7)
    int regno;
    @ApiModelProperty(position = 8)
    int propertyno;
    @ApiModelProperty(position = 9)
    float area;
    @ApiModelProperty(position = 10)
    int surveyno;
    @ApiModelProperty(position = 11)
    String type;
    @ApiModelProperty(position = 12)
    String email;
    @ApiModelProperty(position = 13)
    String status;
    @ApiModelProperty(position = 14)
    String username;
}

