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
		// TODO 自动生成的方法存根
		switch (view.getId()) {
		case R.id.system:
			//系统弹窗
			showSystemDialog();
			break;
		case R.id.custome:
			//自定义弹窗
			showCustomeDialog();
			break;

		default:
			break;
		}
	}


	CustomeDialog dialog;
	private void showCustomeDialog() {
		// TODO 自动生成的方法存根
		CustomeDialog.Builder builder = new Builder(MainActivity.this);
		builder.setTitle("提示");
		builder.setContent("确定退出APP？");
		builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				if(dialog!=null){
					dialog.dismiss();
				}
			}
		});
		dialog = builder.create();
		dialog.show();
		
	}


	private void showSystemDialog() {
		// TODO 自动生成的方法存根
		AlertDialog.Builder mbuilder = new AlertDialog.Builder(MainActivity.this);
		mbuilder.setTitle("提示");
		mbuilder.setMessage("确定退出APP？");
		mbuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				// TODO 自动生成的方法存根
				finish();
			}
		});
		mbuilder.setNegativeButton("取消", null);
		mbuilder.create().show();
	}
}
