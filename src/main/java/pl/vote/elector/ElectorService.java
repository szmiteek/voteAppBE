package pl.vote.elector;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.vote.elector.model.Elector;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ElectorService {
    private final ElectorRepository electorRepository;

    public List<Elector> getElectorsWhoHaveNotVoted(){
        return electorRepository.findByHasVotedFalse();
    }

    public void createElector(Elector elector){
        electorRepository.save(elector);
    }
}
