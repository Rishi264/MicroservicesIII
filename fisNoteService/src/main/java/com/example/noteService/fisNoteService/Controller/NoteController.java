package com.example.noteService.fisNoteService.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteService.fisNoteService.model.Note;
import com.example.noteService.fisNoteService.model.commentDto;
import com.example.noteService.fisNoteService.service.NoteService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/notes")
public class NoteController {
		@Autowired
		NoteService service;
		@GetMapping("/all")
		public List<Note> getAll(){
			return service.findAllNotes();
		}
		
		@PostMapping("/add")
		public Note addNote(@RequestBody Note note) {
			return service.addNote(note);
		}
		
		@DeleteMapping("/delete/{pid}")
		public String deleteNotes(@PathVariable("pid")int pid) {
			return service.deleteNotes(pid);
		}
		
		@GetMapping("/author/{author}")
		public List<Note> getAllByAuthor(@PathVariable("author")String author){
			return service.findAllNotesByAuthor(author);
		}

		@GetMapping("/title/{title}")
		public List<Note> getAllByTitle(@PathVariable("title")String title){
			return service.findAllNotesByTitle(title);
		}
		
		//@Retry(name="comments",fallbackMethod="sendDummyComments")
		//@CircuitBreaker(name="comments",fallbackMethod="sendDummyComments")
		//@CircuitBreaker(name="comments")
		@RateLimiter(name="default",fallbackMethod="sendDummyComments")
		@GetMapping("/search/comments/{pid}")
		public List<commentDto> getCommentsfrompid(@PathVariable("pid") int pid)
		{
			return service.findCommentsForPid(pid);
		}
		
		public List<commentDto> sendDummyComments(Exception e){
			List<commentDto> data=new ArrayList<>();
			data.add(new commentDto(5001,2001,"temp1","dummy comment1"));
			data.add(new commentDto(5002,2002,"temp2","dummy comment2"));
			data.add(new commentDto(5003,2003,"temp3","dummy comment3"));
			data.add(new commentDto(5004,2004,"temp4","dummy comment4"));
			return data;
		}
}
