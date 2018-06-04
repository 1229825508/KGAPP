package com.example.administrator.kgapp.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kgapp.R;
import com.example.administrator.kgapp.SheZheActivity;
import com.example.administrator.kgapp.fragment1.FragMindActivity;
import com.example.administrator.kgapp.fragment1.FragMusicsActivity;
import com.example.administrator.kgapp.fragment1.FragSouSuoActivity;
import com.example.administrator.kgapp.fragment1.FragTuiJIanActivity;
import com.example.administrator.kgapp.utils.OkHttp;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Request;

public class MusicActivity extends FragmentActivity implements View.OnClickListener {

    @BindView(R.id.ceHua)
    ImageView ceHua;
    @BindView(R.id.mind)
    Button mind;
    @BindView(R.id.musics)
    Button musics;
    @BindView(R.id.tuiJian)
    Button tuiJian;
    @BindView(R.id.jia)
    Button jia;
    @BindView(R.id.fdj)
    ImageView fdj;
    @BindView(R.id.ziti)
    TextView ziti;
    @BindView(R.id.souSuo)
    RelativeLayout souSuo;
    @BindView(R.id.geQuImg)
    ImageView geQuImg;
    @BindView(R.id.gqName)
    TextView gqName;
    @BindView(R.id.gsName)
    TextView gsName;
    @BindView(R.id.mstop)
    ImageView mstop;
    @BindView(R.id.micon)
    ImageView micon;
    @BindView(R.id.flayout)
    FrameLayout flayout;
    @BindView(R.id.dl)
    DrawerLayout dl;
    @BindView(R.id.cuo)
    TextView cuo;
    @BindView(R.id.iv_img)
    ImageView iv_img;
    private FragmentTransaction transaction1;
    private FragMindActivity fragMindActivity;
    private static final int PHOTO_REQUEST_CAREMA = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果
    /* 头像名称 */
    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File tempFile;
    private Dialog mCameraDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        //设置边界滑动关闭   默认关闭
//        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //设置边界滑动打开   默认打开
        dl.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);

