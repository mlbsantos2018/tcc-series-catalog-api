package com.mayconn.api_series_tcc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "series")
public class Serie {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    @DBRef
    private Categoria categoria;
    @DBRef
    private List<Avaliacao> avaliacoes;
    @DBRef
    private List<Comentario> comentarios;
}
