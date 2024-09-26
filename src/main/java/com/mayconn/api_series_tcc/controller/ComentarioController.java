package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.model.Comentario;
import com.mayconn.api_series_tcc.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> findById(@PathVariable String id) {
        Comentario comentario = comentarioService.findById(id);
        return ResponseEntity.ok(comentario);
    }

    @GetMapping("/serie/{serieId}")
    public List<Comentario> findBySerieId(@PathVariable String serieId) {
        return comentarioService.findBySerieId(serieId);
    }

    @PostMapping
    public Comentario save(@RequestBody Comentario comentario) {
        return comentarioService.save(comentario);
    }

    @PutMapping("/{id}")
    public Comentario update(@PathVariable String id, @RequestBody Comentario comentario) {
        return comentarioService.update(id, comentario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        comentarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
