package com.xpy.administrator.probityeducation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MsgAdapter;
import com.xpy.administrator.probityeducation.model.MsgModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LianJieFragment extends Fragment {
    @BindView(R.id.lv_lianjie_content)
    ListView lvLianJieContent;
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Fresco.initialize(getActivity());
        View view = inflater.inflate(R.layout.fragment_lianjie, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvContentTitle.setText("廉洁寄语");

        //模拟数据
        List<MsgModel> list = new ArrayList<>();
        MsgModel msgModel1 = new MsgModel();
        msgModel1.setImageId(R.drawable.header1);
        msgModel1.setNickName("停");
        msgModel1.setComment("廉洁，不仅是党员要拥有的，作为一民平凡的我们，也要牢牢映在心中。千锤万凿出深山，烈火焚烧若等闲。粉骨碎身全不怕，要留清白在人间。所以，廉洁精神要永存。");
        msgModel1.setTime("2017-11-20 20:12:01");
        MsgModel msgModel2 = new MsgModel();
        msgModel2.setImageId(R.drawable.header2);
        msgModel2.setNickName("SHS");
        msgModel2.setComment("只有代表群众才能教育群众，只有做群众的学生才能做群众的先生。身为大学生的我们，应当从自身做起，秉承毛泽东老人家的教导和习大大的号召，作为晓庄学子的我们，也应当发扬陶老不带半根草去的伟大思想。");
        msgModel2.setTime("2017-11-20 22:12:08");
        MsgModel msgModel3 = new MsgModel();
        msgModel3.setImageId(R.drawable.header3);
        msgModel3.setNickName("smile 假装的很好i");
        msgModel3.setComment("欲影正者端其表，欲下廉者先己身。要想影子正时就把个人仪表搞端正，要叫下属廉洁先要自身廉洁。自古以来，廉洁就是一种美德，愿现在的我们依旧延续这种美德！");
        msgModel3.setTime("2017-11-20 19:21:16");
        MsgModel msgModel4 = new MsgModel();
        msgModel4.setImageId(R.drawable.header4);
        msgModel4.setNickName("挽着星空说梦话");
        msgModel4.setComment("廉洁，在今日，似乎的确被人遗忘。而我们，作为当今青年，要将廉洁作为行之根本。");
        msgModel4.setTime("2017-11-19 21:41:32");
        MsgModel msgModel5 = new MsgModel();
        msgModel5.setImageId(R.drawable.header5);
        msgModel5.setNickName("项");
        msgModel5.setComment("克己奉公，求真务实，廉洁方能聚人，律己方能服人。勤廉者平安一世，贪婪者自毁一生。");
        msgModel5.setTime("2017-11-19 22:15:15");
        MsgModel msgModel6 = new MsgModel();
        msgModel6.setImageId(R.drawable.header6);
        msgModel6.setNickName("hx");
        msgModel6.setComment("捧着一颗心来，不带半根草去。吟唱廉洁之歌，鼓舞清风之气。犹如莲花之洁，恰似青竹之直。爱满天下之情，陶子廉洁之心。");
        msgModel6.setTime("2017-11-20 20:15:40");
        MsgModel msgModel7 = new MsgModel();
        msgModel7.setImageId(R.drawable.header7);
        msgModel7.setNickName("妞妞妞金芽");
        msgModel7.setComment("淡泊名利在岁月长河中安然度日，公正廉洁在急流险滩中稳度人生。");
        msgModel7.setTime("2017-11-20 16:38:55");
        MsgModel msgModel8 = new MsgModel();
        msgModel8.setImageId(R.drawable.header8);
        msgModel8.setNickName("嵇莉莉");
        msgModel8.setComment("作为信工的一份子，艰苦奋斗，勤俭节约，用光明磊落的态度，用自己的行动践行着朴实的誓言，诠释着廉洁的含义。相信明天的南晓因我们转本学生的到来，更加美好！！");
        msgModel8.setTime("2017-11-19 21:50:25");
        MsgModel msgModel9 = new MsgModel();
        msgModel9.setImageId(R.drawable.header9);
        msgModel9.setNickName("箫之叶妖");
        msgModel9.setComment("树廉洁之心，行廉洁之事，做廉洁之人。");
        msgModel9.setTime("2017-11-20 19:12:15");
        MsgModel msgModel10 = new MsgModel();
        msgModel10.setImageId(R.drawable.header10);
        msgModel10.setNickName("蔡婷");
        msgModel10.setComment("廉洁是为人的基本道德素养，一个人能做到廉洁只是小善，而不廉洁便成大恶。");
        msgModel10.setTime("2017-11-20 21:20:45");
        list.add(msgModel1);
        list.add(msgModel2);
        list.add(msgModel3);
        list.add(msgModel4);
        list.add(msgModel5);
        list.add(msgModel6);
        list.add(msgModel7);
        list.add(msgModel8);
        list.add(msgModel9);
        list.add(msgModel10);
        MsgAdapter adapter = new MsgAdapter(getActivity(), list);
        lvLianJieContent.setAdapter(adapter);
    }

    public LianJieFragment() {
        // Required empty public constructor
    }


}
