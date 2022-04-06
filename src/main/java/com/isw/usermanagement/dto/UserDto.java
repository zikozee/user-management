package com.isw.usermanagement.dto;

import lombok.Data;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */

@Data
public class UserDto {

    private String applicationId;
    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private int height;
    private String maritalStatus;
}
