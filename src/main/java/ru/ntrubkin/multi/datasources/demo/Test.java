package ru.ntrubkin.multi.datasources.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ru.ntrubkin.multi.datasources.demo.first.module.FirstService;
import ru.ntrubkin.multi.datasources.demo.second.module.SecondService;

@Service
@RequiredArgsConstructor
public class Test {

    private final FirstService firstService;
    private final SecondService secondService;

    @EventListener(ApplicationReadyEvent.class)
    public void test() {
        firstService.save();
        secondService.save();
    }
}
