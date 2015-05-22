package hxws.generator.ui;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import hxws.generator.R;
import hxws.generator.annotations.findview;
import hxws.generator.annotations.lifecycle.afterInject;
import hxws.generator.annotations.lifecycle.onCreate;
import hxws.generator.annotations.onItemClick;
import hxws.generator.annotations.rest.addRequest;
import hxws.generator.annotations.rest.mark.Ref;
import hxws.generator.annotations.rest.mark.RequestType;
import hxws.generator.annotations.setLayout;
import hxws.generator.vo.Vo;

@setLayout(R.layout.frag)
public class Myfrag extends Fragment {

    public RequestQueue queue;

    @findview(R.id.lv) ListView lv;
    @onItemClick(R.id.lv) void itemClick(AdapterView parent,View view,int position,long id){
        Toast.makeText(getActivity(),"你点击了:"+parent.getItemAtPosition(position)+",position:"+position+",id:"+id,Toast.LENGTH_SHORT).show();
    }
    @onCreate
    void initQueue(){
        queue = Volley.newRequestQueue(getActivity());
    }
    @afterInject void setAdapter(){
        SimpleAdapter adapter = new SimpleAdapter(getActivity());
        lv.setAdapter(adapter);
    }
    @addRequest(methodType = "Get",url = "http://api.feng-jian.com/",
                requestType = RequestType.STRING,convert = Vo.class,
                ref = Ref.AFTERINJECT)
    void request(Vo result,VolleyError error){
        if(result != null)
            Toast.makeText(getActivity(),result.getErr_msg(),Toast.LENGTH_LONG).show();
        else
            Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_LONG).show();
    }
}
