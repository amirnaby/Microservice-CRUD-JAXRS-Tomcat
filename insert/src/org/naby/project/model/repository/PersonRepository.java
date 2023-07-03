package org.naby.project.model.repository;

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

    public void insert(Person person) throws Exception {
        preparedStatement = connection.prepareStatement("select SEQ.nextval id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getLong("id"));
        preparedStatement = connection.prepareStatement("insert into person (id,name,family,phone) values (?,?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getFamily());
        preparedStatement.setString(4, person.getPhone());
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
