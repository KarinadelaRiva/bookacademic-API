package com.bookademic.bookademic.services.interfaces;

import java.util.List;

public interface IService<T> {

    T findEntityById(Long id);
    List<T> findAll();
    List<T> searchByName(String partialName);
    T deleteById(Long id);
}
