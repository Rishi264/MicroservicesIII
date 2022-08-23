package com.example.noteService.fisNoteService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.noteService.fisNoteService.model.Note;

public interface NoteRepository extends JpaRepository<Note,Integer>{
	
	@Query("select n from Note n where n.author=?1")
	public List<Note> findNotesByAuthor(String author);
	
	@Query("select n from Note n where n.title=?1")
	public List<Note> findNotesByTitle(String title);

}
