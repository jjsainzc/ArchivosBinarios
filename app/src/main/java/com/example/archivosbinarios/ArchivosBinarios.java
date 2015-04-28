package com.example.archivosbinarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.archivosbinarios.datos.Prueba;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("SimpleDateFormat") 
public class ArchivosBinarios extends Activity {
	private Prueba prueba;
	private TextView resultado;
	private StringBuilder sb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archivos_binarios);

		resultado = (TextView) findViewById(R.id.resultado);
		sb = new StringBuilder();

		File file = getBaseContext().getFileStreamPath("prueba_obj.bin");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			file.delete();
			ObjectOutputStream oos;

			oos = new ObjectOutputStream(openFileOutput(file.getName(),
					Context.MODE_PRIVATE));

			prueba = new Prueba("String A", 1212, sdf.parse("12/11/2012"));
			oos.writeObject(prueba);

			prueba = new Prueba("String B", 3434, new Date());
			oos.writeObject(prueba);

			oos.writeObject(new Prueba("String C", 4545, sdf.parse("30/11/2010")));

			oos.flush();
			oos.close();
		} catch (Exception e) {
			sb.append("ERROR (Escritura) " + e.toString() + "\n");

		}

		try {

			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois;

			ois = new ObjectInputStream(fis);

			while (fis.available() > 0) {
				prueba = (Prueba) ois.readObject();
				sb.append(prueba.getAttrStr()).append(" ")
						.append(prueba.getAttrInt()).append(" ")
						.append(sdf.format(prueba.getAttrDate())).append(" ")
						.append("\n");
			}
			ois.close();
		} catch (Exception e) {
			sb.append("ERROR (Lectura) " + e.toString() + "\n");

		}

		sb.append("\n\n").append("Path archivo:")
				.append(file.getAbsolutePath());

		resultado.setText(sb.toString());
		Toast.makeText(this, "Terminado", Toast.LENGTH_LONG).show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.archivos_binarios, menu);
		return true;
	}

}
