package hk.ust.cse.comp107x.travel2;

/**
 * Created by Padhavi on 11-03-2017.
 */

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



public class NearbyListAdapter extends ArrayAdapter<FoursquareModel> {

    CheckBox cb;
    private Context context;
    ImageView img;
    Button r;


    ArrayList<FoursquareModel> mNearByList ;
    public NearbyListAdapter(Context context, int textViewResourceId,
                             ArrayList<FoursquareModel> objects) {
        super(context, textViewResourceId, objects);
        this.mNearByList = objects;
        // TODO Auto-generated constructor stub
    }
    public static ArrayList<String>  lat=new ArrayList<>();


    public static ArrayList<String> lng=new ArrayList<>();

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.row_layout, null,true);

        single_row.setClickable(true);
        single_row.setFocusable(true);

        Button r=(Button)single_row.findViewById(R.id.r);

        ImageView tv_img=(ImageView)single_row.findViewById(R.id.tv_img);
        CheckBox cb=(CheckBox)single_row.findViewById(R.id.checkBox);
        TextView tv_name = (TextView) single_row.findViewById(R.id.tv_name);
        TextView tv_address = (TextView) single_row.findViewById(R.id.tv_address);
        final TextView tv_lat = (TextView) single_row.findViewById(R.id.tv_lat);
        final TextView tv_lng=(TextView)single_row.findViewById(R.id.tv_lng);

        tv_name.setText(mNearByList.get(position).getName());
        tv_address.setText(mNearByList.get(position).getAddress());
       /* tv_img.setImageIcon(mNearByList.get(position).getCategoryIcon());

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

*/


        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),check.class);
                v.getContext().startActivity(i);

            }
        });

       /* r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });*/

        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_lat.setText(String.valueOf(mNearByList.get(position).getLatitude()));
                tv_lng.setText(String.valueOf(mNearByList.get(position).getLongtitude()));
                lng.add(tv_lng.getText().toString());
                lat.add(tv_lat.getText().toString());

            }
        });


        Log.d("padhavi" , " list " + lat);








        return single_row;
    }

}
