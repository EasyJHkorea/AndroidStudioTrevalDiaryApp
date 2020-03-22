package com.example.finallogin;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
 * {@link Fragment3.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment3 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment3 newInstance(String param1, String param2) {
        Fragment3 fragment = new Fragment3();
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

    private ListView signlistView;
    //courseListView
    private signlistAdapter Adaper;
    //adapter
    private List<receivesign> signList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment3, container, false);

        signlistView=(ListView)rootView.findViewById(R.id.signlist);
        signList=new ArrayList<receivesign>();
        Adaper=new signlistAdapter(getContext().getApplicationContext(),signList);
        signlistView.setAdapter(Adaper);

        new Fragment3.BackgroudTask().execute();

        return rootView;
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

    class BackgroudTask extends AsyncTask<Void,Void,String>
    {

        String target;
        String writeuserid=SuccessActivity.usetidtestt;


        @Override
        protected void onPreExecute(){

            try {
                target = "https://eotjr90.cafe24.com/notice.php?userid=" + URLEncoder.encode(writeuserid, "UTF-8");
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
            try {
                signList.clear();
                JSONObject jsonObject=new JSONObject(result);
                JSONArray jsonArray=jsonObject.getJSONArray("response");
                int count=0;
                String commentuserid;//commentuserid받기
                String commentdate;
                String comment;

                        //writeuserid와 보내 date와 commentuserid를 받는다.

                while (count<jsonArray.length())
                {
                    JSONObject object=jsonArray.getJSONObject(count);
                    commentuserid =object.getString("commentuserid");
                    commentdate=object.getString("commentdate");
                    comment=object.getString("comment");

                    receivesign receivesign=new receivesign(commentuserid,commentdate,comment);
                    signList.add(receivesign);

                    count++;
                }
                if (count==0){

                    AlertDialog dialog;
                    AlertDialog.Builder builder=new AlertDialog.Builder(Fragment3.this.getActivity());
                    dialog=builder.setMessage("알람이 없습니다.")
                            .create();
                    dialog.show();
                }
                Adaper.notifyDataSetChanged();

            }
            catch (Exception e){
                e.printStackTrace();
            }



        }




    }
}
