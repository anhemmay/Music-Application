package com.example.musicapp.entity;

import com.example.musicapp.dto.SongDTO;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_song")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_song_seq")
    @SequenceGenerator(name = "tbl_song_seq", sequenceName = "tbl_song_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    private String name;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "song_url")
    private String songUrl;
    @ManyToMany(mappedBy = "songs", cascade = CascadeType.ALL)
    private Collection<PlayList> playlists;
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "tbl_artist_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Collection<Artist>artists;
    @OneToMany(mappedBy = "song")
    @JsonIgnore
    private Collection<Favorite> favorites;

}
