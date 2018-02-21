package mx.edu.utng.dloza.descendientes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    /*public void next(View view){
        startActivity(new Intent(this, Restaurant.class));
    }*/
    private Restaurant[] restaurants = {
            new Restaurant(R.drawable.nana, "Nana\n Pancha","Calle 1"),
            new Restaurant(R.drawable.fruti, "Fruti & \nYogurth", "Calle 2"),
            new Restaurant(R.drawable.rincon, "Rincon\n 28", "Calle 3"),
            new Restaurant(R.drawable.mostacho, "Mostacho", "Calle 4")

    };
    private ListView lsvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        lsvRestaurants = findViewById(R.id.lsv_restaurants);
        RestaurantAdapter adapter = new RestaurantAdapter(this, restaurants);
        lsvRestaurants.setAdapter(adapter);//para traer todos los datos y colocarlos al list view
        lsvRestaurants.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption= ((Restaurant)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Your selected: " + selectedOption,Toast.LENGTH_SHORT).show();
    }



    static class ViewHolder{
        TextView txvName;
        ImageView imvPhoto;
        TextView txvLocation;
    }

    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        public RestaurantAdapter(@NonNull Context context, Restaurant[] data){
            super(context, R.layout.cell_layout, data);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull
                ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell==null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell=inflater.inflate(R.layout.cell_layout, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName= cell.findViewById(R.id.txv_name);
                holder.txvLocation = cell.findViewById(R.id.txv_location);


                cell.setTag(holder);
            }else{
                holder=(ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(restaurants[position].getImageId());
            holder.txvName.setText(restaurants[position].getName());
            holder.txvLocation.setText(restaurants[position].getLocation());

            return cell;
        }
    }
}

