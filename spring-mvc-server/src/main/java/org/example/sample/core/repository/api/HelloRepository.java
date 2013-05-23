package org.example.sample.core.repository.api;

import org.example.sample.core.domain.Hello;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Here we are using Spring Data to generate a (dynamic) proxy that will implement this interface.
 * <p/>
 * Spring Data parses the method names in order to build the SQL statements.
 */
@Transactional(readOnly = true)
public interface HelloRepository extends JpaRepository<Hello, Long> {

    Hello findByName(String name);
}
