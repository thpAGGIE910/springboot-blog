package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;

import com.codeup.blog.repositories.UsersRepository;
import com.codeup.blog.services.PostSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class PostsController {
    private final PostSvc postsSvc;
    private UsersRepository users;

    @Autowired
    public PostsController(PostSvc postsSvc, UsersRepository users) {
        this.postsSvc = postsSvc;
        this.users = users;
    }

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        viewModel.addAttribute("posts", postsSvc.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostDetails(@PathVariable long id, Model viewModel) {
        try {
            viewModel.addAttribute("post", postsSvc.findOne(id));
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
    public String createNewPost(@Valid Post post, Errors validation, Model viewModel) {
        if(validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("post", post);
            return "posts/create";
        }
        post.setUser(users.findOne(1L));
        postsSvc.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showUpdatePostForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postsSvc.findOne(id));
        return "posts/create";
    }

    @PostMapping("/posts/{id}/edit")
    public String updateExistingPost(@PathVariable long id, @Valid Post post, Errors validation, Model viewModel) {
        if(validation.hasErrors()) {
            viewModel.addAttribute("errors", validation);
            viewModel.addAttribute("post", post);
            return "posts/create";
        }
        post.setUser(users.findOne(1L));
        postsSvc.save(post);
        return String.format("redirect:/posts/%s", id);
    }

    @PostMapping("/posts/{id}/delete")
    @ResponseBody
    public String deleteExistingPost(@PathVariable long id) {
        postsSvc.delete(id);
        return "Post deleted";
    }
}
