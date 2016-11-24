function attachEvents() {

    const kinveyAppId = "kid_H1XhKcxzl";
    const serviceUrl = "https://baas.kinvey.com/appdata/" + kinveyAppId;
    const kinveyUsername = "peter";
    const kinveyPassword = "p";
    const base64auth = btoa(kinveyUsername + ":" + kinveyPassword);
    const authHeaders = { "Authorization": "Basic " + base64auth };

    $('#btnLoadPosts').click(loadPosts);
    $('#btnViewPost').click(viewPosts);
    
    function loadPosts() {

        let postsRequest = {
            url: serviceUrl + "/posts",
            headers: authHeaders
        };

        $.get(postsRequest)
            .then(displayPosts)
            .catch(displayError);
    }
    
    function viewPosts() {
        let selectedPostId = $('#posts').val();
        if (!selectedPostId){
            return;
        }

        let requestPosts = $.ajax({
            url: serviceUrl + "/posts/" + selectedPostId,
            headers: authHeaders });
        let requestComments = $.ajax({ url: serviceUrl + `/comments/?query={"post_id":"${selectedPostId}"}`,
            headers: authHeaders });

        Promise.all([requestPosts, requestComments])
            .then(displayPostsWithComments)
            .catch(displayError);
    }

    function displayPostsWithComments([post, comments]) {
        $('#post-title').text(post.title);
        $('#post-body').text(post.body);
        $('#post-comments').empty();

        for (let comment of comments){
            let commentItem = $("<li>")
                .text(comment.text);
            $("#post-comments").append(commentItem);
        }
    }
    
    function displayPosts(posts) {
        $('#posts').empty();

        for (let post of posts){
            let option = $('<option>')
                .text(post.title)
                .val(post._id);

            $('#posts').append(option);
        }
    }

    function displayError(err) {
        let errorDiv = $('<div>').text("Error: " + err.status + '(' + err.statusText + ')');
        $(document.body).prepend(errorDiv);
        setTimeout(function () {
            $(errorDiv).fadeOut(function () {
                $(errorDiv).remove();
            });
        }, 3000);
    }
}