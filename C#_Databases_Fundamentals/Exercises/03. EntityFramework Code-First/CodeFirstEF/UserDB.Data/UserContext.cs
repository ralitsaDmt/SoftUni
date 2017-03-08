namespace UserDB.Data
{
    using System;
    using System.Data.Entity;
    using System.Linq;
    using Models;

    public class UserContext : DbContext
    {
        public UserContext()
            : base("name=UserContext")
        {
        }

        public virtual IDbSet<User> Users { get; set; }

        public virtual IDbSet<Town> Towns { get; set; }

        public virtual IDbSet<Album> Albums { get; set; }

        public virtual IDbSet<Picture> Pictures { get; set; }

        public virtual IDbSet<Tag> Tags { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<User>()
                .HasMany(u => u.Friends)
                .WithMany();

            modelBuilder.Entity<Album>()
                .HasMany(a => a.Viewers)
                .WithMany(v => v.AlbumsViewer)
                .Map(m =>
                {
                    m.MapLeftKey("AlbumId");
                    m.MapRightKey("OwnerId");
                    m.ToTable("AlbumViewers");
                });
        }
    }
}