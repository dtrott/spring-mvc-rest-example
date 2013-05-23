package org.example.sample.web.model;

import org.example.sample.core.domain.Hello;

/**
 * Form used for rending JSP pages.
 */
public class FormHello {
    private Long id;
    private String name;

    public FormHello() {
    }

    public FormHello(Hello hello) {
        this(hello.getId(), hello.getName());
    }

    public FormHello(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
