package com.example.demo.mapper;

import com.example.demo.entity.BookingEntity;
import com.example.demo.model.BookingResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Mapper يحوّل كائن {@link BookingEntity}
 * إلى كائن {@link BookingResponseDTO} باستخدام ‎MapStruct.
 */
@Mapper(componentModel = "spring",
        imports = {OffsetDateTime.class, ZoneOffset.class})
public interface BookingMapper {

    /** تحويل Entity → DTO */
    @Mapping(target = "bookingId", source = "id")
    @Mapping(
        target      = "bookingTime",
        expression  = "java( OffsetDateTime.ofInstant(entity.getBookingTime(), ZoneOffset.UTC) )"
    )
    BookingResponseDTO toDto(BookingEntity entity);

    /*  لو احتجت العكس (DTO → Entity) لاحقاً فعِّل هذا:
    @InheritInverseConfiguration
    @Mapping(
        target      = "bookingTime",
        expression  = "java( dto.getBookingTime().toInstant() )"
    )
    BookingEntity toEntity(BookingResponseDTO dto);
    */
}
