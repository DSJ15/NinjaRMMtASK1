package org.tutorial.ninja.infrastructure.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
@Qualifier("inMemory")
public class DeviceRepositoryInMemoryImpl implements DeviceRepository {

    private static final Map<UUID, Device> DB = new HashMap<>();

    @Override
    public Device create(Device device) {
        DB.put(device.getId(), device);
        return device;
    }

    @Override
    public Device findById(UUID id) {
        return DB.get(id);
    }
}
