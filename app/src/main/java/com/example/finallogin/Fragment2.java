package com.example.finallogin;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ListView postlistView;
    //courseListView
    private PostListadapter Adaper;
    //adapter
    private List<receivepost> postList;

    private String userID;
    private String ind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView2 = inflater.inflate(R.layout.fragment_fragment2, container, false);

        postlistView=(ListView)rootView2.findViewById(R.id.postlist);
        postList=new ArrayList<receivepost>();
        Adaper=new PostListadapter(getContext().getApplicationContext(),postList);
        postlistView.setAdapter(Adaper);

        new BackgroudTask2().execute();

        return rootView2;



    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


    class BackgroudTask2 extends AsyncTask<Void,Void,String>
    {
        String target;
        @Override
        protected void onPreExecute(){
            userID=SuccessActivity.usetidtestt;
            try {
                target = "https://eotjr90.cafe24.com/text_own.php?userID=" + URLEncoder.encode(userID, "UTF-8");

            }
            catch (Exception e)
            {
                e.printStackTrace();
            } }
        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String temp;
                StringBuilder stringBuilder=new StringBuilder();
                while ((temp=bufferedReader.readLine())!=null){
                    stringBuilder.append(temp+"Wn");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        public void onProgressUpdate(Void...values){super.onProgressUpdate();}

        @Override
        public void onPostExecute(String result){
            if(result!=null) {
                try {
                    postList.clear();
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;
                    String address,userid,time,textone,texttwo,textthree,star,ind;

                    while (count < jsonArray.length()) {
                        JSONObject object = jsonArray.getJSONObject(count);
                        textone = object.getString("textone");
                        texttwo = object.getString("texttwo");
                        textthree = object.getString("textthree");
                        address = object.getString("address");
                        time = object.getString("time");
                        userid = object.getString("userid");
                        star = object.getString("star");
                        ind=String.valueOf(object.getInt("ind"));


                        receivepost receivepost = new receivepost(address, userid, time, textone, texttwo, textthree, star,ind);
                        postList.add(receivepost);
                        count++;
                    }
                    if (count == 0) {

                        AlertDialog dialog;
                        AlertDialog.Builder builder = new AlertDialog.Builder(Fragment2.this.getActivity());
                        dialog = builder.setMessage("게시글이 없습니다.")
                                .create();
                        dialog.show();
                    }
                    Adaper.notifyDataSetChanged();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                Toast.makeText(getActivity(),"오류입니다.",Toast.LENGTH_SHORT).show();
            }

        }

    }

}
