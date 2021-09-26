package org.tutorial.ninja.application.mapper;

import org.springframework.stereotype.Component;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.domain.Device;

@Component
public class DeviceMapper {

    public DeviceDTO toDto(Device device) {
        return new DeviceDTO(
                device.getId(),
                device.getName()
        );
    }

}
