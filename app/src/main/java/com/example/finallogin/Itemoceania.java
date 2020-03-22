package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemoceania extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activtiy_oceania);

        init();

        getData();
    }

    private void init() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의의 데이터입니다.
/*        List<String> listTitle = Arrays.asList("Korea", "China", "Singapore", "Thailand","Maldives");
        List<String> listContent = Arrays.asList(
                "",
                "",<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    tools:context=".Itemasia">

    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#F0F0F0"/>

</LinearLayout>
                "",
                "",
                ""
        );
*/
        List<Integer> listmainimage = Arrays.asList(
                R.drawable.oceania_australia,
                R.drawable.oceania_fiji,
                R.drawable.oceania_newzealand
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.oce_one,
                R.drawable.fij_one,
                R.drawable.new_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.oce_two,
                R.drawable.fig_two,
                R.drawable.new_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.oce_three,
                R.drawable.fig_three,
                R.drawable.new_three
        );

        List<String> listInner = Arrays.asList(
                "화려한 대도시, 시드니",
                "원시가 숨 쉬는 남태평양의 외딴 섬나라, 피지",
                "끊이지 않는 관광객, 뉴질랜드"
        );
        List<String> listInnercontent = Arrays.asList(
                "시드니 대도시권은 서쪽 블루산맥, 북쪽 호크스베리강(江), 남쪽 보터니만(灣)까지 뻗어 있으며, 전국 인구의 약 1/4이 몰려 있는 이 나라 최대의 도시이다. 중생대의 사암층의 대지와, \n" + "\n" +
                        "서쪽 내륙에는 이암질(泥岩質)의 파랑상(波浪狀)의 저지를 사이에 두고 해발고도 1,000m 전후의 블루산맥이 남북으로 뻗어 있다. \n" + "\n" +
                        "이 대지의 계곡은 하류지역에서 익곡(溺谷)을 이루어 포트잭슨만(灣), 보터니만 등을 이룬다.",
                "\n" + "피지(Fiji)는 원시가 숨 쉬는 남태평양의 외딴 섬나라다. \n" + "\n" +
                        "비티레부(Viti Levu)와 바누아 레부(Vanua Levu) 등2개의 큰 섬과 320여 개의 부속 섬들은 푸른 바다에 점점이 흩어져 있다. \n" + "\n" +
                        "섬 구석구석에는 해변에 기대 살아왔던 멜라네시안 원주민들의 오랜 흔적과 휴양을 위해 찾아든 이방인들의 삶이 뒤엉킨다.",
                "1년 내내 여행자들의 발길이 끊이지 않는 나라다. 남섬, 북섬으로 나누어져 있어 지역별로 기후가 다르다. \n" + "\n" +
                        "여름 시즌인 11~2월은 날씨가 좋아 북섬을 여행하기에 제격이다. \n" + "\n" +
                        "그러나 그만큼 사람들이 북적대고 숙박 예약이나 관광지 입장권 구매가 쉽지 않다. \n" + "\n" +
                        "남섬은 겨울 스포츠를 즐기기 좋은 곳으로 어느 때든 계절에 상관없이 좋은 설질의 스키장에서 스키를 마음껏 즐길 수 있다."
        );
        for (int i = 0; i < listmainimage.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            Data data = new Data();
            //data.setTitle(listTitle.get(i));
            //data.setContent(listContent.get(i));
            data.setResId(listResId.get(i));
            data.setInner(listInner.get(i));
            data.setMainimage(listmainimage.get(i));
            data.setResidtwo(listResidtwo.get(i));
            data.setResidthree(listResidthree.get(i));
            data.setInnercontent(listInnercontent.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
}
