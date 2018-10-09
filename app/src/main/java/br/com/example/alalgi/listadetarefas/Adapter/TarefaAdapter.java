package br.com.example.alalgi.listadetarefas.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.example.alalgi.listadetarefas.Model.Tarefa;
import br.com.example.alalgi.listadetarefas.R;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewRolder> {

    private List<Tarefa> listaTarefas;

    public TarefaAdapter(List<Tarefa> lista) {
        this.listaTarefas = lista;
    }

    @NonNull
    @Override
    public MyViewRolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista_tarefa_adapter,parent, false);

        return new MyViewRolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewRolder holder, int position) {
        Tarefa tarefa = listaTarefas.get(position);
        holder.tarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewRolder extends  RecyclerView.ViewHolder{

        TextView tarefa;

        public MyViewRolder(View itemView) {
            super(itemView);

            tarefa = itemView.findViewById(R.id.textTarefa);

        }
    }

}
