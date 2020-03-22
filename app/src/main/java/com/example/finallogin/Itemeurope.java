package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemeurope extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_europe);

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
                R.drawable.europe_italia,
                R.drawable.europe_england,
                R.drawable.europe_france
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.ital_one,
                R.drawable.eng_one,
                R.drawable.fran_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.ital_two,
                R.drawable.eng_two,
                R.drawable.fran_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.ital_three,
                R.drawable.eng_three,
                R.drawable.fran_three
        );

        List<String> listInner = Arrays.asList(
                "고대의 유산물, 로마",
                "희망의 횟불, 세인트폴 대성당",
                "에펠탑도 식후경, 파리"
        );
        List<String> listInnercontent = Arrays.asList(
                "2,500여년의 역사를 자랑하는 이탈리아의 수도. 로마는 고대의 유물 유적이 워낙 많아 지하철이 발달되어있지 않다. \n" + "\n" +
                        "그래서 여행을 할 때는 버스를 이용하거나, 가능하다면 도보로 여행을 많이 한다. \n" + "\n" +
                        "콜로세움, 바티칸 시국, 포폴로 광장, 테르미니역 네 꼭짓점 이내에 대부분의 관광명소들이 밀집해있어 여행코스로 많이 애용된다. \n" + "\n" +
                        "고대 로마 유적지 뿐만 아니라 피자, 파스타 같은 현지음식도 유명하다.",
                "세인트폴은 제2차 세계대전 당시 독일의 공습을 끄떡없이 버텨내어 런던 시민들의 상징이 되었으며, 오늘날에도 런던 시내에서 가장 많은 이야기를 들려 주는 건축물로 남아 있다. \n" + "\n" +
                        "특히 밤에는 아치 모양의 전조등이 켜지면서 돔이 환하게 빛나 마치 마법처럼 아름답다. \n" + "\n" +
                        "영국 국교회의 최초의 기념비적 건축물이라 할 수 있는 세인트폴은 로마 가톨릭 성당들과는 다른 분위기가 느껴진다. \n" + "\n" +
                        "정교한 조각이나 섬세한 프레스코화처럼 복잡한 장식도 있지만, 모던함이 느껴지는 가벼움과 지적인 측면도 있다.",
                "프랑스의 수도이자 유럽의 대표도시 파리. 에펠탑, 개선문, 노트르담 대성당, 베르사유 궁전 같은 대표 건축물 부터, 오르셰 미술관과 루브르 박물관 까지, 파리는 짧은 일정으로 둘러보기 힘들 정도의 많은 랜드마크들과 예술 작품들이 있다. \n" + "\n" +
                        "미식의 나라로 불리는 프랑스답게 파리에도 에스까르고, 푸아그라, 바게트, 크레페 등 미식가들을 유혹하는 유명 레스토랑이 많다. \n" + "\n" +
                        "상대적으로 저렴한 비스트로 부터 고급 레스토랑까지 다양한 음식점이 있어, 여행객의 취향에 맞게 선택할 수 있다."
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
