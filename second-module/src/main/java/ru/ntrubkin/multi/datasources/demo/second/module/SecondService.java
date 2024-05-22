package ru.ntrubkin.multi.datasources.demo.second.module;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecondService {

    private final SecondRepository secondRepo;

    @Transactional
    public void save() {
        secondRepo.save(new SecondEntity());
    }
}
