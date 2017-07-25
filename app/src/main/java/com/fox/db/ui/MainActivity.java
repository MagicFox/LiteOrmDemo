package com.fox.db.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fox.db.DBHelper;
import com.fox.db.R;
import com.fox.db.utils.AddressUtils;
import com.fox.db.model.AreaModel;
import com.fox.db.utils.GenericUtil;
import com.litesuits.orm.db.assit.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvCity;
    Button btnInit,btnGet;

    List<AreaModel> areaModel;

    QueryBuilder queryBuilder = new QueryBuilder(AreaModel.class).whereEquals("type", "2");//type=2代表省


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCity = (TextView) findViewById(R.id.tvCity);
        btnInit = (Button) findViewById(R.id.btnInit);
        btnGet = (Button) findViewById(R.id.btnGet);

        areaModel = DBHelper.getInstance().query(queryBuilder);
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(GenericUtil.isEmpty(areaModel)) {
                    AddressUtils.init();
                }
            }
        });
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                areaModel = DBHelper.getInstance().query(queryBuilder);
                if(!GenericUtil.isEmpty(areaModel)){
                    updateCity(areaModel.get(0));
                }
            }
        });

    }

    private void updateCity(AreaModel item){
        tvCity.setText(item.name);
    }

}
