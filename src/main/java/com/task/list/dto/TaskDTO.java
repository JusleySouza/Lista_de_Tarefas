package com.task.list.dto;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.list.model.Task;

public class TaskDTO {

	private Long id;
	private String name;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date finishDate;
	private String description;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TaskDTO [id=" + id + ", name=" + name + ", finishDate=" + finishDate + ", description=" + description
				+ "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, finishDate, id, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaskDTO other = (TaskDTO) obj;
		return Objects.equals(description, other.description) && Objects.equals(finishDate, other.finishDate)
				&& id == other.id && Objects.equals(name, other.name);
	}
	
	public void transformModelToDTO(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.finishDate = task.getFinishDate();
		this.description = task.getDescription();
	}
	
}
