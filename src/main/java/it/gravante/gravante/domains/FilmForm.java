package it.gravante.gravante.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmForm {
    private String titolo;
    private String genere;
    private int anno;
    private int voto;
}
