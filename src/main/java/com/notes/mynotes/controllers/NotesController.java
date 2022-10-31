package com.notes.mynotes.controllers;

import com.notes.mynotes.models.Note;
import com.notes.mynotes.repo.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class NotesController {

    @Autowired
    private NoteRepository noteRepository;
    @GetMapping("/notes")
    public String noteMain(Model model) {
        Iterable<Note> notes = noteRepository.findAll();
        model.addAttribute("notes", notes);
        return "notes";
    }
    @GetMapping("/notes/add")
    public String NoteAdd(Model model) {
        return "notes-add";
    }
    @PostMapping("/notes/add")
    public String newNoteAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        Note note = new Note(title, anons, full_text);
        noteRepository.save(note);
        return "redirect:/notes";
    }
    @GetMapping("/notes/{id}")
    public String noteDetails(@PathVariable(value = "id") long id, Model model) {
        if(!noteRepository.existsById(id)) {
            return "redirect:/notes";
        }

        Optional<Note> note = noteRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("note", res);
        return "note-details";
    }
    @GetMapping("/notes/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if(!noteRepository.existsById(id)) {
            return "redirect:/notes";
        }

        Optional<Note> note = noteRepository.findById(id);
        ArrayList<Note> res = new ArrayList<>();
        note.ifPresent(res::add);
        model.addAttribute("note", res);
        return "note-edit";
    }
    @PostMapping("/notes/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(title);
        note.setAnons(anons);
        note.setFull_text(full_text);
        noteRepository.save(note);

        return "redirect:/notes";
    }

    @PostMapping("/notes/{id}/remove")
    public String noteDelete(@PathVariable(value = "id") long id, Model model) {
        Note note = noteRepository.findById(id).orElseThrow();
        noteRepository.delete(note);

        return "redirect:/notes";
    }
}
