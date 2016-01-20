package com.example.kimjh.applicationcomponentpj;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputView;
    TextView otherResult;
    private static final int REQUEST_CODE_OTHER = 0;//requestCode는 0보다 크거나 같은 값으로 정의해야 한다.(상수이용)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (EditText)findViewById(R.id.edit_input);
        otherResult = (TextView)findViewById(R.id.text_message);

        Button btn  = (Button)findViewById(R.id.btn_other);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = inputView.getText().toString();
                Intent intent = new Intent(MainActivity.this,OtherActivity.class);
                Person p = new Person();        //Person 객체 생성후 데이터를 넣어 준다.
                p.message = message;
                p.name = "ysi";
                p.age = 42;

                intent.putExtra(OtherActivity.EXTRA_PERSON, p);  //Intent값을 저장한다.
                startActivityForResult(intent,REQUEST_CODE_OTHER);
                //Main에서 Other를 호출한 다음, Other가 전달하는 값을 받기 위해서는 startActivityForResult(intent,REQUEST_CODE_OTHER)로 받아야 한다.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_OTHER && resultCode == Activity.RESULT_OK){
            String resultMessage = data.getStringExtra(OtherActivity.RESULT_MESSAGE);
            otherResult.setText(resultMessage);
        } else {
            Toast.makeText(this,"BackKeyPressed",Toast.LENGTH_SHORT).show();
        }
    }
}
