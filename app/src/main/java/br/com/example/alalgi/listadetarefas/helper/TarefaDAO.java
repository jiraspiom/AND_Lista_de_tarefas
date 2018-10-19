package br.com.example.alalgi.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.example.alalgi.listadetarefas.Model.Tarefa;

public class TarefaDAO implements ITarefaDAO {

    SQLiteDatabase escreve;
    SQLiteDatabase le;

    public TarefaDAO(Context context) {
        BdHelper db = new BdHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();

    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            escreve.insert(BdHelper.TABELA_TAREFA, null, cv);
            Log.i("BD INFO", "Tarefa salva com sucesso");
        }catch (Exception e){
            Log.i("BD INFO", "Erro ao salvar tarefa " + e.getMessage());
            return  false;
        }
        return true;

    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try{
            String[] args = {tarefa.getId().toString()};
            escreve.update(BdHelper.TABELA_TAREFA, cv, "id=?", args);
            Log.i("BD INFO", "Tarefa atualizada com sucesso");

        }catch (Exception e){
            Log.i("BD INFO", "erro ao atualiza tarefa");
            return false;
        }

        return true;

    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = "SELECT * FROM " + BdHelper.TABELA_TAREFA + " ;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Tarefa tarefa = new Tarefa();

            long id = c.getLong(c.getColumnIndex("id"));
            String nome = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nome);

            tarefas.add(tarefa);
        }

        return tarefas;
    }
}
