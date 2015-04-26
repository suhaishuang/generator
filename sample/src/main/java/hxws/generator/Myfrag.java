package hxws.generator;

import android.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import hxws.generator.annotations.findview;
import hxws.generator.annotations.lifecycle.afterInject;
import hxws.generator.annotations.onItemClick;
import hxws.generator.annotations.setLayout;

@setLayout(R.layout.frag)
public class Myfrag extends Fragment{

    @findview(R.id.lv) ListView lv;
    @onItemClick(R.id.lv) void itemClick(AdapterView parent,View view,int position,long id){
        Toast.makeText(getActivity(),"你点击了:"+parent.getItemAtPosition(position)+",position:"+position+",id:"+id,Toast.LENGTH_SHORT).show();
    }
    @afterInject void setAdapter(){
        SimpleAdapter adapter = new SimpleAdapter(getActivity());
        lv.setAdapter(adapter);
    }
}