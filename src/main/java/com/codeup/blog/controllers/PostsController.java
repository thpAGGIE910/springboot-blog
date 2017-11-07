package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostsController {
    private final PostsRepository postsDao;

    @Autowired
    public PostsController(PostsRepository postsDao) {
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        viewModel.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostDetails(@PathVariable long id, Model viewModel) {
        try {
            viewModel.addAttribute("post", postsDao.findOne(id));
            return "posts/show";
        } catch (IndexOutOfBoundsException e) {
            viewModel.addAttribute("error", String.format("Post with id %s does not exist!", id));
            return "posts/index";
        }
    }

    @GetMapping("/posts/create")
    public String showCreatePostForm(Model viewModel) {
        viewModel.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createNewPost(@ModelAttribute Post post) {
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showUpdatePostForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postsDao.findOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    public String updateExistingPost(@PathVariable long id, @ModelAttribute Post post) {
        postsDao.save(post);
        return "redirect:/posts";
    }
}
