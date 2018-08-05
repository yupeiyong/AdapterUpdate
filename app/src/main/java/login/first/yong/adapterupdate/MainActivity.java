package login.first.yong.adapterupdate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    private void bindView(){
        List<Data>datas=new LinkedList<Data>();
        final MyAdapter adapter=new MyAdapter(this,datas);
        ListView listView=findViewById(R.id.list_one);
        listView.setAdapter(adapter);

        Button btnAdd=findViewById(R.id.btnAdd);
        editTextContent=findViewById(R.id.editTextContent);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data=new Data();
                data.setContent(editTextContent.getText().toString());
                adapter.add(data);
            }
        });
    }
}
