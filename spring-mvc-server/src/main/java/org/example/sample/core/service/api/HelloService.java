package org.example.sample.core.service.api;

import org.example.sample.core.domain.Hello;

/**
 * We must create separate service and implementation classes for the Hello Service.
 *
 * This allows spring to inject an (AOP) transaction proxy, between the interface and the implementation.
 * Without this separation spring will not manage transactions correctly.
 */
public interface HelloService {
    long findOrAddByName(String name);

    Hello findById(Long id);
}
