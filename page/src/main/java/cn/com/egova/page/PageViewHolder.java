package cn.com.egova.page;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by yuanchao on 2018/5/11.
 */

public class PageViewHolder {
    View rootView;
    TextView tvFirstPage;
    TextView tvLastPage;
    Button btnPrePage;
    Button btnNextPage;
    EditText etGoPage;
    Button btnJumpTo;
    TextView tvCurPage;
    TextView tvTotalPage;
    TextView tvCurrentRecord;
    TextView tvTotalCount;

    public PageViewHolder(Context context, View.OnClickListener listener) {
        this.rootView = LayoutInflater.from(context).inflate(R.layout.layout_page_helper,null,false);
        this.tvFirstPage = (TextView) rootView.findViewById(R.id.tv_first_page);
        this.tvFirstPage.setText(Html.fromHtml("<u>首页</u>"));
        this.tvLastPage = (TextView) rootView.findViewById(R.id.tv_last_page);
        this.tvLastPage.setText(Html.fromHtml("<u>末页</u>"));
        this.btnPrePage = (Button) rootView.findViewById(R.id.btn_pre_page);
        this.btnPrePage.setText("<");
        this.btnNextPage = (Button) rootView.findViewById(R.id.btn_next_page);
        this.btnNextPage.setText(">");
        this.etGoPage = (EditText) rootView.findViewById(R.id.et_go_page);
        this.btnJumpTo = (Button) rootView.findViewById(R.id.btn_jump_to);
        this.tvCurPage = (TextView) rootView.findViewById(R.id.tv_cur_page);
        this.tvTotalPage = (TextView) rootView.findViewById(R.id.tv_total_page);
        this.tvCurrentRecord = (TextView) rootView.findViewById(R.id.tv_current_record);
        this.tvTotalCount = (TextView) rootView.findViewById(R.id.tv_total_count);

        //首页、末页、向前、向后、跳转等
        this.tvFirstPage.setOnClickListener(listener);
        this.tvLastPage.setOnClickListener(listener);
        this.btnPrePage.setOnClickListener(listener);
        this.btnNextPage.setOnClickListener(listener);
        this.btnJumpTo.setOnClickListener(listener);
    }
}
