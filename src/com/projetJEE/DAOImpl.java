package com.projetJEE;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOImpl<T> {

    DBManager dbManager = DBManager.getInstance();

    protected List<T> getEntriesFromQuery(String query, StatementBuilder statementBuilder) {
        try {
            Connection connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            statementBuilder.build(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<T> entries = entriesFromResultSet(resultSet);
            connection.close();
            return entries;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<T>();
        }
    }

    protected int executeUpdateQuery(String query, StatementBuilder statementBuilder, GeneratedKeysChecker generatedKeysChecker) {
        try {
            Connection connection = dbManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementBuilder.build(preparedStatement);
            int records_affected = preparedStatement.executeUpdate();
            if (generatedKeysChecker != null) {
                generatedKeysChecker.check(preparedStatement.getGeneratedKeys());
            }
            connection.close();
            return records_affected;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    protected int executeUpdateQuery(String query, StatementBuilder statementBuilder) {
        return executeUpdateQuery(query, statementBuilder, null);
    }

    protected T getUniqueEntryFromQuery(String query, StatementBuilder statementBuilder) {
        List<T> entries = getEntriesFromQuery(query, statementBuilder);
        return entries.isEmpty() ? null : entries.get(0);
    }

    protected List<T> entriesFromResultSet(ResultSet resultSet) throws SQLException {
        List<T> list = new ArrayList<>();
        while(resultSet.next()) {
            list.add(this.entryFromResultSet(resultSet));
        }
        return list;
    }

    public T entryFromResultSet(ResultSet resultSet) throws SQLException {
        return null;
    }

    public interface StatementBuilder {
        void build (PreparedStatement preparedStatement) throws SQLException;
    }

    public interface GeneratedKeysChecker {
        void check (ResultSet generatedKeys) throws SQLException;
    }
}
