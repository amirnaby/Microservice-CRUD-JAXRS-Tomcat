package org.naby.project.model.repository;

import org.naby.project.common.exception.RecordNotExistException;
import org.naby.project.common.jdbc.ConnectionProvider;
import org.naby.project.model.entity.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public PersonRepository() throws Exception {
        connection = ConnectionProvider.getConnection(ConnectionProvider.ORACLE_ORCL);
        connection.setAutoCommit(false);
    }

    public Person selectOne(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select * from person where id=? AND deleted is null");
        preparedStatement.setLong(1, person.getId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next())
            return new Person(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getString("family"), resultSet.getString("phone"));
        throw new RecordNotExistException();
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
