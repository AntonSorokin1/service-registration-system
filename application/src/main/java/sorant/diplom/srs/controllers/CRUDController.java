package sorant.diplom.srs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sorant.diplom.srs.services.CRUDService;

import java.util.List;

public abstract class CRUDController<O, S extends CRUDService<O>> {
    @Autowired
    protected S service;

    @PostMapping("/")
    public O create(@RequestBody O object) {
        return service.create(object);
    }

    @GetMapping("/")
    public List<O> readAll() {
        return service.readAll();
    }

    @GetMapping("/{id}")
    public O read(@PathVariable(name = "id") int id) {
        return service.read(id);
    }

    @PutMapping("/{id}")
    public boolean update(@PathVariable(name = "id") int id, @RequestBody O object) {
        return service.update(object, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable(name = "id") int id) {
        return service.delete(id);
    }
}
