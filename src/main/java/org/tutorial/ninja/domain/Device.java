package org.tutorial.ninja.domain;

import java.util.UUID;

public class Device {
    private UUID id;
    private String name;

    public Device(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }



    public static Device newWorkStation(
            String name
    ) {
        return new Device(
                UUID.randomUUID(),
                name
        );
    }

}
