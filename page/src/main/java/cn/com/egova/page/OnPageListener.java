package cn.com.egova.page;

/**
 * Created by yuanchao on 2018/5/11.
 */

public interface OnPageListener {
    void goFirstPage();

    void goLastPage();

    void goNextPage();

    void goPreviousPage();

    void goSpecifiedPage(int goPage);
}

