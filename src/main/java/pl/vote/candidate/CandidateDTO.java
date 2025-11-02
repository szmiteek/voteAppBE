package pl.vote.candidate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CandidateDTO {
    private int id;
    private String firstName;
    private String lastName;
    private int votesCount;
}
