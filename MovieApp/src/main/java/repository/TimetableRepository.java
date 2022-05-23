package repository;

import model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    @Query(
            value = "SELECT * FROM timetable WHERE  ",
            nativeQuery = true)
    List<Timetable>



}
