package com.company.Model;

import java.util.List;

public interface IRepository<T> {
    public List<T> findAll ();
    public T findOne (int id);
    public void create (T entity);

}
