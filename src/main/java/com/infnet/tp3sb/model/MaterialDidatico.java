package com.infnet.tp3sb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "materiais")
public class MaterialDidatico {
    @Id
    private String id;
    private String titulo;
    private String descricao;
}
