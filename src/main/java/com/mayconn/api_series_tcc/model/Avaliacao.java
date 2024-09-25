package com.mayconn.api_series_tcc.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "avaliacoes")
public class Avaliacao {
    @Id
    private String id;
    private Double nota;
    @DBRef
    private Serie serie;
}
