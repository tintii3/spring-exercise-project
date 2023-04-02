package com.example.springexerciseproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@ToString(exclude = {"movies", "address"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Integer actorId;

    @NonNull
    @Column(name = "first_name")
    private String firstName;

    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "age")
    private Integer age;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "actor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MovieActor> movies = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return actorId.equals(actor.actorId);//Objects.equals(actorId, actor.actorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId);
    }

    public Boolean isActive() {
        return isActive;
    }

    public void activate(){
        this.isActive = true;
    }

    public void deactivate(){
        this.isActive = false;
    }

    public boolean hasAddress() {
        return Objects.nonNull(this.address);
    }

    public void setAddress(Address address) {
        this.address = address;
        address.setActor(this);
    }
    public void unsetRelationship(Address address) {
        this.address = address;
        address.setActor(null);
    }
}
