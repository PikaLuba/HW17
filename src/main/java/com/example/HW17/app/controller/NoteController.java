package com.example.HW17.app.controller;


import com.example.HW17.app.model.Note;
import com.example.HW17.app.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/findAll")
    public Page<Note> findAll(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return noteService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Note findById(@PathVariable Integer id) {
        return noteService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Note create(@RequestBody Note note) {
        return noteService.create(note);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        noteService.deleteById(id);
    }

}
