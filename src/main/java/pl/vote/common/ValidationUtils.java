package pl.vote.common;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class ValidationUtils {

    public ResponseEntity<Map<String, String>> validatePersonData(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) return null;

        Map<String, String> errors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }
}
