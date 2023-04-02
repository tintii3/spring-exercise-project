package com.example.springexerciseproject.domain;

import com.example.springexerciseproject.exception.actor.ActorUnassignedException;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Data
@ToString(exclude = {"movieActors", "movieReviews"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Integer movieId;

    @NonNull
    @Column(name = "movie_title")
    private String movieTitle;

    @NonNull
    @Column(name = "movie_genre")
    private String movieGenre;

    @Column(name = "movie_rating")
    private Double movieRating;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @Column(name = "is_active")
    private  Boolean isActive;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> movieReviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MovieActor> movieActors = new HashSet<>();

    public boolean isActive(){
        return this.isActive;
    }
    public void activate(){
        this.isActive = true;
    }
    public void deactivate(){
        this.isActive = false;
    }
    public boolean hasActor(Integer actorId){
        return this.getAssignedActors().stream().anyMatch((actor) -> {
            return actor.getActorId().equals(actorId);
        });
    }

    public void addActor(Actor actor){
        MovieActor movieActor = new MovieActor(this, actor);
        this.movieActors.add(movieActor);
    }
    public void removeActor(Actor actor){
        MovieActor movieActor = this.getActorRelationship(actor);
        movieActor.unsetRelationship();
    }

    public Collection<Actor> getAssignedActors(){
        return this.movieActors.stream()
                .map(MovieActor::getActor)
                .collect(Collectors.toList());
    }

    private MovieActor getActorRelationship(Actor actor){
        return this.movieActors.stream()
                .filter(movieActor -> movieActor.getActor().getActorId().equals(actor.getActorId()))
                .findAny()
                .orElseThrow(() -> new ActorUnassignedException("Movie dose not have this actor assigned."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return movieId.equals(movie.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
    }

    public Integer getMovieId() {
        return movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public Double getMovieRating() {
        return movieRating;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Review> getMovieReviews() {
        return movieReviews;
    }

    public Set<MovieActor> getMovieActors() {
        return movieActors;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public void setMovieRating(Double movieRating) {
        this.movieRating = movieRating;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setMovieReviews(List<Review> movieReviews) {
        this.movieReviews = movieReviews;
    }

    public void setMovieActors(Set<MovieActor> movieActors) {
        this.movieActors = movieActors;
    }

}
