package com.wdebski.MusicLibraryApp.repositories;

import com.wdebski.MusicLibraryApp.model.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {

}
