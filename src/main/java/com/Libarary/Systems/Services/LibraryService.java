package com.Libarary.Systems.Services;

import com.Libarary.Systems.Models.Library;
import com.Libarary.Systems.Repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepo libraryRepo;

    //1 post method 1get method 1 update method

    public Library addLibrary(Library library) {
        return libraryRepo.save(library);
    }

    public List<Library> getLibrary() {
        return libraryRepo.findAll();
    }

    public Optional<Library> getLibraryById(Integer libId) {
        return libraryRepo.findById(libId);
    }
    public Optional<Library> getLibraryByName(String libName) {
        return libraryRepo.findByLibName(libName);
    }

    public Library updateLibraryDetails(Library updatedLibrary) {
        Library existingLibrary = libraryRepo.findById(updatedLibrary.getLibId()).get();
        existingLibrary.setLibName(updatedLibrary.getLibName());
        existingLibrary.setLibAddress(updatedLibrary.getLibAddress());
        existingLibrary.setLibPhone(updatedLibrary.getLibPhone());
        return libraryRepo.save(existingLibrary);
    }

    public String deleteLibrary(Integer libId) {
        libraryRepo.deleteById(libId);
        return "Library Deleted Successfully";
    }
}
