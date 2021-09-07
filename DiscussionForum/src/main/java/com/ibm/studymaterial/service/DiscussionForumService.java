package com.ibm.studymaterial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.studymaterial.dao.DiscussionForumRepository;
import com.ibm.studymaterial.entity.DiscussionForum;

@Service
public class DiscussionForumService {

	@Autowired
	DiscussionForumRepository discussionForumRepository;
	
	public List<DiscussionForum> getInformationBySubject(String subject) {
		
		List<DiscussionForum> disf = discussionForumRepository.findBySubject(subject);
		System.out.println("Service : "+ disf);
		if(disf != null) return disf;
		return null;
	}
	
	public List<DiscussionForum> getInformationByUserName(String userName) {
		
		List<DiscussionForum> disf = discussionForumRepository.findByUserName(userName);
		if(disf!= null) return disf;
		return null;
	}

	public List<DiscussionForum> getAllDepartments() {
		List<DiscussionForum> disf =  discussionForumRepository.findAll();
		if(disf!= null) return disf;
		return null;
	}

	public boolean updateForum(DiscussionForum forumdata) {
		DiscussionForum disf =  discussionForumRepository.save(forumdata);
		return (disf != null);
	}

}
