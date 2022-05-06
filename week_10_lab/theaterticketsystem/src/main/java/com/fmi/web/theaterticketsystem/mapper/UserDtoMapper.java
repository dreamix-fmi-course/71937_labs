package com.fmi.web.theaterticketsystem.mapper;

import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.model.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserDtoMapper {

  public User convertToEntity(UserDto dto){
    return new User(dto.getId(), dto.getEmail(),  dto.getUserName());
  }

  public UserDto convertToDto(User user) {
    return new UserDto(user.getId(), user.getUserName(), user.getEmail());
  }

  public List<UserDto> convertListToDtoList(List<User> users) {
    return users.stream().map(this::convertToDto).collect(Collectors.toList());
  }
}
