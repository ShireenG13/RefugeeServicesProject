package com.shireen.refugeeservicesproject.service;


import com.shireen.refugeeservicesproject.model.Refugee;
import com.shireen.refugeeservicesproject.repository.RefugeeRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@SpringBootTest
public class RefugeeServiceTest {

    @Mock
    private RefugeeRepository refugeeRepository;

    @InjectMocks
    private RefugeeService refugeeService;
    private Refugee refugee;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        refugee = new Refugee();
        refugee.setRefugeeId(1L);
        refugee.setFirst_name("John");
        refugee.setLast_name("Doe");
        refugee.setEmail("john.doe@example.com");
        refugee.setPassword("password123");
        refugee.setPhone("1111111111");
        refugee.setAddress("123 Main St");
        refugee.setArea("Cordova");
        refugee.setCountry_of_origin("United States");
        refugee.setFamily_count(4);
        refugee.setDate_of_birth(LocalDate.of(2000, 1, 1));
    }

    @Test
    void getRefugeeById_ValidId_ReturnsRefugee() {
        // Arrange
        when(refugeeRepository.findById(1L)).thenReturn(Optional.of(refugee));

        // Act
        Optional<Refugee> result = refugeeService.getRefugeeById(1L);

        // Assert
        assertNotNull(result);
        assertEquals(refugee.getRefugeeId(), result.get().getRefugeeId());
        verify(refugeeRepository, times(1)).findById(1L);
    }

    @Test
    void getRefugeeById_InvalidId_ThrowsException() {
        // Arrange
        when(refugeeRepository.findById(2L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> refugeeService.getRefugeeById(2L));
        verify(refugeeRepository, times(1)).findById(2L);
    }

    @Test
    void deleteRefugee_ValidId_DeletesRefugee() {
        // Act
        refugeeService.deleteRefugee(1L);

        // Assert
        verify(refugeeRepository, times(1)).deleteById(1L);
    }

    @ParameterizedTest
    @ValueSource(strings = {"shania", "shania", "shania", "shania"})
    public void testCreateRefugeeWithDifferentNames(String first_name) {
        // Arrange
        Refugee refugee = new Refugee();
        refugee.setFirst_name(first_name);
        refugee.setLast_name("Martin");
        refugee.setDate_of_birth(LocalDate.of(2022, 3, 12));
        refugee.setEmail("saira@express.com");
        refugee.setPhone("9078765434");
        refugee.setAddress("sdrfdsfdsf");
        refugee.setArea("dallas");
        refugee.setCountry_of_origin("ethipoia");
        refugee.setFamily_count(0);

        // Act
        refugeeService.createRefugee(refugee);
        Optional<Refugee> retrievedRefugee = refugeeService.getRefugeeById(refugee.getRefugeeId());

        // Assert
        assertNotNull(retrievedRefugee, "Refugee should be created.");
        assertEquals(first_name, retrievedRefugee.get().getFirst_name(), "Refugee name should match.");
    }
}
