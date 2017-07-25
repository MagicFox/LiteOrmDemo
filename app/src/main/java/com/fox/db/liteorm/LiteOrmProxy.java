package com.fox.db.liteorm;


import com.fox.db.DbProxy;
import com.fox.db.utils.GenericUtil;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.Collection;
import java.util.List;

/**
 * Created by MagicFox on 2016/12/20.
 */

public class LiteOrmProxy implements DbProxy {

    @Override
    public <T> long insert(T entity) {
        return LiteOrmHelper.getInstance().getLiteOrm().insert(entity);
    }

    @Override
    public <T> int insert(Collection<T> var1) {
        return LiteOrmHelper.getInstance().getLiteOrm().insert(var1);
    }

    @Override
    public <T> void update(T entity) {
        LiteOrmHelper.getInstance().getLiteOrm().update(entity);
    }

    @Override
    public <T> List<T> query(Class<T> entity) {
        return LiteOrmHelper.getInstance().getLiteOrm().query(entity);
    }

    @Override
    public <T> void delete(T entity) {
        LiteOrmHelper.getInstance().getLiteOrm().delete(entity);
    }

    @Override
    public int delete(WhereBuilder var1) {
        return LiteOrmHelper.getInstance().getLiteOrm().delete(var1);
    }

    @Override
    public <T> List<T> query(QueryBuilder<T> builder) {
        return LiteOrmHelper.getInstance().getLiteOrm().query(builder);
    }

    @Override
    public <T> T queryUnique(QueryBuilder<T> builder) {
        List<T> list = query(builder);
        return GenericUtil.isEmpty(list)?null:list.get(0);
    }

    @Override
    public <T> T queryById(Class<T> entity,String id) {
        return LiteOrmHelper.getInstance().getLiteOrm().queryById(id,entity);
    }

}
