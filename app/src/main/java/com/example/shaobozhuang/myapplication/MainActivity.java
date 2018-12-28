package com.example.shaobozhuang.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.shaobozhuang.myapplication.adapter.SectionAdapter;
import com.example.shaobozhuang.myapplication.bean.NewstBean;
import com.example.shaobozhuang.myapplication.data.DataServer;
import com.example.shaobozhuang.myapplication.decoration.GridSectionAverageGapItemDecoration;
import com.example.shaobozhuang.myapplication.entity.MySection;
import com.example.shaobozhuang.myapplication.utils.FastJsonUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @BindView(R.id.ry)
    RecyclerView mRecyclerView;
    private List<MySection> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRy();
    }

    private void initRy() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mData = DataServer.getSampleData();
        SectionAdapter sectionAdapter = new SectionAdapter(R.layout.item_section_content, R.layout.def_section_head, mData);

        sectionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MySection mySection = mData.get(position);
                if (mySection.isHeader)
                    Toast.makeText(MainActivity.this, mySection.header+"--"+position, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, mySection.t.getName()+"--"+position, Toast.LENGTH_LONG).show();
            }
        });
        sectionAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "onItemChildClick" + position, Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView.setAdapter(sectionAdapter);
    }

    public void generateData() {
        NewstBean newstBean = new NewstBean();
        ArrayList<NewstBean.TalkerBean> talkerBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NewstBean.TalkerBean talkerBean = new NewstBean.TalkerBean();
            talkerBean.setMessage("这是消息--" + i);
            talkerBean.setName("消息名-" + i);
            talkerBeans.add(talkerBean);
        }
        newstBean.setTalkers(talkerBeans);

        ArrayList<NewstBean.WorkBean> workBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NewstBean.WorkBean talkerBean = new NewstBean.WorkBean();
            talkerBean.setTaskName("这是工作--" + i);
            talkerBean.setOtherName("张三-" + i);
            workBeans.add(talkerBean);
        }
        newstBean.setWorks(workBeans);

        ArrayList<NewstBean.NoticeBean> noticeBeans = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            NewstBean.NoticeBean noticeBean = new NewstBean.NoticeBean();
            noticeBean.setNoticeContent("明天去爬山--" + i);
            noticeBean.setOtherName("项目组成员-" + i);
            noticeBeans.add(noticeBean);
        }
        newstBean.setNotices(noticeBeans);

        String result = FastJsonUtil.bean2Json(newstBean);
        Log.i(TAG, "onCreate: --" + result);
    }
}
