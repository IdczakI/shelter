package pl.idczak.shelter.dog;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {

    List<Dog> findAllByAdoptionDateNull();

    List<Dog> findAllByAdoptionDateNotNull();

    @Query("select a from Dog a where lower(a.name) like lower(concat('%',:search,'%'))" +
            "or a.weight like concat('%',:search,'%') " +
            "or a.admissionDate like concat('%',:search,'%') " +
            "or a.adoptionDate like concat('%',:search,'%')")
    List<Dog> findAllByRegex(@Param("search") String regex);
}
