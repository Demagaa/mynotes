package com.notes.mynotes.repo;

import com.notes.mynotes.models.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
