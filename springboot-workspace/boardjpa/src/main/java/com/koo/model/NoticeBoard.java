package com.koo.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class NoticeBoard {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="article_no")
	private Integer id;
	
	@Column(length=100)
	private String title;
	
	@Column(length=2000)
	private String content;
	
	@CreationTimestamp
	private LocalDateTime write_date;
	
	//@Column(length=50)
	//private String write_id;
	
	@ManyToOne
	private BoardUser writer;


}
