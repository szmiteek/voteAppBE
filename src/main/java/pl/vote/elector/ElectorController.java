package pl.vote.elector;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.vote.common.ValidationUtils;
import pl.vote.elector.model.Elector;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor

@RequestMapping("electors")
public class ElectorController {
    private final ElectorService electorService;
    private final ValidationUtils validationUtils;

    @PostMapping()
    public ResponseEntity<Map<String, String>> addElector(@Valid @RequestBody Elector elector, BindingResult bindingResult) {
        ResponseEntity<Map<String, String>> validationResponse = validationUtils.validatePersonData(bindingResult);
        if (validationResponse != null) return validationResponse;

        electorService.createElector(elector);
        return ResponseEntity.ok(Map.of("message", "Elector has been successfully added"));
    }

    @GetMapping("/not-voted")
    public List<Elector> getElectorsWhoHaveNotVoted() {
        return electorService.getElectorsWhoHaveNotVoted();
    }
}
