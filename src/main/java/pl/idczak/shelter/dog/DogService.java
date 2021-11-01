package pl.idczak.shelter.dog;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    List<DogDto> findAllDogs(){
        return dogRepository.findAll()
                .stream()
                .map(DogMapper::toDto)
                .collect(Collectors.toList());
    }
}
