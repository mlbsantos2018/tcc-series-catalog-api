package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.model.Serie;
import com.mayconn.api_series_tcc.repository.CategoriaRepository;
import com.mayconn.api_series_tcc.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
    

    public List<Serie> findByTitulo(String titulo) {
        return serieRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Serie> findByCategoriaNome(String nomeCategoria) {
        List<Categoria> categorias = categoriaRepository.findByNomeContainingIgnoreCase(nomeCategoria);
        return serieRepository.findByCategoriaIn(categorias);
    }

    public List<Serie> findByAnoDeLancamento(String anoDeLancamento) {
        return serieRepository.findByAnoDeLancamento(anoDeLancamento);
    }

    public List<Serie> findByNotaMinima(Double nota) {
        return serieRepository.findAll().stream()
                .filter(serie -> Double.parseDouble(serie.getNota()) >= nota)
                .collect(Collectors.toList());
    }

    public Serie addSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie updateSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public void deleteSerie(String id) {
        serieRepository.deleteById(id);
    }

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Serie findById(String id) {
        return serieRepository.findById(id).orElse(null);
    }
}
