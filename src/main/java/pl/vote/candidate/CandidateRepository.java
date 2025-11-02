package pl.vote.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.vote.candidate.model.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
    @Query("SELECT c FROM Candidate c LEFT JOIN FETCH c.votes")
    List<Candidate> findAllWithVotes();
}
