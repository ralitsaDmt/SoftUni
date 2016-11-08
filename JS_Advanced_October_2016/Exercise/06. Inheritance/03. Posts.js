function result() {
    class Post{
        constructor(title, content){
            this.title = title;
            this.content = content;
        }

        toString(){
            return `Post: ${this.title}\nContent: ${this.content}`;
        }
    }

    class SocialMediaPost extends Post{
        constructor(title, content, likes, dislikes){
            super(title, content);
            this.likes = Number(likes);
            this.dislikes = Number(dislikes);
            this.comments = [];
        }

        addComment(comment){
            if (comment.length > 0){
                this.comments.push(comment);
            }
        }

        toString(){
            let extendedString = `Post: ${this.title}\n`;
            extendedString += `Content: ${this.content}\n`;
            extendedString += `Rating: ${this.likes - this.dislikes}`;

            if (this.comments.length !== 0){
                extendedString += `\nComments:\n`;
                extendedString += ` * ${this.comments.join('\n * ')}`;
            }

            return extendedString;
        }
    }

    class BlogPost extends Post{
        constructor(title, content, views){
            super(title, content);
            this.views = Number(views);
        }
        //
        // view(){
        //     this.views += 1;
        //     let that = this;
        //     return function () {
        //         return that.view();
        //     };
        // }
        //
        view(){
            this.views += 1;
            return () => this.view();
        }

        // view(){
        //     this.views += 1;
        // }

        toString(){
            let extendedString = `Post: ${this.title}\n`;
            extendedString += `Content: ${this.content}\n`;
            extendedString += `Views: ${this.views}`;

            return extendedString;
        }
    }

    return {Post, SocialMediaPost, BlogPost}
}

let solve = result();

let post = new solve.Post("Post", "Content");

console.log(post.toString());

// Post: Post
// Content: Content

let scm = new solve.SocialMediaPost("TestTitle", "TestContent", 25, 30);

scm.addComment("Good post");
scm.addComment("Very good post");
scm.addComment("Wow!");

console.log(scm.toString());

// Post: TestTitle
// Content: TestContent
// Rating: -5
// Comments:
//  * Good post
//  * Very good post
//  * Wow!

let blp = new solve.BlogPost("Blog post Title", "Blog post content", 8);
blp.view()()();

console.log(blp.toString());

