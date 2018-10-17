package br.com.example.alalgi.listadetarefas.helper;

import java.util.List;

import br.com.example.alalgi.listadetarefas.Model.Tarefa;

public interface ITarefaDAO {
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();

}
