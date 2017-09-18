package us.mifeng.recycleviewduobuju;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list;
    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        initView();

    }

    private void initList() {
        list = new ArrayList<>();
        for (int i =1;i<20;i++){
            list.add("我是"+i+"号");
        }
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.mRv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter(MainActivity.this, list);
        mRv.setAdapter(myAdapter);

    }
}
