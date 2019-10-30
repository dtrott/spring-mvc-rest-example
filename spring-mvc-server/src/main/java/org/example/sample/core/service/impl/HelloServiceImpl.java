package org.example.sample.core.service.impl;

import org.example.sample.core.domain.Hello;
import org.example.sample.core.repository.api.HelloRepository;
import org.example.sample.core.service.api.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * The service class provides transaction boundaries around repository calls.
 * <p/>
 * So that multiple repo methods can be called with-in the same transaction.
 * Hence if one call fails the entire transaction is rolled back.
 */
@Component
public class HelloServiceImpl implements HelloService {

    private final HelloRepository helloRepository;

    @Autowired
    public HelloServiceImpl(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    @Transactional
    public long findOrAddByName(String name) {
        final Hello found = helloRepository.findByName(name);

        if (found != null) {
            return found.getId();
        } else {
            return add(name);
        }
    }

    private long add(String name) {
        final Hello hello = new Hello();
        hello.setName(name);

        return helloRepository.save(hello).getId();
    }

    @Override
    @Transactional
    public Hello findById(Long id) {
        return helloRepository.findById(id).get();
    }
}
