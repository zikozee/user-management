package com.isw.usermanagement.service;

import com.isw.usermanagement.dto.UserDto;
import com.isw.usermanagement.model.User;
import com.isw.usermanagement.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Ezekiel Eromosei
 * @created : 06 April 2022
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public Object saveUser(User user) {
        Optional<User> optionalUser = userRepository.findByApplicationId(user.getApplicationId());
        if(optionalUser.isPresent()) return "Application id " + user.getApplicationId() + " already exists";

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public User editUser(User user) {
        if(user.getId() <= 0) throw new IllegalArgumentException("id is required");
        Optional<User> optionalUser = userRepository.findById(user.getId());
        User user2 = optionalUser.orElseThrow(() -> new IllegalArgumentException("no user with id: " + user.getId()));
        return userRepository.save(user2);
    }

    @Override
    public User fetchByFirstName(String firstname) {
        Optional<User> optionalUser = userRepository.findByFirstNameAndDeleted(firstname, false);
        return optionalUser
                .orElse(null);
    }

    @Override
    public List<UserDto> fetchAllUsers() {
//        List<User> users = userRepository.findAllByDeleted(false);
//        List<UserDto> userDtos = new ArrayList<>();
//        for (int i = 0; i < users.size(); i++) {
//            userDtos.add(buildUserDto(users.get(i)));
//        }
//        return userDtos;

        return userRepository.findAllByDeleted(false)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }


    private static  UserDto buildUserDto(User user){
        UserDto userDto = new UserDto();

        userDto.setApplicationId(user.getApplicationId());
        userDto.setAddress(user.getAddress());
        userDto.setAge(user.getAge());
        userDto.setMaritalStatus(user.getMaritalStatus());
        userDto.setHeight(user.getHeight());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        return userDto;
    }

}
