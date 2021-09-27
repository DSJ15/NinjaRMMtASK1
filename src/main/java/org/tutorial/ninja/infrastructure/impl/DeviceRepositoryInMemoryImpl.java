package org.tutorial.ninja.infrastructure.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.tutorial.ninja.domain.Device;
import org.tutorial.ninja.infrastructure.DeviceRepository;

import java.util.*;

@Repository
@Qualifier("inMemory")
public class DeviceRepositoryInMemoryImpl implements DeviceRepository {

    private static final Map<UUID, Device> DB = new HashMap<>();

    @Override
    public Device save(Device device) {
        DB.put(device.getId(), device);
        return device;
    }

    @Override
    public Optional<Device> findById(UUID id) {
        return Optional.of(DB.get(id));
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public boolean existsByName(String name) {
        return DB.values().stream().anyMatch(device -> Objects.equals(device.getName(), name.trim().toLowerCase()));
    }

    @Override
    public List<Device> findAll() {
        return null;
    }

    @Override
    public List<Device> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Device> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Device> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(Device entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Device> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Device> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Device> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Device> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Device> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<UUID> uuids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Device getOne(UUID uuid) {
        return null;
    }

    @Override
    public Device getById(UUID uuid) {
        return null;
    }

    @Override
    public <S extends Device> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Device> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Device> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Device> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Device> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Device> boolean exists(Example<S> example) {
        return false;
    }
}
