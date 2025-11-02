package pl.vote.candidate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.vote.candidate.model.Candidate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidateService {
    private final CandidateRepository candidateRepository;

    public void createCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public List<CandidateDTO> getAllCandidatesWithVotes() {
        return candidateRepository.findAllWithVotes().stream()
                .map(candidate -> new CandidateDTO(
                        candidate.getId(),
                        candidate.getFirstName(),
                        candidate.getLastName(),
                        candidate.getVotes().size()
                ))
                .toList();
    }
}
