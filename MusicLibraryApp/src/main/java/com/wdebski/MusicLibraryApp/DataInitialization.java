package com.wdebski.MusicLibraryApp;

import com.wdebski.MusicLibraryApp.model.Artist;
import com.wdebski.MusicLibraryApp.model.Song;
import com.wdebski.MusicLibraryApp.repositories.ArtistRepository;
import com.wdebski.MusicLibraryApp.repositories.SongRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitialization implements ApplicationListener<ContextRefreshedEvent> {

    private ArtistRepository artistRepository;

    private SongRepository songRepository;

    public DataInitialization(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    public  void onApplicationEvent(ContextRefreshedEvent event) {
        Artist knownArtist = new Artist("Known", "Artist", "KA");
        Song hisFamousSong = new Song("Famous Song", "electronic", "2017", "What?");
        Set<Song> songsSet = new HashSet<>();
        songsSet.add(hisFamousSong);
        knownArtist.setSongs(songsSet);
        Set<Artist> artistsSet = new HashSet<>();
        artistsSet.add(knownArtist);
        hisFamousSong.setArtists(artistsSet);
        artistRepository.save(knownArtist);
        songRepository.save(hisFamousSong);

        Artist moreKnownArtist = new Artist("More Known", "Artist", "MKA");
        Song hisVeryFamousSong = new Song("Very Famous Song", "electronic", "2018", "What?!");
        Song hisMostFamousSong = new Song("Most Famous Song", "electronic", "2018", "Really... What?!");
        Set<Song> nextSet = new HashSet<>();
        nextSet.add(hisVeryFamousSong);
        nextSet.add(hisMostFamousSong);
        moreKnownArtist.setSongs(nextSet);
        Set<Artist> nextArtistsSet = new HashSet<>();
        nextArtistsSet.add(moreKnownArtist);
        hisVeryFamousSong.setArtists(nextArtistsSet);
        hisMostFamousSong.setArtists(nextArtistsSet);
        artistRepository.save(moreKnownArtist);
        songRepository.save(hisVeryFamousSong);
        songRepository.save(hisMostFamousSong);
    }
}
