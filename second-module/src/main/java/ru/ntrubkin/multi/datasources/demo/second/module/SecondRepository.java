package ru.ntrubkin.multi.datasources.demo.second.module;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SecondRepository extends CrudRepository<SecondEntity, UUID> {
}
