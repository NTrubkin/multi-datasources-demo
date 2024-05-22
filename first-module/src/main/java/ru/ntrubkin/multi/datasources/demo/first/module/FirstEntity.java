package ru.ntrubkin.multi.datasources.demo.first.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "first_entities")
@Data
public class FirstEntity {

    @Id
    @UuidGenerator
    private UUID id;
}
