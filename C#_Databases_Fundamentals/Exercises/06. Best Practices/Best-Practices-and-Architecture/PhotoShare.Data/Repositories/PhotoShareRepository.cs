namespace PhotoShare.Data.Repositories
{
    using System;
    using System.Collections.Generic;
    using System.Linq;
    using System.Linq.Expressions;
    using Contracts;
    public class PhotoShareRepository<TEntity> : IRepository<TEntity> where TEntity : class
    {
        protected readonly PhotoShareContext Context;

        public PhotoShareRepository(PhotoShareContext context)
        {
            this.Context = context;
        }

        public void Add(TEntity entity)
        {
            this.Context.Set<TEntity>().Add(entity);
        }

        public void AddRange(IEnumerable<TEntity> entities)
        {
            foreach (TEntity entity in entities)
            {
                this.Context.Set<TEntity>().Add(entity);
            }
        }

        public void Delete(TEntity entity)
        {
            this.Context.Set<TEntity>().Remove(entity);
        }

        public void DeleteRange(IEnumerable<TEntity> entities)
        {
            foreach (TEntity entity in entities)
            {
                this.Context.Set<TEntity>().Remove(entity);
            }
        }

        public TEntity GetById(int id)
        {
            return this.Context.Set<TEntity>().Find(id);
        }

        public IEnumerable<TEntity> Find(Expression<Func<TEntity, bool>> predicate)
        {
            return this.Context.Set<TEntity>().Where(predicate);
        }
    }
}
