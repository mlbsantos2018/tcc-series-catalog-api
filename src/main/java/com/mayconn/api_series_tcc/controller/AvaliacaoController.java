package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.model.Avaliacao;
import com.mayconn.api_series_tcc.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping
    public List<Avaliacao> findAll() {
        return avaliacaoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable String id) {
        Avaliacao avaliacao = avaliacaoService.findById(id);
        return ResponseEntity.ok(avaliacao);
    }

    @PostMapping
    public Avaliacao save(@RequestBody Avaliacao avaliacao) {
        return avaliacaoService.save(avaliacao);
    }

    @PutMapping("/{id}")
    public Avaliacao update(@PathVariable String id, @RequestBody Avaliacao avaliacao) {
        return avaliacaoService.update(id, avaliacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        avaliacaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
