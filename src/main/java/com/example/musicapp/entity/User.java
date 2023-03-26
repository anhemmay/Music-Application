package com.example.musicapp.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_user_seq")
    @SequenceGenerator(name = "tbl_user_seq", sequenceName = "tbl_user_seq", allocationSize = 1)
    @Column(unique = true)
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @Column(name = "image_url")
    private String imageUrl;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<PlayList> playLists;
    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL)
    private Collection<Favorite> favorites;
}
