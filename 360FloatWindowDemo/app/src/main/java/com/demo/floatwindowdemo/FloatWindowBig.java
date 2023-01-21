package com.demo.floatwindowdemo;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Author:pdm on 2016/10/12
 * Email:aiyh0202@163.com
 */
public class FloatWindowBig extends LinearLayout {
    /**
     * 记录大悬浮窗的宽度
     */
    public static int viewWidth;

    /**
     * 记录大悬浮窗的高度
     */
    public static int viewHeight;
    public Logger log = Logger.getLogger("FloatWindowBig");

    public FloatWindowBig(final Context context) {
        super(context);

        LayoutInflater.from(context).inflate(R.layout.float_window_big, this);
//init
        View view = findViewById(R.id.sv);

        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (Data.map != null && !Data.map.isEmpty()) {
                    ChangeVisibility(context, Data.map, View.GONE);
                }
                int radioId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(radioId);
                String pos = (String) radioButton.getTag();
                int p = Integer.parseInt(pos);
                log.info(String.format("radio id:%d", p));
                Data.map = Data.enMaps[p];
                ChangeVisibility(context, Data.map, View.VISIBLE);


            }
        });
//        Spinner spinner = (Spinner) findViewById(R.id.spinner);//初始化控件
//        String [] items={"1","2"};
//        ArrayAdapter<String> adapter=new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item,items);
//        spinner.setAdapter(adapter);
//        List<String> list1 = Arrays.stream(Data.cnMaps).collect(Collectors.toList());

//        ArrayAdapter<String>adapter= new ArrayAdapter<String>(context,R.layout.simple_spinner_item,list1);
        //建立Adapter并且绑定数据源

        //第一个参数表示在哪个Activity上显示，第二个参数是系统下拉框的样式，第三个参数是数组
//        spinner.setAdapter(adapter);//绑定Adapter到控件
        //获取地图名称
