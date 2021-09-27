package org.tutorial.ninja.application.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.tutorial.ninja.application.services.DeviceService;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.application.dto.DeviceRequestDTO;
import org.tutorial.ninja.application.mapper.DeviceMapper;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.domain.exception.DeviceRepeatedException;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final DeviceMapper deviceMapper;

    @Autowired
    public DeviceServiceImpl(
            DeviceRepository deviceRepository,
            DeviceMapper deviceMapper
    ) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public DeviceDTO register(DeviceRequestDTO deviceRequestDTO) {
        validateIfDeviceNameExits(deviceRequestDTO);
        final Device device = Device.newWorkStation(
                deviceRequestDTO.getName()
        );
        return deviceMapper.toDto(Optional.of(deviceRepository.save(device)));
    }


    private void validateIfDeviceNameExits(DeviceRequestDTO deviceRequestDTO) {
        final boolean existsWithName = this.deviceRepository.existsByName(deviceRequestDTO.getName()) ;
        if (existsWithName){
            throw new DeviceRepeatedException();
        }
    }

    @Override
    public DeviceDTO findById(UUID id) {
        return deviceMapper.toDto(this.deviceRepository.findById(id));
    }
}
