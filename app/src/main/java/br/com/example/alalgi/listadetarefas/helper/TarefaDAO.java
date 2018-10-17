package br.com.example.alalgi.listadetarefas.helper;

import java.util.List;

import br.com.example.alalgi.listadetarefas.Model.Tarefa;

public class TarefaDAO extends ITarefaDAO {

    @Override
    public boolean salvar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
