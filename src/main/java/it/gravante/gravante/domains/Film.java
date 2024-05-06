package it.gravante.gravante.domains;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="films")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codice;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "genere")
    private String genere;

    @Column(name = "anno")
    private int anno;

    @Column(name = "voto")
    private int voto;
}
