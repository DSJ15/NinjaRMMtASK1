package org.tutorial.ninja.infrastructure.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.UUID;

@Repository
@Qualifier("postgres")
public class DeviceRepositoryPostgresImpl implements DeviceRepository {

    @Override
    public Device create(Device device) {
        return null;
    }

    @Override
    public Device findById(UUID id) {
        return null;
    }
}
