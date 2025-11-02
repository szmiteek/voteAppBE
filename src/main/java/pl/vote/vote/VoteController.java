package pl.vote.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.vote.common.exceptions.ElectorHasAlreadyVotedException;
import pl.vote.common.exceptions.NotFoundException;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("vote")
public class VoteController {
    private final VoteService voteService;

    @PostMapping()
    public ResponseEntity<Map<String, String>> vote(@RequestParam int electorId, @RequestParam int candidateId) {
        try {
            voteService.createVote(electorId, candidateId);
            return ResponseEntity.ok(Map.of("message", "vote created"));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", e.getMessage()));
        } catch (ElectorHasAlreadyVotedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message", e.getMessage()));
        }

    }
}
