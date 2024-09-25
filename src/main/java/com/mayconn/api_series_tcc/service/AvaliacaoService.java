package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.model.Avaliacao;
import com.mayconn.api_series_tcc.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> findAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(String id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
    }

    public Avaliacao save(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

    public Avaliacao update(String id, Avaliacao avaliacao) {
        Avaliacao existingAvaliacao = findById(id);
        existingAvaliacao.setNota(avaliacao.getNota());
        existingAvaliacao.setSerie(avaliacao.getSerie());
        return avaliacaoRepository.save(existingAvaliacao);
    }

    public void delete(String id) {
        Avaliacao existingAvaliacao = findById(id);
        avaliacaoRepository.delete(existingAvaliacao);
    }
}
