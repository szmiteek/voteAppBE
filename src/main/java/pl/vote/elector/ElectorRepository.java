package pl.vote.elector;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.vote.elector.model.Elector;

import java.util.List;

public interface ElectorRepository extends JpaRepository<Elector,Integer> {
    List<Elector> findByHasVotedFalse();
}
