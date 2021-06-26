package sorant.diplom.srs.services;

import java.util.List;

public interface CRUDService<T> {
    T create(T object);

    List<T> readAll();

    T read(int id);

    boolean update(T object, int id);

    boolean delete(int id);
}
