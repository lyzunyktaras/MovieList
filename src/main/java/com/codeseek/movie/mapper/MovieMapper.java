package com.codeseek.movie.mapper;

import com.codeseek.movie.dto.MovieDTO;
import com.codeseek.movie.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    Movie map(MovieDTO movieDTO);

    MovieDTO map(Movie movie);

    void update(MovieDTO movieDTO, @MappingTarget Movie movie);

    List<MovieDTO> map(List<Movie> movies);
}
