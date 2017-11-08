$(document).ready(function () {
        $(".btn-danger").click(function (evt) {
                evt.preventDefault();
                deleteUrl = $(this).parent().attr('action');
                if(confirm("Are you sure you want to delete this post?")) {
                    $.post(deleteUrl).done(function() {
                        window.location.replace('/posts');
                    });
                }
            }
        );
    }
);