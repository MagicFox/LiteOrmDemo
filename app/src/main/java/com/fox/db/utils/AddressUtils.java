package com.fox.db.utils;

import android.content.res.AssetManager;
import android.util.Log;

import com.fox.db.DBHelper;
import com.fox.db.common.CommonApplication;
import com.fox.db.model.AreaModel;
import com.fox.db.model.ResponseResult;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by magicfox on 2017/7/25.
 */

public class AddressUtils {

    public static void init(){
        ResponseResult<List<AreaModel>> result= JsonUtil.fromJson(getJson("provinc_city_are.json"),new TypeToken<ResponseResult<List<AreaModel>>>(){}.getType());
        if(result == null || GenericUtil.isEmpty(result.detail)){
            return;
        }
        Observable.just(result.detail)
                .observeOn(Schedulers.io())
                .subscribe(models -> {
                    long start = System.currentTimeMillis();
                    int count = DBHelper.getInstance().insert(result.detail);
                    long end = System.currentTimeMillis();
                    Log.d("______",String.format("省市区保存成功%s条",count));
                    if (count != -1) {//查看是否插入成功
                        Log.d("______","insertTime:" + (end - start) + "   insertCount:" + count);
                    }
                });
    }

    private static String getJson(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            AssetManager assetManager = CommonApplication.getInstance().getAssets();
            bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open(fileName)));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuilder.toString();
    }

}
