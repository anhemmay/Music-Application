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
@Table(name = "tbl_artist")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_artist_seq")
    @SequenceGenerator(name = "tbl_artist_seq", sequenceName = "tbl_artist_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    @Column(name = "stage_name")
    private String stageName;
    @Column(name = "real_name")
    private String realName;
    private Date dob;
    private String description;
    @Column(name = "image_url")
    private String imageUrl;
    @ManyToMany(mappedBy = "artists")
    private Collection<Album> albums;
    @ManyToMany(mappedBy = "artists", cascade = CascadeType.ALL)
    private Collection<Song> songs;


}
