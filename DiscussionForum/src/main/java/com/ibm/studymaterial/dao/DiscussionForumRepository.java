package com.ibm.studymaterial.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ibm.studymaterial.entity.DiscussionForum;

public interface DiscussionForumRepository extends MongoRepository<DiscussionForum, String>{

	public List<DiscussionForum> findBySubject(String subject);
	public List<DiscussionForum> findByUserName(String userName);
}
