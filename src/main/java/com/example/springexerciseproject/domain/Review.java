package com.example.springexerciseproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_reciews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @NonNull
    @Column(name = "number_of_stars")
    private Integer numberOfStars;

    @Column(name = "review_description")
    private String reviewDescription;

    @Getter
    @Setter
    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public void activate(){
        this.isActive = true;
    }

    public void deactivate(){
        this.isActive = false;
    }
}
