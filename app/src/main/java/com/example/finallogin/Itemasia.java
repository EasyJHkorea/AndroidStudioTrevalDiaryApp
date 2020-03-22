package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemasia extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_asia);

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
                R.drawable.asia_korea,
                R.drawable.asia_sing,
                R.drawable.asia_mol
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.namsan,
                R.drawable.sing_one,
                R.drawable.mol_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.namsan_two,
                R.drawable.sing_two,
                R.drawable.mol_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.namsan_three,
                R.drawable.sing_three,
                R.drawable.mol_three
        );

        List<String> listInner = Arrays.asList(
                "서울의 상징, 남산서울타워",
                "화려한 밤, 마리나 베이 샌즈",
                "환상의 낙원, 앙사나 아이후루"
        );
        List<String> listInnercontent = Arrays.asList(
                "‘남산서울타워’는 효율적인 방송전파 송수신과 한국의 전통미를 살린 관광 전망시설의 기능을 겸비한 국내 최초의 종합전파 탑으로 방송문화와 관광산업의 미래를 위해 건립되었습니다.\n" +
                        "\n" +
                        "세계 유명한 종합 탑들이 그 나라 또는 그 도시의 상징적인 존재가 된 것처럼 '남산서울타워' 역시 지난 40여 년간 대한민국의 대표적인 관광지이자 서울의 상징물 역할을 해왔습니다.\n" +
                        "\n" +
                        "‘남산서울타워’는 서울 시내 전 지역에서 보이는 탑의 높이와 독특한 구조, 형태 등으로 인하여 시민의 관심과 사랑의 대상이 되었고, 내외국인들이 즐겨 찾는 제1의 관광 명소로서의 위치를 확고히 하고 있습니다. 최근 한류 바람을 몰고 온 각종 예능, 드라마의 촬영지로 이름이 높아지면서 내외국인 관광객들이 발길이 끊이지 않는 곳입니다.\n",
                "5성급 호텔 객실안에 바닥에서 천장까지 이어진 창문 앞에서 음료수를 마시면서싱가포르의 도시 야경과 그림처럼 완벽한 가든 바이 더 베를 감상하는 것을 상상해보세요.\n" + "\n"
                        + "또는 전 세계 최고이자 최대 규모의 인피니티 수영장에서 비교할 수 없는 파노라마 전망을 즐기며 수영하는 것을 상상해 보세요.\n" + "\n"
                        + " 이는 마리나 베이 샌즈 호텔 고객만 누릴 수 있는 인생 단 한 번뿐인 경험입니다.",
                "앙사나 아이후루는 바빈파루에서 걸어가실 수 있는 거리에 있습니다. \n" +"\n"
                        + "윈드서핑, 해양 스포츠, 스쿠버 다이빙 등 다양한 액티비티를 경험하실 수 있습니다. \n" +"\n"
                        + "앙사나에 위치한 이 리조트에서는 5성급의 객실 및 시설은 물론, 전용 비치 등을 제공합니다.\n" + "\n"
                        + "스파, 웰니스센터, 사우나, 거품 욕조, 수영장도 갖춰져 있습니다.\n" + "내부에는 수영장이 완비된 피트니스센터가 있습니다. \n" + "\n"
                        + "리조트에서는 다트판, 바비큐/피크닉 공간 등의 레크리에이션 시설을 이용하실 수 있습니다."
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
