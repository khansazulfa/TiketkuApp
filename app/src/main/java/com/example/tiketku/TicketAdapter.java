package com.example.tiketku;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TicketAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<TicketAdapter.MyViewHolder>{

    Context context;
    ArrayList<MyTIcket> myTicket;

    public TicketAdapter (Context c, ArrayList<MyTIcket> p){
        context = c;
        myTicket = p;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_myticket, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.xnama_wisata.setText(myTicket.get(i).getNama_wisata());
        myViewHolder.xlokasi.setText(myTicket.get(i).getLokasi());
        myViewHolder.xjumlah_ticket.setText(myTicket.get(i).getJumlah_ticket() + " Tickets");

        final String getNamaWisata = myTicket.get(i).getNama_wisata();

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotomyticketdetail = new Intent(context, MyTicketDetailAct.class);
                gotomyticketdetail.putExtra("nama_wisata", getNamaWisata);
                context.startActivity(gotomyticketdetail);
            }
        });

    }

    @Override
    public int getItemCount() {

        return myTicket.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView xnama_wisata, xlokasi, xjumlah_ticket;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            xnama_wisata = itemView.findViewById(R.id.xnama_wisata);
            xlokasi = itemView.findViewById(R.id.xlokasi);
            xjumlah_ticket = itemView.findViewById(R.id.xjumlah_ticket);
        }
    }
}