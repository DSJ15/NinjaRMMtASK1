package org.tutorial.ninja.infrastructure;

import org.tutorial.ninja.domain.Device;

import java.util.UUID;

public interface DeviceRepository {

    Device create(Device device);

    Device findById(UUID id);
}
