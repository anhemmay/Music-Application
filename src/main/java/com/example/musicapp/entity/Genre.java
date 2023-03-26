package com.example.musicapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_genre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_genre_seq")
    @SequenceGenerator(name = "tbl_genre_seq", sequenceName = "tbl_genre_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "genre")
    private Collection<Song> songs;
}
