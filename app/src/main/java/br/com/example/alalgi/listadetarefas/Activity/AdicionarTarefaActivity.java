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
    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textTarefa);

        //recuperar tarefa caso seje edicao
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("TarefaSelecionada");

        if (tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }

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
                //executa ação para salvar

                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());

                if (tarefaAtual != null){// edição da tarefa
                    String nomeTarefa = editTarefa.getText().toString();

                    if(!nomeTarefa.isEmpty()){
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());

                        if(tarefaDAO.atualizar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(), "Tarefa atualizada com sucesso", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa", Toast.LENGTH_LONG).show();

                        }

                    }

                }else {// salvar
                    String nomeTarefa = editTarefa.getText().toString();

                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);

                        if (tarefaDAO.salvar(tarefa)){
                            //para apos adicionar uma tarefa fechar a tela
                            finish();
                            Toast.makeText(getApplicationContext(),"Sucesso ao salvar tarefa", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();

                        }



                    }

                }


                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
