package ru.ntrubkin.multi.datasources.demo.first.module;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FirstService {

    private final FirstRepository firstRepo;

    @Transactional
    public void save() {
        firstRepo.save(new FirstEntity());
    }
}
