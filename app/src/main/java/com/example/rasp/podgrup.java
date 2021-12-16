package com.example.rasp;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class podgrup extends AppCompatActivity {
    Button Save;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    StorageReference ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.podgrup);

       // Save = findViewById(R.id.Save);

       // Save.setOnClickListener(new View.OnClickListener() {
         //   @Override
        //    public void onClick(View v) {
         //        onClickSav();
         //   }
        //});
    }

    public void onClickOne(View view) {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(podgrup.this, weekw.class);
        intent.putExtra("podgrup", "1");
        intent.putExtra("kurs", kurs);
        intent.putExtra("grup", grup);
        intent.putExtra("level", level);
        startActivity(intent);
    }

    public void onClickTwo(View view) {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        String grup = i.getStringExtra("grup");
        String level = i.getStringExtra("level");
        Intent intent = new Intent(podgrup.this, weekw.class);
        intent.putExtra("podgrup", "2");
        intent.putExtra("kurs", kurs);
        intent.putExtra("grup", grup);
        intent.putExtra("level", level);
        startActivity(intent);
    }

    public void onClickSav(View view) {
        Intent i = getIntent();
        String kurs = i.getStringExtra("kurs");
        storageReference=firebaseStorage.getInstance().getReference();
        if(kurs.equals("3"))
        {
            ref = storageReference.child("FEIS3.pdf");
        }
        else if(kurs.equals("2")) {
            ref = storageReference.child("FEIS2.xls");
        }
            ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Intent i = getIntent();
                    String kurs = i.getStringExtra("kurs");
                    String url=uri.toString();
                    if(kurs.equals("3"))
                    {
                        downloadFile(podgrup.this,"FEIS3",".pdf",DIRECTORY_DOWNLOADS,url);

                    }
                    else if(kurs.equals("2")) {
                        downloadFile(podgrup.this,"FEIS2",".xls",DIRECTORY_DOWNLOADS,url);
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        ;
    }
    public void downloadFile(Context context,String filename,String fileExtension,
                             String destinationDirectory, String url)
    {
        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        request.setNotificationVisibility(DownloadManager.
                Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,filename + fileExtension);
        downloadManager.enqueue(request);
    }
}

       // String pdfPath = Environment.getExternalStoragePublicDirectory
         //       (Environment.DIRECTORY_DOWNLOADS).toString();
       // File file = new File(pdfPath,"myPDF.pdf");
       // OutputStream outputStream = new FileOutputStream(file);

       // PdfWriter writer = new PdfWriter(file);
      //  PdfDocument pdfDocument = new PdfDocument(writer);
       // Document document = new Document(pdfDocument);


