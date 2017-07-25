package com.fox.db.liteorm;

import com.fox.db.common.CommonApplication;
import com.fox.db.common.Constant;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.DataBaseConfig;


/**
 * Created by MagicFox on 2016/12/20.
 */

public class LiteOrmHelper {
    private LiteOrm liteOrm;
    private volatile static LiteOrmHelper instance;
    private LiteOrmHelper(){
        DataBaseConfig config = new DataBaseConfig(CommonApplication.getInstance(), Constant.LITE_ORM_DB_NAME);
        config.debugged = Constant.isDebug;
        config.dbVersion = Constant.DB_VERSION;
        config.onUpdateListener = null;
        liteOrm = LiteOrm.newSingleInstance(config);
    }

    public LiteOrm getLiteOrm(){
        return liteOrm;
    }

    public static LiteOrmHelper getInstance(){
        if(instance == null){
            synchronized (LiteOrmHelper.class){
                if(instance == null){
                    instance = new LiteOrmHelper();
                }
            }
        }
        return instance;
    }

}
