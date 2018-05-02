package com.wdebski.MusicLibraryApp.web;

import com.wdebski.MusicLibraryApp.model.Artist;
import com.wdebski.MusicLibraryApp.repositories.ArtistRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtistsController {

    private final ArtistRepository artistsRepository;

    public ArtistsController(ArtistRepository artistsRepository) {
        this.artistsRepository = artistsRepository;
    }

    @GetMapping("/")
    public String getMain(Model model) {
        return "index";
    }

    @GetMapping("/artists")
    public String getArtists(Model model) {
        Iterable<Artist> allArtists = artistsRepository.findAll();
        model.addAttribute("artists", allArtists);
        return "artists";
    }
}
