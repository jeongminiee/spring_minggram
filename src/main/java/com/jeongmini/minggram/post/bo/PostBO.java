package com.jeongmini.minggram.post.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jeongmini.minggram.common.FileManagerService;
import com.jeongmini.minggram.post.dao.PostDAO;

@Service
public class PostBO {
	@Autowired
	private PostDAO postDAO;
	
	public int addPost(int userId, String userName, String content, MultipartFile file) {
		FileManagerService fileManager = new FileManagerService();
		
		String filePath = fileManager.saveFile(userId, file);
		if(filePath == null) {
			return -1;
		}
		
		return postDAO.insertPost(userId, userName, content, filePath);
	}

}
