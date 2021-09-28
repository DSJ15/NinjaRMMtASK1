package org.tutorial.ninja.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Device {
    @Id
    private UUID id;
    private String name;

    public Device() {
    }

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
