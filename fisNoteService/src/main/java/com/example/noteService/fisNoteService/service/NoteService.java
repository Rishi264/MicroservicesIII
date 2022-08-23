package com.example.noteService.fisNoteService.service;

import java.util.List;

import com.example.noteService.fisNoteService.model.Note;
import com.example.noteService.fisNoteService.model.commentDto;

public interface NoteService {
	public List<Note> findAllNotes();
	public Note addNote(Note note);
	public String deleteNotes(int pid);
	public List<Note> findAllNotesByAuthor(String author);
	public List<Note> findAllNotesByTitle(String title);
	
	public List<commentDto> findCommentsForPid(int pid);
}
