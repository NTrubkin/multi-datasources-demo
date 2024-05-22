package ru.ntrubkin.multi.datasources.demo.first.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
public class FirstEntity {

    @Id
    @UuidGenerator
    private UUID id;
}
