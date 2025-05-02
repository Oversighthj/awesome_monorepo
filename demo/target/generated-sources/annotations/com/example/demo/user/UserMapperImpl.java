package com.example.demo.user;

import com.example.demo.model.UserDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-02T13:33:39+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        if ( user.getId() != null ) {
            userDTO.setId( user.getId().intValue() );
        }
        userDTO.setEmail( user.getEmail() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( userDto.getId() != null ) {
            user.id( userDto.getId().longValue() );
        }
        user.email( userDto.getEmail() );

        return user.build();
    }
}
