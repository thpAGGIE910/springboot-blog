package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostsController {

    @GetMapping("/posts")
    public String viewAllPosts(Model viewModel) {
        ArrayList<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        Post post2 = new Post();

        post1.setTitle("Post 1");
        post2.setTitle("Post 2");

        post1.setBody("Example body for post 1.");
        post2.setBody("Example body for post 2.");

        posts.add(post1);
        posts.add(post2);

        viewModel.addAttribute("posts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String getPostDetails(@PathVariable long id, Model viewModel) {
        Post post = new Post();
        post.setTitle("Example Post");
        post.setBody("This is the body of the example post");
        viewModel.addAttribute("post", post);

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreatePostForm() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost() {
        return "create a new post";
    }
}
