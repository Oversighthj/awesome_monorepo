package com.example.demo.service;

import com.example.demo.entity.BookingEntity;
import com.example.demo.mapper.BookingMapper;
import com.example.demo.model.BookingDTO;
import com.example.demo.model.BookingStatus;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Unit-tests for BookingServiceImpl
 */
class BookingServiceTest {

    private BookingRepository repo;
    private BookingMapper mapper;
    private BookingService service;

    @BeforeEach
    void setUp() {
        repo   = mock(BookingRepository.class);
        mapper = mock(BookingMapper.class);
        service = new BookingServiceImpl(repo, mapper);
    }

    private BookingDTO dto() {
        return new BookingDTO()
                .userId(1L)
                .resourceId(1001L)
                .startTime(OffsetDateTime.parse("2025-05-15T09:00Z"))
                .endTime(OffsetDateTime.parse("2025-05-15T17:00Z"))
                .totalPrice(199.99);
    }

    // ────────── Happy path ──────────
    @Nested
    @DisplayName("create() happy-path")
    class HappyPath {

        @Test
        void saves_pending_and_returns_dto() {
            // arrange
            BookingDTO input = dto();
            BookingEntity entity = new BookingEntity();
            when(mapper.toEntity(input)).thenReturn(entity);
            when(repo.save(any(BookingEntity.class))).thenAnswer(i -> i.getArgument(0));
            when(mapper.toDto(any())).thenReturn(input);

            // act
            BookingDTO result = service.create(input);

            // assert
            ArgumentCaptor<BookingEntity> captor = ArgumentCaptor.forClass(BookingEntity.class);
            verify(repo).save(captor.capture());

            BookingEntity saved = captor.getValue();
            assertThat(saved.getStatus()).isEqualTo(BookingStatus.PENDING);
            assertThat(result).isSameAs(input); // mapper.toDto mocked
        }
    }

    // ────────── Duplicate booking ──────────
    @Nested
    @DisplayName("create() duplicate")
    class Duplicate {

        @Test
        void throws_if_duplicate() {
            BookingDTO input = dto();
            when(repo.existsByUserIdAndResourceIdAndStartTime(
                    eq(1L), eq(1001L), any())).thenReturn(true);

            assertThatThrownBy(() -> service.create(input))
                    .isInstanceOf(IllegalStateException.class)
                    .hasMessageContaining("Duplicate");
        }
    }

    // ────────── getById helper ──────────
    @Test
    void getById_returns_dto() {
        BookingEntity entity = new BookingEntity();
        entity.setId(99L);
        when(repo.findById(99L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto().id(99L));

        BookingDTO dto = service.getById(99L);
        assertThat(dto.getId()).isEqualTo(99L);
    }
}
