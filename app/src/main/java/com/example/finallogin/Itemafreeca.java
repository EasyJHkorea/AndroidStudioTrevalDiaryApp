package com.example.finallogin;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Arrays;
import java.util.List;

public class Itemafreeca extends AppCompatActivity {

    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity_afreeca);

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
                R.drawable.afreeca_ethiopia,
                R.drawable.afreeca_egypt,
                R.drawable.afreeca_tunisie
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.eit_one,
                R.drawable.egy_one,
                R.drawable.tun_one
        );

        List<Integer> listResidtwo = Arrays.asList(
                R.drawable.eit_two,
                R.drawable.egy_two,
                R.drawable.tun_two
        );

        List<Integer> listResidthree = Arrays.asList(
                R.drawable.eit_three,
                R.drawable.egy_three,
                R.drawable.tun_three
        );

        List<String> listInner = Arrays.asList(
                "고대의 도시, 오벨리스크",
                "미지의 나라, 이집트",
                "좋은 자연환경, 튀니지"
        );
        List<String> listInnercontent = Arrays.asList(
                "악숨 고대도시 유적은 에티오피아의 북쪽 국경 근처에서 발견되었다. \n" + "\n" +
                        "고대 에티오피아의 중심인 악숨 왕국은 동로마 제국과 페르시아 사이에서 가장 강력한 국가였다. 1세기부터 13세기 사이에 만들어진 거대한 유적에는 \n" + "\n" +
                        "석조 오벨리스크, 거대한 기념 석주, 왕실 묘지, 고대 성곽이 있다.\n" + "\n" +
                        "10세기 때 정치적으로 몰락한 뒤에도, 오랫동안 악숨에서 에티오피아 황제들의 대관식을 거행하였다.",
                "피라미드는 고대 이집트의 국왕, 왕비, 왕족들의 무덤입니다. \n" + "\n" +
                        "엄청난 규모와 정확도, 건설 방식이 불가사의 할 만큼 경이롭습니다. \n" + "\n" +
                        "각 능선이 정확히 동서남북을 가리키도록 설계되었고, 평균 2.5톤에 달하는 돌을 무려 230만개나 옮기고 쌓아 만들었습니다.\n" + "\n" +
                        " 신석기 후반에 불과했던 고대 이집트에서 했던 일들은 불가사의로 남겨져 있습니다.",
                "정식명칭은 튀니지공화국(Republic of Tunisia)이다. \n" + "\n" +
                        "북쪽과 동쪽은 지중해에 면하고, 서쪽은 알제리, 남동쪽은 리비아와 국경을 접하고 있다. \n" + "\n" +
                        "아프리카 대륙에서 가장 북쪽 끝에 위치하며, 마그레브(Maghreb:튀니지·알제리·모로코 등이 \n" + "\n" +
                        "자리한 북아프리카의 서부) 중 가장 면적이 좁은 나라이지만 가장 좋은 자연환경을 갖추고 있다. \n" + "\n" +
                        "공화국 선포 이래 1987년까지 부르기바(Bourguiba)가 이끄는 ‘네오데스투르당’의 일당제 정치가 31년간 존속하였다.\n" + "\n" +
                        "국명은 아랍어(語)로 'Tunis'인데, '벼랑' 또는 '밤을 보내다'라는 뜻의 베르베르어에서 유래한 것으로 전해진다. "
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
