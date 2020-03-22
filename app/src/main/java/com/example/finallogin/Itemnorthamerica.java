package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemnorthamerica extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_northamerica);

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
                R.drawable.north_usa,
                R.drawable.north_canada,
                R.drawable.north_mexico
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.usa_one,
                R.drawable.can_one,
                R.drawable.mex_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.usa_two,
                R.drawable.can_two,
                R.drawable.mex_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.usa_three,
                R.drawable.can_three,
                R.drawable.mex_three
        );

        List<String> listInner = Arrays.asList(
                "문화의 메카, 뉴욕",
                "이민자의 도시, 토론토",
                "떠오로는 신혼 여행지, 칸쿤"
        );
        List<String> listInnercontent = Arrays.asList(
                "미식가와 패셔니스타들이 선호하는 도시이자, 힙합이 시작된 도시 뉴욕. \n" + "\n" +
                        "뉴욕은 미국 동부 여행에서 빠지지 않는 여행 필수 도시다. 브로드웨이 뮤지컬, 센트럴파크, 자유의 여신상, 타임스퀘어, 엠파이어스테이트빌딩 등이 대표적인 도시의 랜드마크다.\n" + "\n" +
                        "치즈케익과 베이글, 스테이크, 뉴욕피자가 대표적인 음식이며, 미식가들을 사로잡는 유명한 레스토랑이 많다. 교통체증이 심해 여행객들은 대부분 지하철을 애용한다.",
                "캐나다에서 가장 큰 도시이자 이민자들의 도시 토론토. 토론토는 북미 주요 도시 중에서 낮은 범죄율을 자랑하는 여행하기 안전한 도시다. \n" + "\n" +
                        "자전거를 타고 도심을 관광하기 좋고, 외곽으로는 나이아가라 폭포가 있다. \n" + "\n" +
                        "토론토는 각종 박물관과 미술관 등이 많아 문화관광을 하기에 적합하고, 체험위주의 과학관과 수족관이 있어 자녀들과 함께 관광하기도 좋은 도시다. 요크빌 명품거리와 이튼센터에서 쇼핑도 인기있는 관광코스다.",
                "멕시코 여행은 미국인이 신혼여행지로 가장 선호한다는 휴양지 칸쿤에서 시작되었다. \n" + "\n" +
                        "쿠바의 아바나에서 비행기를 타고 넘어올 수 있는 제일 가까운 곳이기 때문이다. 유카탄 반도의 카리브 \n" + "\n" +
                        "해에 면한 휴양지 칸쿤은 마야어로 ‘뱀의 둥지’를 뜻한다. 1970년대 초 개발이 시작될 때만 해도 \n" + "\n" +
                        "인구 100명에 불과한 어촌이었는데 이제 인구 50만에 해마다 400만 명이 찾아오는 세계적인 휴양지가 되었다.\n" + "\n" +
                        " 카리브 해의 물빛이 아름답기로 소문난 칸쿤은 두 개의 대조적인 지역으로 이루어져있다. \n" + "\n" +
                        "다운타운 구역과 이슬라 칸쿤 혹은 보통 ‘호텔 지역’으로 부르는 해변이다."
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
