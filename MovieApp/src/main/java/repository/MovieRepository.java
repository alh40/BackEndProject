package repository;

import jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle;
import model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    Movie findbyTitle(String title);
}
