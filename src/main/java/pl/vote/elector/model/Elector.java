package pl.vote.elector.model;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.vote.common.Person;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Elector extends Person {
    private boolean hasVoted = false;
}
