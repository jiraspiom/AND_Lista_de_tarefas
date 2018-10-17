package br.com.example.alalgi.listadetarefas.Activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.example.alalgi.listadetarefas.Model.Tarefa;
import br.com.example.alalgi.listadetarefas.R;
import br.com.example.alalgi.listadetarefas.helper.TarefaDAO;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textTarefa);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemSalvar :
                //executa achao para salvar

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa("Tarefa3");

                tarefaDAO.salvar(tarefa);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
