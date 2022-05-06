package com.fmi.web.theaterticketsystem.controller;

import com.fmi.web.theaterticketsystem.dto.TicketDto;
import com.fmi.web.theaterticketsystem.dto.UserDto;
import com.fmi.web.theaterticketsystem.mapper.TicketDtoMapper;
import com.fmi.web.theaterticketsystem.mapper.UserDtoMapper;
import com.fmi.web.theaterticketsystem.model.User;
import com.fmi.web.theaterticketsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private UserDtoMapper userDtoMapper;

  private UserService userService;

  private TicketDtoMapper ticketDtoMapper;

  @Autowired
  public UserController(UserDtoMapper userDtoMapper, UserService userService, TicketDtoMapper ticketDtoMapper) {
    this.userDtoMapper = userDtoMapper;
    this.userService = userService;
    this.ticketDtoMapper = ticketDtoMapper;
  }

  @GetMapping
  public List<UserDto> getUsers() {
    List<User> entities = userService.findAll();
    return userDtoMapper.convertListToDtoList(entities);
  }

  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto){
    User user = this.userDtoMapper.convertToEntity(userDto);
    user = this.userService.createUser(user);
    return this.userDtoMapper.convertToDto(user);
  }

  @GetMapping("/{id}")
  public UserDto getUserById(@PathVariable(value = "id") Long id) {
    User entity = userService.findById(id);
    UserDto userDto = this.userDtoMapper.convertToDto(entity);
    userDto.setTickets(this.ticketDtoMapper.convertListToDtoList(entity.getTickets()));
    return userDto;
  }
}
