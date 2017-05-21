package net.nevzatgunay.pathytest;

/**
 * Created by Nevzat on 3/22/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.VolleyError;

import net.nevzatgunay.pathytest.R;

public class TwoFragment extends Fragment implements OnItemClickListener{

    public TwoFragment() {
        // Required empty public constructor
    }

    public static final String JSON_URL = "http://10.0.3.2/Pathy/getDataforPathy.php";
    private ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_three, container, false);

        listView = (ListView) view.findViewById(R.id.listView);

        sendRequest();

        listView.setOnItemClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View arg1, int position, long arg3) {
        // TODO Auto-generated method stub
        String item = adapter.getItemAtPosition(position).toString();
        Toast.makeText(getActivity().getApplicationContext(), "CLICK: " + item, Toast.LENGTH_SHORT).show();
    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity().getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(stringRequest);

    }

    private void showJSON(String json){
        ParseJSON pj = new ParseJSON(json);
        pj.parseJSON();
        CustomList cl = new CustomList(getActivity(), ParseJSON.emails,ParseJSON.froms,ParseJSON.tos,ParseJSON.dates,ParseJSON.times,ParseJSON.prices);
        listView.setAdapter(cl);
    }




}
