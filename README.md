# IPConfig
修改手机ip地址，通过手机全局广播实现

使用方式：在baseActivity 中，onCreate 中去注册，onDestory 销毁。

public class MainActivity extends AppCompatActivity {

    ConfigReceiver configReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configReceiver = new ConfigReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ktakilat.loan.ipConfig");
        registerReceiver(configReceiver, intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(configReceiver);
    }
}


public class ConfigReceiver extends BroadcastReceiver {
    
    public static final String ACTION_INTENTFILER_IP = "xxx";  //这里要和广播的发送内容相对应，这样才能接受广播并重启app，修改host的url。
    //public static final String
    private static final String TAG = "ConfigReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().contains("xxx") ){
            final Intent restartAppIntent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            restartAppIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(restartAppIntent);
            //android.os.Process.killProcess(android.os.Process.myPid());
            String ip = intent.getStringExtra(ACTION_INTENTFILER_IP);

            Log.d(TAG, "onReceive: " + ip);


        }
    }
}
