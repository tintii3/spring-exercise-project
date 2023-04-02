package com.example.springexerciseproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@ToString(exclude = {"movie", "actor"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movie_actor")
public class MovieActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_actor_id")
    private Integer movieActorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    public MovieActor(Movie movie, Actor actor){
        this.movie = movie;
        this.actor = actor;
        this.isActive = true;
    }
    public void unsetRelationship(){
        this.movie.getMovieActors().remove(this);
        this.actor.getMovies().remove(this);
        this.movie = null;
        this.actor = null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActor that = (MovieActor) o;
        return Objects.equals(movie, that.movie) && Objects.equals(actor, that.actor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, actor);
    }
}
