package org.ebank.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {

    private Long id;

    private String firstName;

    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    protected static Connection getJdbcConnection() {
        return jdbcConnection;
    }

    protected static void setJdbcConnection(Connection jdbcConnection) {
        Person.jdbcConnection = jdbcConnection;
    }

    private static Connection jdbcConnection;

    public static void setJDBCConnection(Connection connection) {
        jdbcConnection = connection;
    }

    public static Person load(Long id) throws SQLException {
        Person person = null;
        PreparedStatement stmt = jdbcConnection.prepareStatement("SELECT ID, FIRSTNAME, LASTNAME FROM PERSON WHERE ID=?");
        stmt.setLong(1, id);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        if (rs.next()) {
            Long fetchedId = rs.getLong("ID");
            String firstName = rs.getString("FIRSTNAME");
            String lastName = rs.getString("LASTNAME");
            person = new Person();
            person.setId(fetchedId);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            return person;
        }
        return null;
    }
}
