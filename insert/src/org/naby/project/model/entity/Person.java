package org.naby.project.model.entity;

import java.io.Serializable;

public class Person implements Serializable {
    private long id;
    private String name;
    private String family;
    private String phone;
    private String deleted;

    public Person() {}

    public Person(long id, String name, String family, String phone, String deleted) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phone = phone;
        this.deleted = deleted;
    }

    public Person(String name, String family, String phone) {
        this.name = name;
        this.family = family;
        this.phone = phone;
    }

    public Person(long id, String name, String family, String phone) {
        this.id = id;
        this.name = name;
        this.family = family;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }
    public Person setId(long id) {
        this.id = id;
        return this;
    }
    public String getName() {
        return name;
    }
    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getDeleted() {
        return deleted;
    }

    public Person setDeleted(String deleted) {
        this.deleted = deleted;
        return this;
    }
}
