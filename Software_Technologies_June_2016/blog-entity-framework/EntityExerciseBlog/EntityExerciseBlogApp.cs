using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EntityExerciseBlog
{
    class EntityExerciseBlogApp
    {
        static void Main(string[] args)
        {
            EntityExerciseBlog db = new EntityExerciseBlog();

            var posts = db.Posts
                .Select(post => new
                {
                    Tags = post.Tags.Select(t => t.Name == "security"),

                }  
                )
                .ToList();


            //string targetTag = "it";

            //var tagIt = db.Tags.Single(t => t.Name == "it");

            //var posts = db.Posts
            //    .SelectMany(post => post.Tags, (post, tag) => new PostWithTagName{ PostID = post.Id, Body = post.Body, TagName = tag.Name }).ToList();
                       
            //foreach (var post in posts)
            //{
            //    if (post.TagName != "it")
            //    {
            //        Console.WriteLine("postId: {0}", post.PostID);
            //        Console.WriteLine("Posts body: {0}", post.Body);
            //        Console.WriteLine();
            //    }                
            //}


            //ListAllPosts(db);
            //ListAllUsers(users);
            //ListPostsWithTitleAndBody(db);
            //OrderUsersByUsername(db);
            //OrderUsersByUsernameAndFullname(db);
            //SelectAuthors(db);
            //JoinAuthorWithTitles(db);
            //SelectAuthorOfSpecificPost(db);
            //OrderAuthorsOfPosts(db);
            //CreateNewPost(db);
            //UpdateData(db);
            //DeleteComment(db);
            //DeletePost(db);
        }

        private static void DeletePost(EntityExerciseBlog db)
        {
            Posts postInfo = db.Posts
                .Single(p => p.Id == 22);

            db.Comments.RemoveRange(postInfo.Comments);
            postInfo.Tags.Clear();

            db.Posts.Remove(postInfo);
            db.SaveChanges();
        }

        private static void DeleteComment(EntityExerciseBlog db)
        {
            Comments commentInfo = db.Comments
                .Single(c => c.Id == 2);

            db.Comments.Remove(commentInfo);
            db.SaveChanges();
        }

        private static void UpdateData(EntityExerciseBlog db)
        {
            Users userInfo = db.Users.Single(user => user.FullName == "Teng Qingshan");
            string oldName = userInfo.FullName;

            userInfo.FullName = "Malkata Tenga";

            db.SaveChanges();
        }

        private static void CreateNewPost(EntityExerciseBlog db)
        {
            var post = new Posts
            {
                AuthorId = 2,
                Title = "Ne post from author 2",
                Body = "Something written from author 2",
                Date = DateTime.Now
            };

            db.Posts.Add(post);
            db.SaveChanges();
        }

        private static void OrderAuthorsOfPosts(EntityExerciseBlog db)
        {
            var users = db.Users.Select(user => new
            {
                Username = user.UserName,
                Fullname = user.FullName,
                postsCount = user.Posts.Count(),
                id = user.Id
            })
            .Where(user => user.postsCount > 0)
            .OrderByDescending(user => user.id)
            .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.Fullname);
                Console.WriteLine("Full name: {0}", user.Username);
                Console.WriteLine();
            }
        }

        private static void SelectAuthorOfSpecificPost(EntityExerciseBlog db)
        {
            var author = db.Users
                            .SelectMany(user => user.Posts, (user, post) => new { user.UserName, user.FullName, post.Id })
                            .Single(post => post.Id == 4);

            Console.WriteLine("Username: {0}", author.UserName);
            Console.WriteLine("Posts Title: {0}", author.FullName);
            Console.WriteLine();
        }   

        private static void JoinAuthorWithTitles(EntityExerciseBlog db)
        {
            var users = db.Users
                            .SelectMany(user => user.Posts, (user, post) => new { user.UserName, post.Title });

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Posts Title: {0}", user.Title);
                Console.WriteLine();
            }
        }

        private static void SelectAuthors(EntityExerciseBlog db)
        {
            List<Users> users = db.Users.Select(user => user)
                            .Where(user => user.Posts.Count > 0)
                            .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full name: {0}", user.FullName);
                Console.WriteLine("Posts count: {0}", user.Posts.Count());
                Console.WriteLine();
            }
        }

        private static void OrderUsersByUsernameAndFullname(EntityExerciseBlog db)
        {
            var users = db.Users.Select(p => new
            {
                p.UserName,
                p.FullName
            })
                        .OrderByDescending(user => user.UserName)
                        .ThenByDescending(user => user.FullName)
                        .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full name: {0}", user.FullName);

                Console.WriteLine();
            }
        }

        private static void OrderUsersByUsername(EntityExerciseBlog db)
        {
            var users = db.Users.Select(p => new
            {
                p.UserName,
                p.FullName
            })
                        .OrderBy(user => user.UserName).ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Username: {0}", user.UserName);
                Console.WriteLine("Full name: {0}", user.FullName);

                Console.WriteLine();
            }
        }

        private static void ListPostsWithTitleAndBody(EntityExerciseBlog db)
        {
            var posts = db.Posts.Select(p => new
            {
                p.Title,
                p.Body
            }).ToList();

            foreach (var post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("Content: {0}", post.Body);

                Console.WriteLine();
            }
        }

        private static void ListAllUsers(EntityExerciseBlog db)
        {
            var users = db.Users.Select(user => new
            {
                ID = user.Id,
                Name = user.FullName,
                CommentsCount = user.Comments.Count(),
                PostsCount = user.Posts.Count()
            })
            .ToList();

            foreach (var user in users)
            {
                Console.WriteLine("Id: {0}", user.ID);
                Console.WriteLine("Name: {0}", user.Name);
                Console.WriteLine("Comments count: {0}", user.CommentsCount);
                Console.WriteLine("Posts count: {0}", user.PostsCount);
                Console.WriteLine();
            }
        }

        private static void ListAllPosts(EntityExerciseBlog db)
        {
            List<Posts> posts = db.Posts.Select(post => post).ToList();

            foreach (Posts post in posts)
            {
                Console.WriteLine("Title: {0}", post.Title);
                Console.WriteLine("AuthorID: {0}", post.Id);
                Console.WriteLine("Comments count: {0}", post.Comments.Count());
                Console.WriteLine("Tags count: {0}", post.Tags.Count());
                Console.WriteLine();
            }
        }
    }
}