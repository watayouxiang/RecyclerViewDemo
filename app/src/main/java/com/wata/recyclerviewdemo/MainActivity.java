package com.wata.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.wata.recyclerviewdemo.adapter.GridAdapter;
import com.wata.recyclerviewdemo.adapter.ListAdapter;
import com.wata.recyclerviewdemo.adapter.StaggeredAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecycleView = findViewById(R.id.recycle_view);
        loadListData(false, true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //list
        if (id == R.id.action_list_normal) {
            loadListData(false, true);
            return true;
        } else if (id == R.id.action_list_vertical_reverse) {
            loadListData(true, true);
            return true;
        } else if (id == R.id.action_list_horizontal) {
            loadListData(false, false);
            return true;
        } else if (id == R.id.action_list_horizontal_reverse) {
            loadListData(true, false);
            return true;
        }

        //grid
        else if (id == R.id.action_grid_normal) {
            loadGridData(false, true);
            return true;
        } else if (id == R.id.action_grid_vertical_reverse) {
            loadGridData(true, true);
            return true;
        } else if (id == R.id.action_grid_horizontal) {
            loadGridData(false, false);
            return true;
        } else if (id == R.id.action_grid_horizontal_reverse) {
            loadGridData(true, false);
            return true;
        }

        //staggered
        else if (id == R.id.action_staggered_normal) {
            loadStaggeredData(false, true);
            return true;
        } else if (id == R.id.action_staggered_vertical_reverse) {
            loadStaggeredData(true, true);
            return true;
        } else if (id == R.id.action_staggered_horizontal) {
            loadStaggeredData(false, false);
            return true;
        } else if (id == R.id.action_staggered_horizontal_reverse) {
            loadStaggeredData(true, false);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 列表
     *
     * @param reverse
     * @param vertical
     */
    private void loadListData(boolean reverse, boolean vertical) {
        // 设置布局管理器
        mRecycleView.setLayoutManager(new LinearLayoutManager(
                this,
                vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL,//方向
                reverse//是否反向
        ));
        // 设置RecycleView的Item间分割线
        mRecycleView.addItemDecoration(new MyItemDecoration(this, MyItemDecoration.HORIZONTAL_LIST));
        // 设置适配器
        mRecycleView.setAdapter(new ListAdapter(this, DataProvider.getTestData()));
    }

    /**
     * 表格
     *
     * @param reverse
     * @param vertical
     */
    private void loadGridData(boolean reverse, boolean vertical) {
        // 设置布局管理器
        mRecycleView.setLayoutManager(new GridLayoutManager(
                this,
                2, //列数
                vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL,//方向
                reverse//是否反向
        ));
        // 设置适配器
        mRecycleView.setAdapter(new GridAdapter(this, DataProvider.getTestData()));
    }

    /**
     * 瀑布流
     *
     * @param reverse
     * @param vertical
     */
    private void loadStaggeredData(boolean reverse, boolean vertical) {
        // 设置布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(
                2, //列数
                vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL//方向
        );
        layoutManager.setReverseLayout(reverse);//是否反向
        mRecycleView.setLayoutManager(layoutManager);
        // 设置适配器
        mRecycleView.setAdapter(new StaggeredAdapter(this, DataProvider.getTestData()));
    }
}
