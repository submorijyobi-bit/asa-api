package com.example.asaapi.controller;

import com.example.asaapi.dto.Note;
import com.example.asaapi.dto.SampleMessage;
import com.example.asaapi.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class SampleController {
    private final NoteService noteService;

    public SampleController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/sample")
    public String sample(){
        return "Hello spring boot api!";
    }

    @GetMapping("/sample/api")
    public ResponseEntity<SampleMessage> sampleApi(){
        SampleMessage sampleMessage = new SampleMessage();
        sampleMessage.setId(100);
        sampleMessage.setMessage("Hello spring boot api!");

        return new ResponseEntity<>(sampleMessage, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> findById(@PathVariable long id){
        Note note = noteService.findById(id);

        return ResponseEntity.ok(note);
    }
}
