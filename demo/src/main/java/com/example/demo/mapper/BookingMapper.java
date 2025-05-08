package com.example.demo.mapper;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    // Entity → DTO
    BookingDTO toDto(BookingEntity entity);

    // DTO → Entity (نتجاهل الحقول التي يُولّدها السيرفر)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BookingEntity toEntity(BookingDTO dto);
}
