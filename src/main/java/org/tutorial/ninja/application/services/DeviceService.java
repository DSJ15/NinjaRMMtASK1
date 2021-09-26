package org.tutorial.ninja.application.services;

import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.application.dto.DeviceRequestDTO;

import java.util.UUID;

public interface DeviceService {

    DeviceDTO register(DeviceRequestDTO deviceRequestDTO);

    DeviceDTO findById(UUID id);

}
