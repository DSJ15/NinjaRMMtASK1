package org.tutorial.ninja.application.services.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.application.dto.DeviceRequestDTO;
import org.tutorial.ninja.application.mapper.DeviceMapper;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.domain.exception.DeviceRepeatedException;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeviceServiceImplTest {

    @InjectMocks
    private DeviceServiceImpl deviceService;

    @Mock
    private DeviceRepository deviceRepositoryMock;

    @Mock
    private DeviceMapper deviceMapperMock;

    @Test
    public void shouldRegisterADeviceWhenRequestDTOIsOk() {
        final UUID id = UUID.randomUUID();
        final String deviceName = "windows";
        final DeviceRequestDTO deviceWindowsDTO =  new DeviceRequestDTO();
        deviceWindowsDTO.setName(deviceName);

        when(deviceRepositoryMock.save(any())).thenReturn(new Device(
                id,
                deviceName
        ));

        when(deviceRepositoryMock.existsByName(anyString())).thenReturn(false);

        when(deviceMapperMock.toDto(any())).thenReturn(new DeviceDTO(
                id,
                deviceName
        ));

        DeviceDTO result = deviceService.register(deviceWindowsDTO);

        verify(deviceRepositoryMock, times(1)).save(any());
        verify(deviceRepositoryMock, times(1)).existsByName(anyString());

        assertEquals("windows", result.getName());
    }

    // Test with exception
    @Test
    public void shouldNotRegisterADeviceWhenItIsRepeated() {
        final UUID id = UUID.randomUUID();
        final String deviceName = "windows";
        final DeviceRequestDTO deviceWindowsRequester =  new DeviceRequestDTO();
        deviceWindowsRequester.setName(deviceName);

        when(deviceRepositoryMock.existsByName(anyString())).thenReturn(true);

        assertThrows(DeviceRepeatedException.class, ()-> deviceService.register(deviceWindowsRequester));

        verify(deviceRepositoryMock, times(1)).existsByName(anyString());
        verify(deviceRepositoryMock, times(0)).save(any());
    }

}