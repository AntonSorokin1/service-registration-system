package sorant.diplom.srs.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import sorant.diplom.srs.AbstractIdentifiableObject;
import sorant.diplom.srs.services.CRUDService;

import java.util.List;

public abstract class CRUDServiceImpl<O extends AbstractIdentifiableObject, R extends JpaRepository<O, Integer>> implements CRUDService<O> {
    @Autowired
    protected R repository;

    public O create(O object) {
        repository.save(object);
        return object;
    }

    public List<O> readAll() {
        return repository.findAll();
    }

    public O read(int id) {
        return repository.findById(id).orElse(null);
    }

    public boolean update(O object, int id) {
        if (repository.existsById(id)) {
            object.setId(id);
            repository.save(object);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
