package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemsouthamerica extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_southamerica);

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
                R.drawable.south_argentina,
                R.drawable.south_chile,
                R.drawable.south_peru
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.arg_one,
                R.drawable.chi_one,
                R.drawable.per_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.arg_two,
                R.drawable.chi_two,
                R.drawable.per_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.arg_three,
                R.drawable.chi_three,
                R.drawable.per_three
        );

        List<String> listInner = Arrays.asList(
                "거대한 폭포, 이과수 폭포",
                "지구에서 가자 고립된 섬, 이스터섬 ",
                "잃어버린 공중 도시, 마추픽추"
        );
        List<String> listInnercontent = Arrays.asList(
                "‘이과수’는 원주민 과라니 족이 붙인 이름으로 ‘큰 물’이라는 뜻. \n" +
                        "미국 대통령 부인 엘리너 루즈벨트로 하여금 “불쌍한 나이아가라!”라고 탄식하게 만들고 만, 바로 그 ‘큰 물’이다. \n" + "\n" +
                        "너비 4.5km에 평균낙차 70m. 크고 작은 폭포의 수가 275개에 이른다. 너비와 낙차만을 놓고 본다면 세계에서 가장 큰 폭포다. 브라질 파라나 주의 쿠리치바 근처에서 발원해 수 백 킬로미터를 달려온 이과수 강이 아마존 남부에서 흘러온 파라나 강과 만나면서 폭포가 되어 쏟아져 내린다. \n" + "\n" +
                        "두 강의 큰 낙차와 풍부한 유량이 이토록 거대한 폭포를 만들었는데 인간의 손이 닿지 않은 원시림으로 뒤덮인 주변은 폭포와 삼림과 계곡이 어우러지는 장관을 연출한다.",
                "본토로부터 3700 킬로미터쯤 떨어진 섬이라면 ‘고립’이란 단어를 허용해도 되지 않을까? 3백만 년 전 화산 폭발로 생겨나 70여개의 크고 작은 \n" + "\n" +
                        "분화구가 남아있고, 거석문화와 폴리네시아 유일의 문자가 있었던 섬. 1888년에 칠레령이 된 이 섬의 공식 이름은 이슬라데파스꾸아(Isla de Pascua). 그러나 이 섬의 원주민들은 라파 누이(Rapa Nui), ‘거대한 땅’이라 부른다. \n" + "\n" +
                        "가장 흔하게는 이스터섬(Easter Island, 1722년, 네덜란드 탐험가가 상륙한 날이부활절이었기 때문.)이라고 불리는 곳.",
                "황금을 찾는 이들에게 쫓기고 쫓겨 도망친 잉카인들이 비밀도시를 건설하고 복수를 꿈꾸었다는 곳. \n" + "\n" +
                        "어느날 갑자기 만 명이 넘던 도시의 주민들이 마을을 불태우고 185구의 미라만을 남겨두고 사라져버린 곳.\n" + "\n" +
                        "여성과 아이들을 땅에 묻고 사라진 그들은 어디로 갔을까. 더 깊은 아마존의 밀림 속으로 들어간 것일까. \n" + "\n" +
                        "그렇다면 아마존 어딘가에는 어째서 그토록 깊은 정글에서 살게 되었는지 알지도 못한 채 살아가는 잉카의 후예들이 남아있을까."
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
