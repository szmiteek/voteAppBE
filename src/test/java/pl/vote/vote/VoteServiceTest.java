package pl.vote.vote;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.vote.candidate.CandidateRepository;
import pl.vote.candidate.model.Candidate;
import pl.vote.common.exceptions.ElectorHasAlreadyVotedException;
import pl.vote.common.exceptions.NotFoundException;
import pl.vote.elector.ElectorRepository;
import pl.vote.elector.model.Elector;
import pl.vote.vote.model.Vote;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VoteServiceTest {

    @InjectMocks
    private VoteService voteService;

    @Mock
    private ElectorRepository electorRepository;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private VoteRepository voteRepository;

    @Test
    void createVote_shouldSaveVoteAndSetElectorHasVoted() {
        Elector elector = new Elector();
        elector.setId(1);
        elector.setHasVoted(false);

        Candidate candidate = new Candidate();
        candidate.setId(1);

        when(electorRepository.findById(1)).thenReturn(Optional.of(elector));
        when(candidateRepository.findById(1)).thenReturn(Optional.of(candidate));

        voteService.createVote(1, 1);

        assertTrue(elector.isHasVoted());
        verify(electorRepository).save(elector);
        verify(voteRepository).save(any(Vote.class));
    }

    @Test
    void createVote_shouldThrowException_ifElectorAlreadyVoted() {
        Elector elector = new Elector();
        elector.setId(1);
        elector.setHasVoted(true);

        when(electorRepository.findById(1)).thenReturn(Optional.of(elector));

        assertThrows(ElectorHasAlreadyVotedException.class, () -> voteService.createVote(1, 1));
    }

    @Test
    void createVote_shouldThrowException_ifElectorNotFound() {
        when(electorRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> voteService.createVote(1, 1));
    }

    @Test
    void createVote_shouldThrowException_ifCandidateNotFound() {
        Elector elector = new Elector();
        elector.setId(1);
        elector.setHasVoted(false);

        when(electorRepository.findById(1)).thenReturn(Optional.of(elector));
        when(candidateRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> voteService.createVote(1, 1));
    }
}