package com.example.dialogdemo;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomeDialog extends Dialog{

	public CustomeDialog(Context context) {
		super(context);
		// TODO 自动生成的构造函数存根
	}
	public CustomeDialog(Context context, int theme) {
		super(context, theme);
	}
	public static class Builder{
		private Context context;
		private String title; //对话框标题
		private String content; //对话框内容
		private String btnConfirm;
		private String btnCancel;
		private View contentView; 
		private DialogInterface.OnClickListener confirm_btnClickListener; 
		private DialogInterface.OnClickListener cancel_btnClickListener;
		public Builder(Context context) {
			this.context = context;
		}
		public Builder setContent(String content) {
			this.content = content;
			return this;
		}
		public Builder setTitle(String title) {
			this.title = title;
			return this;
		}
		public Builder setContext(Context context) {
			this.context = context;
			return this;
		}
		public Builder setContentView(View contentView) {
			this.contentView = contentView;
			return this;
		}
		public Builder setPositiveButton(String confirm_btnText,
				DialogInterface.OnClickListener listener) {
			this.btnConfirm = confirm_btnText;
			this.confirm_btnClickListener = listener;
			return this;
		}
		public Builder setNegativeButton(String cancel_btnText,
				DialogInterface.OnClickListener listener) {
			this.btnCancel = cancel_btnText;
			this.cancel_btnClickListener = listener;
			return this;
		}
		
		public CustomeDialog create(){
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			// instantiate the dialog with the custom Theme
			final CustomeDialog dialog = new CustomeDialog(context, R.style.custome);
			View layout = inflater.inflate(R.layout.customdialog, null);
			dialog.addContentView(layout, new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// set the dialog title
			((TextView) layout.findViewById(R.id.title)).setText(title);
			((TextView) layout.findViewById(R.id.title)).getPaint().setFakeBoldText(true);;
			// set the confirm button
			if (btnConfirm != null) {
				((Button) layout.findViewById(R.id.confirm_btn))
						.setText(btnConfirm);
				if (confirm_btnClickListener != null) {
					((Button) layout.findViewById(R.id.confirm_btn))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									confirm_btnClickListener.onClick(dialog,
											DialogInterface.BUTTON_POSITIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.confirm_btn).setVisibility(
						View.GONE);
			}
			// set the cancel button
			if (btnCancel != null) {
				((Button) layout.findViewById(R.id.cancel_btn))
						.setText(btnCancel);
				if (cancel_btnClickListener != null) {
					((Button) layout.findViewById(R.id.cancel_btn))
							.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) {
									cancel_btnClickListener.onClick(dialog,
											DialogInterface.BUTTON_NEGATIVE);
								}
							});
				}
			} else {
				// if no confirm button just set the visibility to GONE
				layout.findViewById(R.id.cancel_btn).setVisibility(
						View.GONE);
			}
			// set the content message
			if (content != null) {
				((TextView) layout.findViewById(R.id.message)).setText(content);
			} else if (contentView != null) {
				// if no message set
				// add the contentView to the dialog body
				((LinearLayout) layout.findViewById(R.id.message))
						.removeAllViews();
				((LinearLayout) layout.findViewById(R.id.message)).addView(
						contentView, new LayoutParams(
								LayoutParams.WRAP_CONTENT,
								LayoutParams.WRAP_CONTENT));
			}
			dialog.setContentView(layout);
			return dialog;
		}
		
	}

}
