package com.android.sugar.waterfall;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView mContentRv;

    private WaterfallAdapter mAdapter;
    /**
     * 垂直排列列数
     */
    private int mColumsCount = 3;
    /**
     * 显示数据源
     */
    private List<String> mDataSources = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignViews();

        initSource();

        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(mColumsCount,
                StaggeredGridLayoutManager.VERTICAL);
        ((StaggeredGridLayoutManager)layoutManager).setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, true);
        mContentRv.setLayoutManager(layoutManager);
        mAdapter = new WaterfallAdapter(this, mDataSources);
        mContentRv.setAdapter(mAdapter);
        mContentRv.setItemAnimator(new DefaultItemAnimator());
        mContentRv.setHasFixedSize(true);
    }

    private void assignViews() {
        mContentRv = (RecyclerView) findViewById(R.id.rv_main_content);
    }

//    private void initSource() {
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a1ec08fa513d2697fa44b40953fbb2fb4216d8cb.jpg");
//        mDataSources.add("http://d.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=d8c645729513b07ebde8580c39e7bd15" +
//                "/a8014c086e061d95294ff56b7df40ad162d9ca5c.jpg");
//        mDataSources.add("http://a.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=3757236433fae6cd0ce1a3653a832312" +
//                "/bd315c6034a85edf2dcd3c704f540923dd547524.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/50da81cb39dbb6fdc4b794a70824ab18962b3746.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/37d12f2eb9389b50a9794db98335e5dde6116e53.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/91529822720e0cf395f783a80c46f21fbe09aa65.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/242dd42a2834349b118764e3caea15ce37d3bed6.jpg");
//        mDataSources.add("http://pic67.nipic.com/file/20150514/21036787_181947848862_2.jpg");
//        mDataSources.add("http://b.hiphotos.baidu.com/zhidao/pic/item/7dd98d1001e9390190e87f187fec54e736d1962a.jpg");
//        mDataSources.add("http://img.qqtz.com/K2014/0614/20140614123823930.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/d52a2834349b033b5b349bfe16ce36d3d539bd51.jpg");
//        mDataSources.add("http://g.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=bfeab173c5cec3fd8b6baf71e3b8f809" +
//                "/2e2eb9389b504fc2d39afcbae3dde71191ef6d43.jpg");
//        mDataSources.add("http://b.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=6046b2f46509c93d07a706f3aa0dd4ea" +
//                "/4a36acaf2edda3ccd58840da03e93901203f92d8.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/4ec2d5628535e5dd773a631e73c6a7efcf1b62d9.jpg");
//        mDataSources.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1302/04/c0/17981969_1359970249171" +
//                ".jpg");
//        mDataSources.add("http://imga.mumayi.com/android/wallpaper/2012/01/21/sl_600_2012012105503827801816.jpg");
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a2cc7cd98d1001e972ed0b3fbe0e7bec54e79728.jpg");
//        mDataSources.add("http://f.hiphotos.baidu.com/zhidao/pic/item/9358d109b3de9c8264e023df6f81800a18d843dd.jpg");
//        mDataSources.add("http://mg.soupingguo.com/bizhi/big/10/133/531/10133531.jpg");
//        mDataSources.add("http://imgsrc.baidu" +
//                ".com/forum/w=580/sign=34f7ea61d443ad4ba62e46c8b2005a89/78e5fc039245d68839fba560a1c27d1ed31b2415.jpg");
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a1ec08fa513d2697fa44b40953fbb2fb4216d8cb.jpg");
//        mDataSources.add("http://d.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=d8c645729513b07ebde8580c39e7bd15" +
//                "/a8014c086e061d95294ff56b7df40ad162d9ca5c.jpg");
//        mDataSources.add("http://a.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=3757236433fae6cd0ce1a3653a832312" +
//                "/bd315c6034a85edf2dcd3c704f540923dd547524.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/50da81cb39dbb6fdc4b794a70824ab18962b3746.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/37d12f2eb9389b50a9794db98335e5dde6116e53.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/91529822720e0cf395f783a80c46f21fbe09aa65.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/242dd42a2834349b118764e3caea15ce37d3bed6.jpg");
//        mDataSources.add("http://pic67.nipic.com/file/20150514/21036787_181947848862_2.jpg");
//        mDataSources.add("http://b.hiphotos.baidu.com/zhidao/pic/item/7dd98d1001e9390190e87f187fec54e736d1962a.jpg");
//        mDataSources.add("http://img.qqtz.com/K2014/0614/20140614123823930.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/d52a2834349b033b5b349bfe16ce36d3d539bd51.jpg");
//        mDataSources.add("http://g.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=bfeab173c5cec3fd8b6baf71e3b8f809" +
//                "/2e2eb9389b504fc2d39afcbae3dde71191ef6d43.jpg");
//        mDataSources.add("http://b.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=6046b2f46509c93d07a706f3aa0dd4ea" +
//                "/4a36acaf2edda3ccd58840da03e93901203f92d8.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/4ec2d5628535e5dd773a631e73c6a7efcf1b62d9.jpg");
//        mDataSources.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1302/04/c0/17981969_1359970249171" +
//                ".jpg");
//        mDataSources.add("http://imga.mumayi.com/android/wallpaper/2012/01/21/sl_600_2012012105503827801816.jpg");
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a2cc7cd98d1001e972ed0b3fbe0e7bec54e79728.jpg");
//        mDataSources.add("http://f.hiphotos.baidu.com/zhidao/pic/item/9358d109b3de9c8264e023df6f81800a18d843dd.jpg");
//        mDataSources.add("http://mg.soupingguo.com/bizhi/big/10/133/531/10133531.jpg");
//        mDataSources.add("http://imgsrc.baidu" +
//                ".com/forum/w=580/sign=34f7ea61d443ad4ba62e46c8b2005a89/78e5fc039245d68839fba560a1c27d1ed31b2415.jpg");
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a1ec08fa513d2697fa44b40953fbb2fb4216d8cb.jpg");
//        mDataSources.add("http://d.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=d8c645729513b07ebde8580c39e7bd15" +
//                "/a8014c086e061d95294ff56b7df40ad162d9ca5c.jpg");
//        mDataSources.add("http://a.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=3757236433fae6cd0ce1a3653a832312" +
//                "/bd315c6034a85edf2dcd3c704f540923dd547524.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/50da81cb39dbb6fdc4b794a70824ab18962b3746.jpg");
//        mDataSources.add("http://g.hiphotos.baidu.com/zhidao/pic/item/37d12f2eb9389b50a9794db98335e5dde6116e53.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/91529822720e0cf395f783a80c46f21fbe09aa65.jpg");
//        mDataSources.add("http://c.hiphotos.baidu.com/zhidao/pic/item/242dd42a2834349b118764e3caea15ce37d3bed6.jpg");
//        mDataSources.add("http://pic67.nipic.com/file/20150514/21036787_181947848862_2.jpg");
//        mDataSources.add("http://b.hiphotos.baidu.com/zhidao/pic/item/7dd98d1001e9390190e87f187fec54e736d1962a.jpg");
//        mDataSources.add("http://img.qqtz.com/K2014/0614/20140614123823930.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/d52a2834349b033b5b349bfe16ce36d3d539bd51.jpg");
//        mDataSources.add("http://g.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=bfeab173c5cec3fd8b6baf71e3b8f809" +
//                "/2e2eb9389b504fc2d39afcbae3dde71191ef6d43.jpg");
//        mDataSources.add("http://b.hiphotos.baidu" +
//                ".com/zhidao/wh%3D450%2C600/sign=6046b2f46509c93d07a706f3aa0dd4ea" +
//                "/4a36acaf2edda3ccd58840da03e93901203f92d8.jpg");
//        mDataSources.add("http://a.hiphotos.baidu.com/zhidao/pic/item/4ec2d5628535e5dd773a631e73c6a7efcf1b62d9.jpg");
//        mDataSources.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1302/04/c0/17981969_1359970249171" +
//                ".jpg");
//        mDataSources.add("http://imga.mumayi.com/android/wallpaper/2012/01/21/sl_600_2012012105503827801816.jpg");
//        mDataSources.add("http://d.hiphotos.baidu.com/zhidao/pic/item/a2cc7cd98d1001e972ed0b3fbe0e7bec54e79728.jpg");
//        mDataSources.add("http://f.hiphotos.baidu.com/zhidao/pic/item/9358d109b3de9c8264e023df6f81800a18d843dd.jpg");
//        mDataSources.add("http://mg.soupingguo.com/bizhi/big/10/133/531/10133531.jpg");
//        mDataSources.add("http://imgsrc.baidu" +
//                ".com/forum/w=580/sign=34f7ea61d443ad4ba62e46c8b2005a89/78e5fc039245d68839fba560a1c27d1ed31b2415.jpg");
//    }

    private void initSource() {
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/4.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/5.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/6.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/7.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/8.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/9.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/10.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/11.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/12.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/13.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/4.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/5.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/6.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/7.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/8.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/9.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/10.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/11.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/12.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/13.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/4.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/5.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/6.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/7.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/8.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/9.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/10.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/11.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/12.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/13.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/4.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/5.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/6.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/7.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/8.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/9.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/10.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/11.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/12.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/13.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/4.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/5.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/6.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/7.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/8.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/9.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/10.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/11.jpeg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/12.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/13.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/1.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/2.jpg");
        mDataSources.add(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pics/3.jpg");
    }
}
