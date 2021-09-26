package org.tutorial.ninja.application.dto;

import java.util.UUID;

public class DeviceDTO {

    private final UUID id;
    private final String name;

    public DeviceDTO(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