//不给vp设置高度是显示不出来的……
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        List<ImageView> list = new ArrayList<>();
//        ImageView v1=new ImageView(context);
//        v1.setImageResource(R.drawable.ic_launcher);
//        list.add(v1);
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(context, list);
        viewPager.setAdapter(pagerAdapter);


        //屠夫table layout name


        TextView close = (TextView) findViewById(R.id.close);

        TextView back = (TextView) findViewById(R.id.back);
        TextView human = (TextView) findViewById(R.id.human);
        TextView killer = (TextView) findViewById(R.id.killer);
        TextView ysf = (TextView) findViewById(R.id.ysf);
        TextView cellar = (TextView) findViewById(R.id.cellar);

        close.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击关闭悬浮窗的时候，移除所有悬浮窗，并停止Service
                FloatWindowManager.removeBigWindow(context);
                FloatWindowManager.removeSmallWindow(context);
                Intent intent = new Intent(getContext(), FloatWindowService.class);
                context.stopService(intent);
            }
        });
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击返回的时候，移除大悬浮窗，创建小悬浮窗
                FloatWindowManager.removeBigWindow(context);
                FloatWindowManager.createSmallWindow(context);
            }
        });

        human.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                LinkedList<String> checked = getChecked(context, Data.map, Data.H);
                //collectionutil没有不得不使用retainall,有个大坑，
                // 如果两个set一模一样，返回false 最好不要选四个
                // 避免侵入式

                try {
                    Class clz = Class.forName("com.demo.floatwindowdemo.Data");
                    Field field = clz.getField(Data.map);
                    String[] s = (String[]) field.get(null);
                    Data.possibleMaps=new ArrayList<>();
                    //i 刷点名称
                    for (int i = 0; i < s.length; i++) {

                        Field f = clz.getField(Data.map + "_" + s[i]);
                        String[] humanBorn = (String[]) f.get(null);
                        List<String> list = Arrays.stream(humanBorn).collect(Collectors.toList());
                        list.retainAll(checked);
                        if (list.isEmpty()) {
                            log.info(String.format("%s no match",s[i]));
//                            Toast.makeText(context, "no match", Toast.LENGTH_LONG).show();
                        } else if(list.size()>1){
                            Data.possibleMaps.add(s[i]);
                        }
                    }
                    Toast.makeText(context, "屠夫位置:" + Data.possibleMaps.toString(), Toast.LENGTH_LONG).show();
                    List<ImageView> list = new ArrayList<>();
                    AssetManager assetManager= context.getAssets();
                    for (int j = 0; j < Data.possibleMaps.size(); j++) {
                        InputStream is = null;
                        String filename = Data.possibleMaps.get(j);
                        is = assetManager.open(String.format("dwrg_maps/%s/%s.png", Data.map, filename));
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        //TODO 判空
                        ImageView imageView = new ImageView(context);
                        imageView.setImageBitmap(bitmap);
                        list.add(imageView);
                    }
                    pagerAdapter.setData(list);
//                    viewPager.setVisibility(View.VISIBLE);
                   viewPager.getAdapter().notifyDataSetChanged();

                    //不知道多次设置会不会出问题
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        killer.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<ImageView> list = new ArrayList<>();
                    LinkedList<String> checked = getChecked(context, Data.map, Data.K);
                    String name = checked.getFirst();
                    InputStream is = null;
                    is = getResources().getAssets().open(String.format("dwrg_maps/%s/%s.png", Data.map, name));

                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    //TODO 判空
                    ImageView imageView = new ImageView(context);
                    imageView.setImageBitmap(bitmap);
                    list.add(imageView);
                    pagerAdapter.setData(list);
                    viewPager.setVisibility(View.VISIBLE);
                    pagerAdapter.notifyDataSetChanged();
                    Toast.makeText(context, "success", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        ysf.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "暂不支持", Toast.LENGTH_LONG).show();
            }
        });
        cellar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "暂不支持", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void ChangeVisibility(Context context, String map, int state) {

        String killerTable = map + Data.K;
        String humanTable = map + Data.H;
        log.info(String.format("set %s %s %d", killerTable, humanTable, state));
        int kId = getResources().getIdentifier(killerTable, "id", context.getPackageName());
        int hId = getResources().getIdentifier(humanTable, "id", context.getPackageName());

        TableLayout killerTL = (TableLayout) findViewById(kId);
        killerTL.setVisibility(state);
        TableLayout humanTL = (TableLayout) findViewById(hId);
        humanTL.setVisibility(state);
    }

    public TableLayout getTableLayout(Context context, String map, String type) {
        String tableName = map + type;

        int tableId = getResources().getIdentifier(tableName, "id", context.getPackageName());
        TableLayout tl = (TableLayout) findViewById(tableId);
        return tl;
    }

    public LinkedList<String> getChecked(Context context, String map, String state) {
        /** state must be DATA.K or DATA.H **/
        LinkedList<String> checked = new LinkedList<>();
        TableLayout table = getTableLayout(context, map, state);
        for (int i = 0; i < table.getChildCount(); i++) {
            View parentRow = table.getChildAt(i);
            if (parentRow instanceof TableRow) {
                for (int j = 0; j < ((TableRow) parentRow).getChildCount(); j++) {
                    CheckBox cb = (CheckBox) ((TableRow) parentRow).getChildAt(j);
                    if (cb.isChecked()) {
                        if(state==Data.K){
                            checked.add(cb.getTag().toString());
                        }else{

                            checked.add(cb.getText().toString());
                        }

                    }
                }
            }

        }
        return checked;

    }




}

//
//
//    public int getId(String name){
//        Resources res=getResources();
//
//        //return res.getIdentifier(name,null,null);//带上地址 例如 包:type/name           (org.anjoy.act:drawable/ic)
//
//        return res.getIdentifier(name,"drawable",getPackageName());//名称例如 ic
//
//    }

//
//    public String getName(int id){
//        Resources res=getResources();
//        return res.getResourceEntryName(id);//得到的是 name
//        //return res.getResourceName(id);//得到的是 包/type/name
//    }