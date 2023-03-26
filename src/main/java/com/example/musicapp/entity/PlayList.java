package com.example.musicapp.entity;

import com.example.musicapp.dto.PlayListDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_playlist")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_playlist_seq")
    @SequenceGenerator(name = "tbl_playlist_seq", sequenceName = "tbl_playlist_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    private String name;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;
    @Column(name = "updated_at",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp updatedAt;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "tbl_playlist_song",
            joinColumns = @JoinColumn(name = "playlist_id"),
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private Collection<Song> songs;

}
