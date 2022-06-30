package com.task.list.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.task.list.dto.TaskDTO;

@Entity
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String name;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
	private Date finishDate;
	private String description;
	private boolean finished;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	
	@Override
	public String toString() {
		return "TaskList [id=" + id + ", name=" + name + ", startDate=" + startDate + ", finishDate=" + finishDate
				+ ", description=" + description + ", finished=" + finished + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, finishDate, finished, id, name, startDate);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		return Objects.equals(description, other.description) && Objects.equals(finishDate, other.finishDate)
				&& finished == other.finished && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(startDate, other.startDate);
	}
	
	public void transformDTOtoModel(TaskDTO taskDTO) {
		this.name = taskDTO.getName();
		this.finishDate = taskDTO.getFinishDate();
		this.description = taskDTO.getDescription();
		this.startDate = new Date();
		this.finished = false;
	}
	
}
