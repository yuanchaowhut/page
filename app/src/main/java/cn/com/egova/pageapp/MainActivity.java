package cn.com.egova.pageapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

import cn.com.egova.page.OnPageListener;
import cn.com.egova.page.PageBO;
import cn.com.egova.page.PageHelper;

public class MainActivity extends Activity implements OnPageListener {
    LinearLayout llContainer;
    ListView lstNum;
    ArrayAdapter adapter;
    PageHelper pageHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        loadData(1);
    }


    private void initView() {
        llContainer = (LinearLayout) findViewById(R.id.ll_container);
        lstNum = (ListView) findViewById(R.id.lst_nums);

        pageHelper = new PageHelper(this, this);
    }

    private void loadData(int currentPage) {
        List<Integer> numList = NumCreator.create(currentPage);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, numList);
        lstNum.setAdapter(adapter);

        PageBO pageBO = new PageBO();
        pageBO.setCurrentPage(NumCreator.currentPage);
        pageBO.setTotalPage(NumCreator.totalPage);
        pageBO.setCurrentRecord(NumCreator.currentRecord);
        pageBO.setNumPerPage(NumCreator.numPerPage);
        pageBO.setTotalRecord(NumCreator.totalRecord);

        //添加pageView
        pageHelper.attachToView(llContainer);
        pageHelper.invalidate(pageBO);
    }

    @Override
    public void goFirstPage() {
        loadData(1);
    }

    @Override
    public void goLastPage() {
        loadData(NumCreator.totalPage);
    }

    @Override
    public void goNextPage() {
        loadData(NumCreator.currentPage + 1);
    }

    @Override
    public void goPreviousPage() {
        loadData(NumCreator.currentPage - 1);
    }

    @Override
    public void goSpecifiedPage(int goPage) {
        loadData(goPage);
    }
}
