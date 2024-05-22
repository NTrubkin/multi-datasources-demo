package ru.ntrubkin.multi.datasources.demo.second.module;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "second_entities")
@Data
public class SecondEntity {

    @Id
    @UuidGenerator
    private UUID id;
}
