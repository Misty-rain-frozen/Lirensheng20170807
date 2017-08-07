package com.example.fruitsfive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.example.fruitsfive.home.HomeFragment;
import com.example.fruitsfive.me.MeFragment;
import com.example.fruitsfive.shopping.ShoppingFragment;
import com.example.fruitsfive.type.TypeFragment;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bottom_bar)
    BottomTabBar tabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        tabBar.init(getSupportFragmentManager())
                .setChangeColor(0xff575653, 0xffe0e0e0)
                .addTabItem("首页", R.drawable.shouyexuan, R.drawable.shouyemeixuan, HomeFragment.class)
                .addTabItem("分类", R.drawable.fenleiyixuan, R.drawable.fenleimeixuan, TypeFragment.class)
                .addTabItem("购物车", R.drawable.gouwucheyixuan, R.drawable.gouwuchemeixuan, ShoppingFragment.class)
                .addTabItem("首页", R.drawable.wodeyixuan, R.drawable.wodemeixuan, MeFragment.class);
    }
}
