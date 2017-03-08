namespace PhotoShare.Data
{
    using Contracts;
    using Models;
    using Repositories;

    public class UnitOfWork : IUnitOfWork
    {
        private readonly PhotoShareContext context;

        public UnitOfWork()
        {
            this.context = new PhotoShareContext();
        }

        private IRepository<Album> albums;

        private IRepository<AlbumRole> albumRoles;

        private IRepository<Picture> pictures;
        
        private IRepository<Tag> tags;

        private IRepository<Town> towns;

        private IRepository<User> users;

        public IRepository<Album> Albums
        {
            get { return this.albums ?? (this.albums = new PhotoShareRepository<Album>(this.context)); }
        }

        public IRepository<AlbumRole> AlbumRoles
        {
            get
            {
                return this.albumRoles ?? (this.albumRoles = new PhotoShareRepository<AlbumRole>(this.context));
            }
        }

        public IRepository<Picture> Pictures
        {
            get { return this.pictures ?? (this.pictures = new PhotoShareRepository<Picture>(this.context)); }
        }

        public IRepository<Tag> Tags
        {
            get
            {
                return this.tags ?? (this.tags = new PhotoShareRepository<Tag>(this.context));
            }
        }

        public IRepository<Town> Towns
        {
            get { return this.towns ?? (this.towns = new PhotoShareRepository<Town>(this.context)); }
        }

        public IRepository<User> Users
        {
            get { return this.users ?? (this.users = new PhotoShareRepository<User>(this.context)); }
        }

        public void Save()
        {
            this.context.SaveChanges();
        }
    }
}
