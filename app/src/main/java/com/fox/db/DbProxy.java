package com.fox.db;


import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.Collection;
import java.util.List;

/**
 * Created by MagicFox on 2016/12/20.
 */

public interface DbProxy {
    <T> long insert(T entity);

    <T> int insert(Collection<T> var1);

    <T> void update(T entity);

    <T> List<T> query(Class<T> entity);

    <T> void delete(T entity);

    int delete(WhereBuilder var1);

    <T> List<T> query(QueryBuilder<T> builder);

    <T>T queryUnique(QueryBuilder<T> builder);

    <T>T queryById(Class<T> entity, String id);
}
