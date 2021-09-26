package org.tutorial.ninja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tutorial.ninja.application.dto.DeviceDTO;
import org.tutorial.ninja.application.dto.DeviceRequestDTO;
import org.tutorial.ninja.application.services.DeviceService;

import java.util.UUID;

@RestController
@RequestMapping("devices")
public class DeviceController {

    private final DeviceService deviceService;

    @Autowired
    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping
    public String helloWorld() {
        return "hello";
    }

    @PostMapping(consumes = {"application/json"}, produces = {"application/json"})
    public DeviceDTO register(@RequestBody DeviceRequestDTO deviceRequestDTO) {
        return this.deviceService.register(deviceRequestDTO);
    }

    @GetMapping("/{id}")
    public DeviceDTO findById(@PathVariable UUID id) {
        return this.deviceService.findById(id);
    }
}
