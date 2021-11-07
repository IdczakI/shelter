package pl.idczak.shelter.dog;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    List<DogDto> findAllNonAdoptedDogs(){
        return dogRepository.findAllByAdoptionDateNull()
                .stream()
                .map(DogMapper::toDto)
                .collect(Collectors.toList());
    }

    List<DogDto> findAllAdoptedDogs(){
        return dogRepository.findAllByAdoptionDateNotNull()
                .stream()
                .map(DogMapper::toDto)
                .collect(Collectors.toList());
    }

    List<DogDto> findAllNonAdoptedDogsByRegex(String regex){
        return findAllDogsByRegex(regex)
                .filter(dog -> dog.getAdoptionDate() == null)
                .collect(Collectors.toList());
    }

    List<DogDto> findAllAdoptedDogsByRegex(String regex){
        return findAllDogsByRegex(regex)
                .filter(dog -> dog.getAdoptionDate() != null)
                .collect(Collectors.toList());
    }

    private Stream<DogDto> findAllDogsByRegex(String regex){
        return dogRepository.findAllByRegex(regex)
                .stream()
                .map(DogMapper::toDto);
    }
}
