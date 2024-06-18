package com.albertoochoa.albertoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MisVehiculos extends AppCompatActivity {

    private Button btn_regresar_misvehiculos;
    private RecyclerView recyclerView;
    private VehiculoAdapter vehiculoAdapter;
    private List<Vehiculo> vehiculoList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mis_vehiculos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_regresar_misvehiculos = findViewById(R.id.btn_regresar_misvehiculos);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vehiculoList = new ArrayList<>();
        vehiculoAdapter = new VehiculoAdapter(vehiculoList);
        recyclerView.setAdapter(vehiculoAdapter);

        databaseReference = FirebaseDatabase.getInstance().getReference("vehiculos");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                vehiculoList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Vehiculo vehiculo = dataSnapshot.getValue(Vehiculo.class);
                    vehiculoList.add(vehiculo);
                }
                vehiculoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Manejar error
            }
        });

        btn_regresar_misvehiculos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irMisVehiculosV();
            }
        });
    }

    public void irMisVehiculosV(){
        Intent intent = new Intent(this, Vehiculos.class);
        startActivity(intent);
    }
}
