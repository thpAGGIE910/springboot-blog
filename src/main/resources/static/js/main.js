$(document).ready(function () {
        $("#delete-btn").click(function (evt) {
                evt.preventDefault();
                deleteUrl = $(this).getAttribute('href');
                if(confirm("Are you sure you want to delete this post?")) {
                    window.location.replace(deleteUrl);
                }
            }
        );
    }
);