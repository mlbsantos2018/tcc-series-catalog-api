package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.model.Comentario;
import com.mayconn.api_series_tcc.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public Comentario findById(String id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public List<Comentario> findBySerieId(String serieId) {
        return comentarioRepository.findBySerieId(serieId);
    }

    public Comentario save(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario update(String id, Comentario comentario) {
        Comentario existingComentario = findById(id);
        existingComentario.setTexto(comentario.getTexto());
        existingComentario.setUsuario(comentario.getUsuario());
        existingComentario.setSerieId(comentario.getSerieId());
        return comentarioRepository.save(existingComentario);
    }

    public void delete(String id) {
        Comentario existingComentario = findById(id);
        comentarioRepository.delete(existingComentario);
    }
}
