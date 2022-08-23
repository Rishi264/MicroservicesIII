package com.example.noteService.fisNoteService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="note")
public class Note {
		@Id
		int pid;
		@Column
		String author;
		@Column
		String description;
		@Column
		String title;
		
		public Note()
		{
			
		}

		public Note(int pid, String author, String description, String title) {
			super();
			this.pid = pid;
			this.author = author;
			this.description = description;
			this.title = title;
		}

		public int getPid() {
			return pid;
		}

		public void setPid(int pid) {
			this.pid = pid;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}
		
}
