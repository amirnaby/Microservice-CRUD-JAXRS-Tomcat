package org.naby.project.model.repository;

import org.naby.project.common.jdbc.ConnectionProvider;
import org.naby.project.model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.naby.project.common.jdbc.ConnectionProvider.ORACLE_ORCL;

public class PersonRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonRepository() throws Exception {
        connection = ConnectionProvider.getConnection(ORACLE_ORCL);
        connection.setAutoCommit(false);
    }

    public void update(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("update person set deleted=1 where id=?");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.executeUpdate();
    }

    public void commit() throws Exception {
        connection.commit();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
