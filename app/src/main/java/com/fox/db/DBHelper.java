package com.fox.db;


import com.fox.db.liteorm.LiteOrmProxy;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;

import java.util.Collection;
import java.util.List;

/**
 * Created by MagicFox on 2016/11/24.
 */
public class DBHelper implements DbProxy{
    DbProxy proxy;
    static volatile DBHelper instance;
    private DBHelper(){
        this.proxy = new LiteOrmProxy();
    }

    public static DBHelper getInstance(){
        if(instance == null){
            synchronized (DBHelper.class){
                if(instance == null){
                    instance = new DBHelper();
                }
            }
        }
        return instance;
    }

    public <T> long insert(T t){
        return proxy.insert(t);
    }

    @Override
    public <T> int insert(Collection<T> var1) {
        return proxy.insert(var1);
    }

    public <T> void update(T t){
        proxy.update(t);
    }

    public <T> List<T> query(Class<T> entity){
        return proxy.query(entity);
    }

    public <T> void delete(T t){
        proxy.delete(t);
    }

    @Override
    public int delete(WhereBuilder var1) {
        return proxy.delete(var1);
    }


    @Override
    public <T> List<T> query(QueryBuilder<T> builder) {
        return proxy.query(builder);
    }

    @Override
    public <T> T queryUnique(QueryBuilder<T> builder) {
        return proxy.queryUnique(builder);
    }

    @Override
    public <T> T queryById(Class<T> entity, String id) {
        return proxy.queryById(entity,id);
    }

}
