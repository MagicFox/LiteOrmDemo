package com.fox.db.liteorm.entity;


import com.fox.db.liteorm.entity.base.BaseModel;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by MagicFox on 2016/12/21.
 */

@Table("WorkLogBean")
public class WorkLogBean extends BaseModel {
    public interface Properties{
        String taskId = "taskId";
    }
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private long id;
//    @Ignore
    private String taskId;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
