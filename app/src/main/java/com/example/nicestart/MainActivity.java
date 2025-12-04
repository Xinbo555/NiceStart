package com.example.nicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    private WebView miVisorWeb;

    private SwipeRefreshLayout swipeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        WebView mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);

        swipeLayout = findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


        miVisorWeb = findViewById(R.id.vistaweb);

        String html = "<html>"+
                "<head><style>"+
                "html, body { margin:0; padding:0; height:100%; overflow:hidden; }"+
                "img { width:100%; height:100%; object-fit:cover; }"+
                "</style></head>" +
                "</body>" +
                "<img src = 'https://thispersondoesnotexist.com' />"+
                "</body></html>";

        miVisorWeb.loadDataWithBaseURL(null, html, "text/html", "UTF-8",null);
    }
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = ()->{
        Toast toast0 = Toast.makeText(MainActivity.this, "Hithere!",Toast.LENGTH_LONG);
        toast0.show();
        miVisorWeb.reload();
        swipeLayout.setRefreshing(false);
    };

    // IMPLEMENTING CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId() == R.id.item0) {
            Toast toast = Toast.makeText(this, "Item copied", Toast.LENGTH_LONG);
            toast.show();
        } else if(item.getItemId() == R.id.item2) {
            Toast toast2 = Toast.makeText(this,"Downloading item...", Toast.LENGTH_LONG);
            toast2.show();
        }
        return false;
    }

    public void showAlertDialogButtonClicked(MainActivity mainActivity){
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

        builder.setTitle("setTitle");

        builder.setMessage("A donde quieres ir");
        builder.setCancelable(true);

        builder.setPositiveButton("Scrolling",(dialog,which)->{
            Intent intent = new Intent(MainActivity.this,Login.class);
            Toast toast = Toast.makeText(this, "Scrolling...", Toast.LENGTH_LONG);
            toast.show();
        });

        builder.setNegativeButton("Do nothing",(dialog,which)->dialog.dismiss());

        builder.setNeutralButton("Other",(dialog,which)->System.exit(0));

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item3){
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    //IMPLEMENTING APPBAR MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_appbar,menu);
        return true;
    }
}