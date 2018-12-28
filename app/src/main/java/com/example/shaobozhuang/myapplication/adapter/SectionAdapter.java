package com.example.shaobozhuang.myapplication.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.shaobozhuang.myapplication.R;
import com.example.shaobozhuang.myapplication.entity.MySection;
import com.example.shaobozhuang.myapplication.entity.Video;

import java.util.List;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class SectionAdapter extends BaseSectionQuickAdapter<MySection, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param sectionHeadResId The section head layout id for each item
     * @param layoutResId      The layout resource id of each item.
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SectionAdapter(int layoutResId, int sectionHeadResId, List data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, final MySection item) {
        helper.setText(R.id.header, item.header);
        helper.setVisible(R.id.more, item.isMore());
        helper.addOnClickListener(R.id.more);
    }


    @Override
    protected void convert(BaseViewHolder helper, MySection item) {
        Video video = item.t;
        switch (helper.getLayoutPosition() %
                2) {
            case 0:
                helper.setGone(R.id.ivSmallPoint, true);
                break;
            case 1:
                helper.setGone(R.id.ivSmallPoint, false);
                break;
        }
        helper.setText(R.id.tvTextContent, video.getName());
    }
}
