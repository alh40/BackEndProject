package repository;

import model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM movies ORDER BY ")
    List<Movie> findMovieToBook1();

    Movie findByTitle(String title);

}
