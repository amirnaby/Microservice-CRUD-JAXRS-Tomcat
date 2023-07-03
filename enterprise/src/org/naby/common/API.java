package org.naby.common;

public interface API {
    String SELECT_PERSON="http://localhost:9990/person/findOne?id=%s";
    String SAVE_PERSON="http://localhost:9991/person/save?name=%s&family=%s&phone=%s";
    String UPDATE_PERSON="http://localhost:9992/person/update?id=%s";
}