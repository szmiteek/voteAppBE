package pl.vote.vote;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vote.vote.model.Vote;

public interface VoteRepository extends JpaRepository<Vote,Integer> {
}
