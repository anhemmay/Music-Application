package com.example.musicapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Table(name = "tbl_favorite")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Favorite {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_favorite_seq")
    @SequenceGenerator(name = "tbl_favorite_seq", sequenceName = "tbl_favorite_seq", allocationSize = 1)
    private Integer id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id", referencedColumnName = "id")
    private Song song;

}
