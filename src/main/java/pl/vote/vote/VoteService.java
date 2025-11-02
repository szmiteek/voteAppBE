package pl.vote.vote;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.vote.candidate.CandidateRepository;
import pl.vote.candidate.model.Candidate;
import pl.vote.common.exceptions.ElectorHasAlreadyVotedException;
import pl.vote.common.exceptions.NotFoundException;
import pl.vote.elector.ElectorRepository;
import pl.vote.elector.model.Elector;
import pl.vote.vote.model.Vote;

@Service
@RequiredArgsConstructor
public class VoteService {
    private final VoteRepository voteRepository;
    private final ElectorRepository electorRepository;
    private final CandidateRepository candidateRepository;

    @Transactional
    public void createVote(int electorId, int candidateId) {

        Elector elector = electorRepository.findById(electorId)
                .orElseThrow(() -> new NotFoundException("Elector not found"));

        if (elector.isHasVoted()) {
            throw new ElectorHasAlreadyVotedException("Elector has already voted");
        }

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new NotFoundException("Candidate not found"));

        elector.setHasVoted(true);
        Vote vote = new Vote();
        vote.setCandidate(candidate);

        electorRepository.save(elector);
        voteRepository.save(vote);
    }
}
