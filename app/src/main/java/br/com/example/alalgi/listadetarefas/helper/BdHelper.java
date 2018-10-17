package br.com.example.alalgi.listadetarefas.helper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class BdHelper extends SQLiteOpenHelper {

    public static int VERSAO = 1;
    public static String NOME_DB = "DB_TAREFA";
    public static String TABELA_TAREFA = "tarefas";

    public BdHelper(@Nullable Context context) {
        //factory e apena usado para definicao de cursor, nao sera utilizado
        super(context, NOME_DB, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFA +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "  nome TEXT NOT NULL); ";

        try{

            db.execSQL(sql);
            Log.i("INFO DB", "Sucesso ao criar tabela!");

        }catch (Exception e){
            Log.i("INFO DB", "Erro ao criar a tabela " + e.getMessage());
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA_TAREFA;

        try{
            db.execSQL(sql);
            onCreate(db);
            Log.i("BD INFO", "Bando de dados atualizado com sucesso");

        }catch (Exception e){
            Log.i("DB INFO", "erro ao atulizar bando de dados " + e.getMessage() );
        }
    }
}