//        FragmentManager manager1 = getSupportFragmentManager();
//        transaction1 = manager1.beginTransaction();
//        fragMindActivity = new FragMindActivity();
//        transaction1.add(R.id.flayout, fragMindActivity);
//        transaction1.commit();
        //自动触发一次点击事件（空间必须是Buuton）
        mind.performClick();
    }

    @OnClick({R.id.mind, R.id.musics, R.id.tuiJian, R.id.ceHua, R.id.cuo, R.id.souSuo, R.id.tuichu,R.id.sheZhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mind:
                FragmentManager manager1 = getSupportFragmentManager();
                transaction1 = manager1.beginTransaction();
                fragMindActivity = new FragMindActivity();
                transaction1.replace(R.id.flayout, fragMindActivity);
                transaction1.commit();
                //自动触发一次点击事件（空间必须是Buuton）
                view.performClick();
                mind.setTextColor(Color.YELLOW);
                mind.setTextSize(22);
                musics.setTextColor(Color.WHITE);
                musics.setTextSize(18);
                tuiJian.setTextColor(Color.WHITE);
                tuiJian.setTextSize(18);
                break;
            case R.id.musics:
                FragmentManager manager2 = getSupportFragmentManager();
                FragmentTransaction transaction2 = manager2.beginTransaction();
                FragMusicsActivity fragMusicsActivity = new FragMusicsActivity();
                transaction2.add(R.id.flayout, fragMusicsActivity);
                transaction2.commit();
                musics.setTextColor(Color.YELLOW);
                musics.setTextSize(22);
                mind.setTextColor(Color.WHITE);
                mind.setTextSize(18);
                tuiJian.setTextColor(Color.WHITE);
                tuiJian.setTextSize(18);
                break;
            case R.id.tuiJian:
                FragmentManager manager3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = manager3.beginTransaction();
                FragTuiJIanActivity fragTuiJIanActivity = new FragTuiJIanActivity();
                transaction3.add(R.id.flayout, fragTuiJIanActivity);
                transaction3.commit();
                tuiJian.setTextColor(Color.YELLOW);
                tuiJian.setTextSize(22);
                mind.setTextColor(Color.WHITE);
                mind.setTextSize(18);
                musics.setTextColor(Color.WHITE);
                musics.setTextSize(18);
                break;
            case R.id.souSuo:
                Intent intent = new Intent(MusicActivity.this, FragSouSuoActivity.class);
                startActivity(intent);
                //隐藏布局
//            time1.setVisibility(View.GONE);
                break;
            case R.id.ceHua:
                //打开侧滑菜单
                dl.openDrawer(Gravity.LEFT);
                break;
            case R.id.cuo:
                //关闭侧滑菜单
                dl.closeDrawers();
                break;
            case R.id.iv_img:
                //弹出对话框
                setDialog();
                break;
            case R.id.tuichu:
                //退出应用
                doDialog();
                break;
            case R.id.sheZhi:
                //退出应用
                Intent i = new Intent(MusicActivity.this,SheZheActivity.class);
                startActivity(i);
                break;
        }
    }
    //退出对话框
    private void doDialog(){
        AlertDialog.Builder myDialog = new AlertDialog.Builder(MusicActivity.this)
                .setIcon(R.drawable.hulu)
                .setTitle("是否退出应用？");
        myDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MusicActivity.this.finish();
            }
        });
        myDialog.setNegativeButton("取消",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        myDialog.show();
    }
    //这里就是显示底部状态栏
    private void setDialog() {
        mCameraDialog = new Dialog(this, R.style.BottomDialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.bottom_dialog, null);
        //初始化视图

        root.findViewById(R.id.bt_xiangce).setOnClickListener(this);
        root.findViewById(R.id.bt_camera).setOnClickListener(this);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
//        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = root.getMeasuredHeight();

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_img:
                //弹出对话框
                setDialog();
                break;
            case R.id.bt_camera:
                Toast.makeText(this, "正在打开相机", Toast.LENGTH_SHORT).show();
                // 激活相机
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                // 判断存储卡是否可以用，可用进行存储
                if (hasSdcard()) {
                    tempFile = new File(Environment.getExternalStorageDirectory(), PHOTO_FILE_NAME);
                    // 从文件中创建uri
                    Uri uri = Uri.fromFile(tempFile);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                }
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CAREMA
                startActivityForResult(intent, PHOTO_REQUEST_CAREMA);
                mCameraDialog.dismiss();
                break;
            case R.id.bt_xiangce:
                // 激活系统图库，选择一张图片
                Toast.makeText(this, "正在打开图库", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(Intent.ACTION_PICK);
                intent1.setType("image/*");
                // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_GALLERY
                startActivityForResult(intent1, PHOTO_REQUEST_GALLERY);
                mCameraDialog.dismiss();
                break;

        }
    }
    /*
     * 判断sdcard是否被挂载
     */
    private boolean hasSdcard() {
        //判断ＳＤ卡手否是安装好的　　　media_mounted
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    /*
     * 剪切图片
     */
    private void crop(Uri uri) {
        // 裁剪图片意图
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // 裁剪框的比例，1：1
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // 裁剪后输出图片的尺寸大小
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);

        intent.putExtra("outputFormat", "JPEG");// 图片格式
        intent.putExtra("noFaceDetection", true);// 取消人脸识别
        intent.putExtra("return-data", true);
        // 开启一个带有返回值的Activity，请求码为PHOTO_REQUEST_CUT
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }
    /**
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PHOTO_REQUEST_GALLERY) {
            // 从相册返回的数据
            if (data != null) {
                // 得到图片的全路径
                Uri uri = data.getData();
                crop(uri);
            }
        } else if (requestCode == PHOTO_REQUEST_CAREMA) {
            // 从相机返回的数据
            if (hasSdcard()) {
                crop(Uri.fromFile(tempFile));
            } else {
                Toast.makeText(this, "未找到存储卡，无法存储照片！", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PHOTO_REQUEST_CUT) {
            // 从剪切图片返回的数据
            if (data != null) {
                Bitmap bitmap = data.getParcelableExtra("data");
                /**
                 * 获得图片
                 */
                iv_img.setImageBitmap(bitmap);
                //保存到SharedPreferences
                saveBitmapToSharedPreferences(bitmap);
            }
            try {
                // 将临时文件删除
                tempFile.delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //保存图片到SharedPreferences
    private void saveBitmapToSharedPreferences(Bitmap bitmap) {
        // Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        //第一步:将Bitmap压缩至字节数组输出流ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 80, byteArrayOutputStream);
        //第二步:利用Base64将字节数组输出流中的数据转换成字符串String
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String imageString = new String(Base64.encodeToString(byteArray, Base64.DEFAULT));
        //第三步:将String保持至SharedPreferences

        SharedPreferences sharedPreferences = this.getSharedPreferences("testSP", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("image", imageString);
        editor.commit();

        //上传头像
        setImgByStr(imageString, "");
    }

    /**
     * 上传头像       此处使用用的OKHttp post请求上传的图片
     *
     * @param imgStr
     * @param imgName
     */
    public void setImgByStr(String imgStr, String imgName) {
        String url = "http://120.27.23.105/file/upload";
        Map<String, String> params = new HashMap<String, String>();
        params.put("id", "参数值");//
        params.put("data", imgStr);
        OkHttp.postAsync(url, params, new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {
                Log.i("上传失败", "失败" + request.toString() + e.toString());
            }

            @Override
            public void requestSuccess(String result) throws Exception {
                Log.i("上传成功", result);
            }
        });
    }

    //从SharedPreferences获取图片
    private void getBitmapFromSharedPreferences() {

        SharedPreferences sharedPreferences = this.getSharedPreferences("testSP", Context.MODE_PRIVATE);
        //第一步:取出字符串形式的Bitmap
        String imageString = sharedPreferences.getString("image", "");
        //第二步:利用Base64将字符串转换为ByteArrayInputStream
        byte[] byteArray = Base64.decode(imageString, Base64.DEFAULT);
        if (byteArray.length == 0) {
            iv_img.setImageResource(R.drawable.touxiang);
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArray);

            //第三步:利用ByteArrayInputStream生成Bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(byteArrayInputStream);
            iv_img.setImageBitmap(bitmap);
        }

    }
}
