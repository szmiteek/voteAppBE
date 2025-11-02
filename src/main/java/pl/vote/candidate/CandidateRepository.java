package pl.vote.candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vote.candidate.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Integer> {
}
