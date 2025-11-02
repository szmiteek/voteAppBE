package pl.vote.candidate.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;
import pl.vote.common.Person;
import pl.vote.vote.model.Vote;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends Person {
    @OneToMany(mappedBy = "candidate")
    private Set<Vote> votes;
}
