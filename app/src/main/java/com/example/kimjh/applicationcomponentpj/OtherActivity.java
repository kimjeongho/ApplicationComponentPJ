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

public class OtherActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "person"; //저장할 값의 할당되는 이름을 지정(저장 하는쪽, 받는쪽 공통사용)
                                                                // 상수는 값을 사용하는 쪽 (값을 받는쪽)에서 정의한다.

    public static final String RESULT_MESSAGE = "result_message"; // putExtra로 저장하는 값의 변수명도 일반적으로 상수로 정의하여 사용한다.
    TextView messageView;
    EditText resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        messageView = (TextView)findViewById(R.id.text_message);
        resultView = (EditText)findViewById(R.id.edit_result);

        Intent intent = getIntent(); // 자신을 구동한 Intent를 얻어오기 위해 getIntent()를 사용한다.
        Person p = intent.getParcelableExtra(EXTRA_PERSON); //얻어온 Intent로 부터 저장된 값을 getParcelableExtra를 이용하여 값을 얻어온다.
       Toast.makeText(OtherActivity.this,"name:"+p.name+", "+"age:"+p.age,Toast.LENGTH_SHORT).show();
        messageView.setText(p.message);

        Button btn = (Button)findViewById(R.id.btn_finish);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent data =  new Intent();//호출한 Activity로 결과를 전달하기 위해서는
                data.putExtra(RESULT_MESSAGE,resultView.getText().toString());//전달할 내용을 담을 Intent를 생성한 다음 Intent에 전달할 값을 PutExtra로 저장한다.
                setResult(Activity.RESULT_OK,data);//처리결과에 대한 code값(Activity.RESULT_OK)과 전달할 데이터(Intent)를 설정한다.
                finish();
            }
        });
    }
}
