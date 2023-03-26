package com.example.musicapp.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_album")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_album_seq")
    @SequenceGenerator(name = "tbl_album_seq", sequenceName = "tbl_album_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    private String title;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "created_at")
    private Date createdAt;
    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;
    private String description;
    @ManyToMany
    @JoinTable(
            name = "tbl_artist_album",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private Collection<Artist>artists;
}
