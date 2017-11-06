package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("postSvc")
public class PostSvc {
    private List<Post> posts;

    public PostSvc() {
        posts = new ArrayList<>();
        createPosts();
    }

    public List<Post> findAll() {
        return posts;
    }

    public Post save(Post post) {
        post.setId(posts.size() + 1);
        posts.add(post);
        return post;
    }

    public Post findOne(long id) {
        return posts.get((int)(id - 1));
    }

    private void createPosts() {
        save(new Post(
                "Post 1",
                "Maecenas vitae aliquet libero. Mauris maximus sapien ac aliquam auctor. In pretium felis sapien, et aliquam lorem commodo ac. Donec aliquam dolor ac elit vehicula tincidunt. Vestibulum sodales neque quis nibh dapibus venenatis. Nulla facilisi. Curabitur fermentum, sapien eget ultrices venenatis, lacus risus auctor lorem, in fringilla risus nunc in dui."
        ));

        save(new Post(
                "Post 2",

                "Sed magna odio, varius nec arcu quis, tristique finibus justo. Nullam imperdiet, orci vel malesuada ullamcorper, nisl tortor hendrerit elit, ut tincidunt dui mauris eget dolor. Phasellus venenatis lacus nec arcu rutrum, quis tempus risus bibendum. Mauris egestas tempor magna id convallis. Proin non vestibulum justo. Nulla mollis lectus metus. Integer id metus enim. Suspendisse et lacus a diam faucibus rhoncus."
        ));

        save(new Post(
                "Post 3",
                "Phasellus sed elit viverra, tincidunt nulla id, tempus libero. Praesent rutrum, mauris non tristique tempus, lectus nunc aliquam sapien, sed cursus felis purus ac ex. Mauris risus mauris, pretium elementum massa vel, vehicula viverra sem. Nunc commodo ipsum eu lacus hendrerit convallis. Fusce euismod sed velit nec sollicitudin. Vestibulum auctor velit sed quam vestibulum, nec porttitor ex placerat. Pellentesque congue, metus vel tincidunt vehicula, diam ipsum laoreet purus, quis porttitor ligula urna et lectus."
        ));
    }
}
