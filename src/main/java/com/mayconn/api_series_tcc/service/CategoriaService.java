package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(String id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(String id, Categoria categoria) {
        Categoria existingCategoria = findById(id);
        existingCategoria.setNome(categoria.getNome());
        return categoriaRepository.save(existingCategoria);
    }

    public void delete(String id) {
        Categoria existingCategoria = findById(id);
        categoriaRepository.delete(existingCategoria);
    }
}
