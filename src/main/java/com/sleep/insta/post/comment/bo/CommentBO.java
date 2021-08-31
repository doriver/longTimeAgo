package com.sleep.insta.post.comment.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sleep.insta.post.comment.dao.CommentDAO;
import com.sleep.insta.post.comment.model.Comment;

@Service
public class CommentBO {
	@Autowired
	private CommentDAO commentDAO;
	
	public int addComment(int userId, int postId, String userName, String content) {
		
		return commentDAO.insertComment(userId, postId, userName, content);
	}
	
	public List<Comment> getCommentListByPostId(int postId) {
		return commentDAO.selectCommentByPostId(postId);
	}
	
}
