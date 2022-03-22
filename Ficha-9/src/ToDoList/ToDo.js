import { useState } from "react";

import "./ToDo.css";

export function ToDo() {
  const [toDoList, setTodos] = useState([
    "Aprender React",
    "Aprender o useState",
  ]);
  const [newToDo, setNewToDo] = useState("");
  const [selectedToDo, setSelectedToDo] = useState(null);

  function addTodo() {
    if (newToDo.trim().length !== 0) {
      //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
      let todoListAux = toDoList;

      let newTodoAux = newToDo;

      //Adicionamos um elemento à lista temporaria
      todoListAux = [newTodoAux, ...todoListAux];

      //definimos o estado como a nossa nova lista
      setTodos(todoListAux);
    }
  }

  function removeTodo(indice) {
    //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
    let todoListAux = toDoList;

    //Filtramos o que não queremos
    todoListAux = todoListAux.filter((e, i) => i !== indice);

    //Da set do selecionado a null caso seja apagado
    if (selectedToDo === indice) {
      setSelectedToDo(null);
    }

    //definimos o estado como a nossa nova lista
    setTodos(todoListAux);
  }

  function updateTodo() {
    //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
    let todoListAux = toDoList;

    todoListAux = todoListAux.map((todo, index) => {
      if (selectedToDo === index) {
        todo = newToDo;
      }
      return todo;
    });

    setTodos(todoListAux);
  }

  return (
    <>
      <header className="App-header">
        <h3>Todo list by "Insert Student Name"</h3>
      </header>

      <section className="list-container">
        {toDoList.map(function (element, index) {
          return (
            <div key={index} className="todo-card">
              <p className="todo-text" onClick={() => setSelectedToDo(index)}>
                {element}
              </p>
              <button className="todo-remove" onClick={() => removeTodo(index)}>
                X
              </button>
            </div>
          );
        })}
      </section>

      <div>
        <p>Selected Todo: {selectedToDo}</p>
        <input
          type="text"
          value={newToDo}
          onChange={(e) => {
            setNewToDo(e.target.value);
          }}
        />
        <button onClick={addTodo}>Add Todo</button>
        <button onClick={updateTodo}>Update Todo</button>
      </div>
    </>
  );
}
