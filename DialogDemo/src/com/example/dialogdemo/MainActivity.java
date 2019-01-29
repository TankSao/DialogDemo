package com.example.dialogdemo;

import com.example.dialogdemo.CustomeDialog.Builder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener{

	private Button system,custom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        system = (Button) findViewById(R.id.system);
        custom = (Button) findViewById(R.id.custome);
        system.setOnClickListener(this);
        custom.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View view) {
		// TODO �Զ����ɵķ������
		switch (view.getId()) {
		case R.id.system:
			//ϵͳ����
			showSystemDialog();
			break;
		case R.id.custome:
			//�Զ��嵯��
			showCustomeDialog();
			break;

		default:
			break;
		}
	}


	CustomeDialog dialog;
	private void showCustomeDialog() {
		// TODO �Զ����ɵķ������
		CustomeDialog.Builder builder = new Builder(MainActivity.this);
		builder.setTitle("��ʾ");
		builder.setContent("ȷ���˳�APP��");
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
				if(dialog!=null){
					dialog.dismiss();
				}
			}
		});
		dialog = builder.create();
		dialog.show();
		
	}


	private void showSystemDialog() {
		// TODO �Զ����ɵķ������
		AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
		mbuilder.setTitle("��ʾ");
		mbuilder.setMessage("ȷ���˳�APP��");
		mbuilder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO �Զ����ɵķ������
				finish();
			}
		});
		mbuilder.setNegativeButton("ȡ��", null);
		mbuilder.create().show();
	}
}
