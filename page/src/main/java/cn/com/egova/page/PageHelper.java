package cn.com.egova.page;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by yuanchao on 2018/5/11.
 */

public class PageHelper implements View.OnClickListener {
    private Activity activity;
    private ViewGroup mParentVG;  //根容器,FrameLayout.
    private ViewGroup mPageView;  //分页布局
    private PageViewHolder holder = null;
    private OnPageListener listener;
    public int currentPage = 1;
    public int totalPage = 1;

    public PageHelper(Activity activity, OnPageListener listener) {
        this.activity = activity;
        holder = new PageViewHolder(activity, this);
        mParentVG = findContentParent(activity);
        mPageView = (ViewGroup) holder.rootView;
        this.listener = listener;
    }


    /**
     * android.R.id.content 实际上是一个FrameLayout.
     *
     * @param activity
     * @return
     */
    private ViewGroup findContentParent(Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = (ViewGroup) decorView.findViewById(android.R.id.content);
        return viewGroup;
    }


    /**
     * 给Activity的最顶层帧布局添加pageView
     *
     * @return
     */
    public PageHelper attachToView() {
        if (mPageView != null && mPageView.getParent() != null) {
            mParentVG.removeView(mPageView);
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        mParentVG.addView(mPageView, lp);
        return this;
    }

    /**
     * 给指定的帧布局添加pageView
     *
     * @param parent
     * @return
     */
    public PageHelper attachToView(FrameLayout parent) {
        if (mPageView != null && parent != null) {
            parent.removeView(mPageView);
        }
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        parent.addView(mPageView, lp);
        return this;
    }

    /**
     * 给指定的线性布局添加pageView
     *
     * @param parent
     * @return
     */
    public PageHelper attachToView(LinearLayout parent) {
        if (mPageView != null && parent != null) {
            parent.removeView(mPageView);
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.BOTTOM;
        parent.addView(mPageView, lp);
        return this;
    }

    /**
     * 移除pageView
     *
     * @return
     */
    public PageHelper detachFromView() {
        if (mPageView != null && mPageView.getParent() != null) {
            ((ViewGroup) mPageView.getParent()).removeView(mPageView);
        }
        return this;
    }

    /**
     * 是否添加了pageView.
     *
     * @return
     */
    public boolean isAttach() {
        return mPageView != null && mPageView.getParent() != null;
    }

    /**
     * 每次查询完刷新一下pageView
     *
     * @param pageBO
     */
    public void invalidate(PageBO pageBO) {
        holder.tvCurPage.setText(pageBO.getCurrentPage() + "");
        holder.tvTotalPage.setText(pageBO.getTotalPage() + "");
        holder.tvCurrentRecord.setText(pageBO.getCurrentRecord() + "");
        holder.tvTotalCount.setText(pageBO.getTotalRecord() + "");
        holder.etGoPage.setText(pageBO.getCurrentPage() + "");

        //不断更新
        this.currentPage = pageBO.getCurrentPage();
        this.totalPage = pageBO.getTotalPage();
    }


    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.tv_first_page) {
            listener.goFirstPage();
        } else if (resId == R.id.tv_last_page) {
            listener.goLastPage();
        } else if (resId == R.id.btn_pre_page) {
            if (currentPage == 1) {
                Toast.makeText(activity, "已是第一页!", Toast.LENGTH_SHORT).show();
                return;
            }
            listener.goPreviousPage();
        } else if (resId == R.id.btn_next_page) {
            if (currentPage == totalPage) {
                Toast.makeText(activity, "已是最后一页!", Toast.LENGTH_SHORT).show();
                return;
            }
            listener.goNextPage();
        } else if (resId == R.id.btn_jump_to) {
            String goPageStr = holder.etGoPage.getText().toString().trim();
            try {
                int goPage = Integer.parseInt(goPageStr);
                if (goPage < 1 || goPage > totalPage) {
                    Toast.makeText(activity, "请输入正确的页码!", Toast.LENGTH_SHORT).show();
                }
                listener.goSpecifiedPage(goPage);
            } catch (Exception e) {
                Toast.makeText(activity, "请输入正确的页码!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
