package org.tutorial.ninja.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tutorial.ninja.application.services.DeviceService;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.application.dto.DeviceRequestDTO;
import org.tutorial.ninja.application.mapper.DeviceMapper;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Autowired
    public DeviceServiceImpl(@Qualifier("inMemory") DeviceRepository deviceRepository, DeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public DeviceDTO register(DeviceRequestDTO deviceRequestDTO) {
        final Device device = Device.newWorkStation(
                deviceRequestDTO.getName()
        );
        return deviceMapper.toDto(deviceRepository.create(device));
    }

    @Override
    public DeviceDTO findById(UUID id) {
        return deviceMapper.toDto(this.deviceRepository.findById(id));
    }
}
