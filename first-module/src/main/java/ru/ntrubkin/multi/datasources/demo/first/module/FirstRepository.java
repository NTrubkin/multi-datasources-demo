package ru.ntrubkin.multi.datasources.demo.first.module;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface FirstRepository extends CrudRepository<FirstEntity, UUID> {
}
