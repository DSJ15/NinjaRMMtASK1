package org.tutorial.ninja.application.mapper;

import org.springframework.stereotype.Component;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.domain.Device;

import java.util.Optional;

@Component
public class DeviceMapper {

    public DeviceDTO toDto(Optional<Device> optionalDevice) {
        if (optionalDevice.isPresent()) {
            final Device device = optionalDevice.get();
            return new DeviceDTO(
                    device.getId(),
                    device.getName()
            );
        } else return null;
    }

}
