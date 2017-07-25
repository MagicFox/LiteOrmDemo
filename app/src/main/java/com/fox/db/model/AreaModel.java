package com.fox.db.model;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by magicfox on 2017/7/25.
 */
public class AreaModel {
    @PrimaryKey(AssignType.BY_MYSELF)
    public String id;       //"id": "100001",当前地名对应的编号
    public String name;     //"name": "中国",
    public String type;     //"type": 1=国家；2=省份；3=市区；4=区域(县城)
    public String code;
    public String parentId; //"parentId": "0"  当前地名对应其所属地的Id


}
