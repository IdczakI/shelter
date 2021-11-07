package pl.idczak.shelter.dog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DogMapper {

    static DogDto toDto(Dog entity) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DogDto dto = new DogDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setWeight(entity.getWeight());
        if (entity.getAdmissionDate() != null)
            dto.setAdmissionDate(entity.getAdmissionDate().format(formatter));
        if (entity.getAdoptionDate() != null)
            dto.setAdoptionDate(entity.getAdoptionDate().format(formatter));
        return dto;
    }

    static Dog toEntity(DogDto dto) {
        Dog entity = new Dog();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        entity.setAdmissionDate(LocalDate.now());
        return entity;
    }
}
