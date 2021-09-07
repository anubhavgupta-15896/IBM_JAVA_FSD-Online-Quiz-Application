package com.ibm.studymaterial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.studymaterial.entity.DiscussionForum;
import com.ibm.studymaterial.service.DiscussionForumService;

@RestController
public class DiscussionForumController {

	@Autowired
	DiscussionForumService discussionForumService;
	
	
	@GetMapping(produces="application/json")
	public List<DiscussionForum> getAllDepartment()
	{
		List<DiscussionForum> disf = discussionForumService.getAllDepartments();
		if(disf != null) return disf;
		return null;
	}
	
	@GetMapping(value = "/getBySubject/{subject}",produces = "application/json")
	public List<DiscussionForum> getAllBySubject(@PathVariable String subject)
	{
		System.out.println(subject);
		List<DiscussionForum> disf = discussionForumService.getInformationBySubject(subject);
		System.out.println(disf);
		if(disf != null) return disf;
		return null;
	}
	
	@GetMapping(value = "/getByUserName/{userName}",produces = "application/json")
	public List<DiscussionForum> getAllByUserName(@PathVariable String userName)
	{
		System.out.println(userName);
		List<DiscussionForum> disf = discussionForumService.getInformationByUserName(userName);
		System.out.println(disf);
		if(disf != null) return disf;
		return null;
	}
	
	@PostMapping(value = "/updateforum",produces = "application/json")
	public HttpStatus updateForum(@RequestBody DiscussionForum forumData)
	{
		return discussionForumService.updateForum(forumData) ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
	}

}
