package com.example.gaotianyu.app.Activity.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaotianyu.app.Activity.PostAdapter_1;
import com.example.gaotianyu.app.Activity.PostList.PostList_1;
import com.example.gaotianyu.app.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.gaotianyu.app.R.id.recyclerView_saishi;

/**
 * Created by GaoTianyu on 2017/12/1.
 */

public class SaishiFragment extends Fragment {
    private List<PostList_1> postList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup contianer, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_saishi,contianer,false);
        PostList_1 postList_1 = new PostList_1("a","b","c");
        postList.add(postList_1);
        RecyclerView recyclerView_saishi = (RecyclerView) view.findViewById(R.id.recyclerView_saishi);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView_saishi.setLayoutManager(layoutManager);
        PostAdapter_1 adapter_lianxiren = new PostAdapter_1(postList);
        recyclerView_saishi.setAdapter(adapter_lianxiren);
        return view;
    }

}
