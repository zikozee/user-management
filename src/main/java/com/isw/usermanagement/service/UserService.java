package com.isw.usermanagement.service;

import com.isw.usermanagement.dto.UserDto;
import com.isw.usermanagement.model.User;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */

public interface UserService {

    Object saveUser(User user);

    User editUser(User user);

    User fetchByFirstName(String firstname);

    List<UserDto> fetchAllUsers();

}
