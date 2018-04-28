package by.markovsky.tuningcenter.infrastructure.dao;

import by.markovsky.tuningcenter.infrastructure.exception.DAOException;

import java.util.List;

public interface DAO<E> {
    void add(E obj) throws DAOException;
    void update(E obj) throws DAOException;
    void delete(E obj) throws DAOException;
    E getById(int id) throws DAOException;
    List<E> getAll() throws DAOException;
    List<E> getByQuery(String query) throws DAOException;
}
