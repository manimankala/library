package com.Libarary.Systems.Controller;

import com.Libarary.Systems.Models.Library;
import com.Libarary.Systems.Services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @PostMapping()
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.addLibrary(library);
    }

    @GetMapping
    public List<Library> findLibraryData() {
        return libraryService.getLibrary();
    }

    @GetMapping("/id")
    public Optional<Library> findLibraryById(@RequestParam Integer libId) {
        return libraryService.getLibraryById(libId);
    }
    @GetMapping("/name")
    public Optional<Library> findLibraryByName(@RequestParam String libName) {
        return libraryService.getLibraryByName(libName);
    }

    @PutMapping
    public Library updateLibrary(@RequestBody Library library) {
        return libraryService.updateLibraryDetails(library);
    }

    @DeleteMapping
    public String deleteLibraryitem(@RequestParam Integer libId) {
        return libraryService.deleteLibrary(libId);
    }
}
