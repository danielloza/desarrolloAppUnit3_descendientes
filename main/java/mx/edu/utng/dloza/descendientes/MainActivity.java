package mx.edu.utng.dloza.descendientes;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{



    private Menu[] menu = {
            new Menu(R.drawable.church, "Museo"),
            new Menu(R.drawable.artistry, "Galerias"),
            new Menu(R.drawable.restaurant, "Servicios"),
            new Menu(R.drawable.restaurant, "Sitios \nTuristicos"),
            new Menu(R.drawable.ra, "RA"),
            new Menu(R.drawable.languages, "Lenguajes")
            //new Menu(R.drawable.caskpubkitchen, "CASK Pub and Kitchen","Mexico", "Coffee"),
            //new Menu(R.drawable.confessional,"Confessional","Mexico", "Coffee"),
            //new Menu(R.drawable.donostia, "Donostia","Mexico", "Coffee"),

    };
    private GridView grvMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grvMenu = findViewById(R.id.grv_menu);
        MenuAdapter adapter = new MenuAdapter(this, menu);
        grvMenu.setAdapter(adapter);
        grvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent= new Intent(MainActivity.this,RestaurantActivity.class);
            }
        });


    }



    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption= ((Menu)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Your selected: " + selectedOption,Toast.LENGTH_SHORT).show();

           /* if(selectedOption){ //<--------
                Intent intent= new Intent(MainActivity.this,RestaurantActivity.class);
                startActivity(intent);
            }else if(selectedOption=="Museo"){
                Toast.makeText(this, "Your selected: " + selectedOption,Toast.LENGTH_SHORT).show();
            }*/
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    static class ViewHolder{
        TextView txvName;
        ImageView imvPhoto;
    }

    class MenuAdapter extends ArrayAdapter<Menu> {
        public MenuAdapter(@NonNull Context context, Menu[]data){
            super(context, R.layout.cell_layout, data);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater inflater =
                        LayoutInflater.from(getContext());
                cell = inflater.inflate(R.layout.cell_layout, null);

                holder = new ViewHolder();
                holder.imvPhoto = (ImageView) cell.findViewById(R.id.imv_thumbnail);
                holder.txvName = (TextView) cell.findViewById(R.id.txv_name);



                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }
            holder.imvPhoto.setImageResource(menu[position].getImageId());
            holder.txvName.setText(menu[position].getName());

            return cell;

        }

    }


}
