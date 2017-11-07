package com.codeup.blog.services;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {
    private PostsRepository postsDao;

    @Autowired
    public PostSvc(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    public List<Post> findAll() {
        return (List<Post>) postsDao.findAll();
    }

    public Post save(Post post) {
        return postsDao.save(post);
    }

    public Post findOne(long id) {
        return postsDao.findOne(id);
    }

    public void delete(long id) {
        postsDao.delete(id);
    }
}
