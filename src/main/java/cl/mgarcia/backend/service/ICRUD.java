package cl.mgarcia.backend.service;

import java.util.List;

public interface ICRUD<E> {

    public E findById(Integer id) throws Exception;

    public List<E> findAll();

    public E save(E e) throws Exception;

    public E update(E e) throws Exception;

    public boolean deleteById(Integer id) throws Exception;

}
