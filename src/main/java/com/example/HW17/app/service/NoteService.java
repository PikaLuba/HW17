package com.example.HW17.app.service;

import com.example.HW17.app.exception.BadRequestException;
import com.example.HW17.app.model.Note;
import com.example.HW17.app.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional(readOnly = true)
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    public void deleteById(Integer id) {
        noteRepository.deleteById(id);
    }

    public Note create(Note note) {
        return noteRepository.save(note);
    }

    public Note getById(Integer id) {
        return
                noteRepository.findById(id)
                        .orElseThrow(BadRequestException::new);
    }

}
