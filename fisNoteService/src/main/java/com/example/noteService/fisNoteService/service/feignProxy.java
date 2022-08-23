package com.example.noteService.fisNoteService.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.noteService.fisNoteService.model.commentDto;

@FeignClient(name="commentservice")
public interface feignProxy {
	@GetMapping("/search/{pid}")
	public List<commentDto> searchCommentsByPid(@PathVariable("pid") int pid);
}
