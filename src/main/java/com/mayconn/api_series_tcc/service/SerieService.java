package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.model.Serie;
import com.mayconn.api_series_tcc.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> findByTitulo(String titulo) {
        return serieRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Serie> findByCategoriaNome(String nomeCategoria) {
        return serieRepository.findByCategoriaNomeContainingIgnoreCase(nomeCategoria);
    }

    public List<Serie> findByAnoDeLancamento(String anoDeLancamento) {
        return serieRepository.findByAnoDeLancamento(anoDeLancamento);
    }

    public List<Serie> findByNotaMinima(Double nota) {
        return serieRepository.findByAvaliacoesNotaGreaterThanEqual(nota);
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
