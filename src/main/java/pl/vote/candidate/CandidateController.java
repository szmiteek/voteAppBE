package pl.vote.candidate;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vote.candidate.model.Candidate;
import pl.vote.common.ValidationUtils;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("candidates")
public class CandidateController {

    private final CandidateService candidateService;
    private final ValidationUtils validationUtils;

    @GetMapping()
    public List<CandidateDTO> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PostMapping()
    public ResponseEntity<Map<String, String>> addCandidate(@Valid @RequestBody Candidate candidate, BindingResult bindingResult) {
        ResponseEntity<Map<String, String>> validationResponse = validationUtils.validatePersonData(bindingResult);
        if (validationResponse != null) return validationResponse;

        candidateService.createCandidate(candidate);
        return ResponseEntity.ok(Map.of("message", "Candidate has been successfully added"));
    }
}
