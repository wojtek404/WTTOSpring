package com.wdebski.MusicLibraryApp.repositories;

import com.wdebski.MusicLibraryApp.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
