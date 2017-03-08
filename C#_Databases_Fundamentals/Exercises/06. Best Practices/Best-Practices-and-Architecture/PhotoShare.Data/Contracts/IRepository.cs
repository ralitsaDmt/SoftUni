
namespace PhotoShare.Data.Contracts
{
    using System;
    using System.Collections;
    using System.Collections.Generic;
    using System.Linq.Expressions;

    public interface IRepository<TEntity> where TEntity :class
    {
        void Add(TEntity entity);

        void AddRange(IEnumerable<TEntity> entities);

        void Delete(TEntity entity);

        void DeleteRange(IEnumerable<TEntity> entities);

        TEntity GetById(int id);

        IEnumerable<TEntity> Find(Expression<Func<TEntity, bool>> predicate);
    }
}
