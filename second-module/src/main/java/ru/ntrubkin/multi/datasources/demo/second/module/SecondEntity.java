package ru.ntrubkin.multi.datasources.demo.second.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class SecondEntity {

    @Id
    @UuidGenerator
    private UUID id;
}
