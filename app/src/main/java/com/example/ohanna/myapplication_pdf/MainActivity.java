package com.example.ohanna.myapplication_pdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PDFTools pdfTools;
    final int set=0;
    Button button;
    private Context context;
    Intent intent,intent1;
    PackageManager packageManager;
    ResolveInfo resolveInfo;
    ActivityInfo activityInfo;
    String aPackage,name;
    ComponentName componentName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pdfTools=new PDFTools();
        button=(Button)findViewById(R.id.button);
        context = getApplicationContext();
         intent1 = new Intent().setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER);
         packageManager = context.getPackageManager();
         resolveInfo = packageManager.resolveActivity(intent1, set);
         activityInfo = resolveInfo.activityInfo;
         aPackage = activityInfo.packageName;
         name = activityInfo.name;
         componentName = new ComponentName(aPackage, name);
        Toast.makeText(this, aPackage+" "+name, Toast.LENGTH_SHORT).show();
         intent = new Intent().setAction(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_LAUNCHER).setComponent(componentName).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /*Create an intent with action=MAIN and category=LAUNCHER
Get the PackageManager from the current context using context.getPackageManager
packageManager.queryIntentActivity(<intent>, 0) where intent has category=LAUNCHER, action=MAIN or packageManager.resolveActivity(<intent>, 0) to get the first activity with main/launcher
Get theActivityInfo you're interested in
From the ActivityInfo, get the packageName and name
Finally, create another intent with with category=LAUNCHER, action=MAIN, componentName = new ComponentName(packageName, name) and setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
Finally, context.startActivity(newIntent)*/


    private void buttoncall(){
        startActivity(intent);
        finish();
    }
}
