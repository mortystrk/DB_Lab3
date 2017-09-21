package igor.bstu.by.db3;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    TextView absolute, name, path, readWrite, external;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView
        absolute = (TextView) findViewById(R.id.textViewAbsolute);
        name = (TextView) findViewById(R.id.textViewName);
        path = (TextView) findViewById(R.id.textViewPath);
        readWrite = (TextView) findViewById(R.id.textViewRW);
        external = (TextView) findViewById(R.id.textViewExternal);
    }

    public void onGetFileDir(View v){
        ClearTextView();
        file = super.getFilesDir();
        GetInfo(file);
    }

    public void onGetCacheDir(View v){
        ClearTextView();
        file = super.getCacheDir();
        GetInfo(file);
    }

    public void onGetTextExternalFilesDir(View v){
        ClearTextView();

        String storageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(storageState)) {
            file = super.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
            GetInfo(file);
        }
        else{
            absolute.setText("Absolute: External not mounted" );
            name.setText("Name: External not mounted" );
            path.setText("Path: External not mounted" );
            readWrite.setText("Read/Write: External not mounted" );
            external.setText("External: External not mounted" );
        }
    }

    public void onGetExternalCacheDir(View v){
        ClearTextView();

        String storageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(storageState)) {
            file = super.getExternalCacheDir();
            GetInfo(file);
        }
        else{
            absolute.setText("Absolute: External not mounted" );
            name.setText("Name: External not mounted" );
            path.setText("Path: External not mounted" );
            readWrite.setText("Read/Write: External not mounted" );
            external.setText("External: External not mounted" );
        }
    }

    public void onGetExternalStorageDirectory(View v){
        ClearTextView();

        String storageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(storageState)) {
            file = Environment.getExternalStorageDirectory();
            GetInfo(file);
        }
        else{
            absolute.setText("Absolute: External not mounted" );
            name.setText("Name: External not mounted" );
            path.setText("Path: External not mounted" );
            readWrite.setText("Read/Write: External not mounted" );
            external.setText("External: External not mounted" );
        }
    }

    public void onGetExternalStoragePublicDirectory(View v){
        ClearTextView();

        String storageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(storageState)) {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            GetInfo(file);
        }
        else{
            absolute.setText("Absolute: External not mounted" );
            name.setText("Name: External not mounted" );
            path.setText("Path: External not mounted" );
            readWrite.setText("Read/Write: External not mounted" );
            external.setText("External: External not mounted" );
        }
    }

    public void GetInfo(File file){
        String read, write;
        absolute.append(file.getAbsolutePath());
        name.append(file.getName());
        path.append(file.getPath());
        external.append(Environment.getExternalStorageState());
        if(file.canRead())
            read = "Yes";
        else
            read = "No";
        if(file.canWrite())
            write = "Yes";
        else
            write = "No";
        readWrite.append(read + "/" + write);
    }

    public void ClearTextView(){
        absolute.setText("Absolute: ");
        name.setText("Name: ");
        path.setText("Path: ");
        readWrite.setText("Read/Write: ");
        external.setText("External: ");
    }
}
