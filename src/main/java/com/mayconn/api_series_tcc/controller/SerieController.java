package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.model.Serie;
import com.mayconn.api_series_tcc.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> findAll() {
        return serieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Serie> findById(@PathVariable String id) {
        Serie serie = serieService.findById(id);
        return ResponseEntity.ok(serie);
    }

    @GetMapping("/titulo/{titulo}")
    public List<Serie> findByTitulo(@PathVariable String titulo) {
        return serieService.findByTitulo(titulo);
    }

    @GetMapping("/categoria/{nomeCategoria}")
    public List<Serie> findByCategoriaNome(@PathVariable String nomeCategoria) {
        return serieService.findByCategoriaNome(nomeCategoria);
    }

    @GetMapping("/ano/{anoDeLancamento}")
    public List<Serie> findByAnoDeLancamento(@PathVariable String anoDeLancamento) {
        return serieService.findByAnoDeLancamento(anoDeLancamento);
    }

    @GetMapping("/avaliacao/{nota}")
    public List<Serie> findByNotaMinima(@PathVariable Double nota) {
        return serieService.findByNotaMinima(nota);
    }

    @PostMapping
    public Serie save(@RequestBody Serie serie) {
        return serieService.addSerie(serie);
    }

    @PutMapping("/{id}")
    public Serie update(@PathVariable String id, @RequestBody Serie serie) {
        serie.setId(id);  // Certifique-se de que o ID está correto
        return serieService.updateSerie(serie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        serieService.deleteSerie(id);
        return ResponseEntity.noContent().build();
    }
}
