import "./ToDo.css";

import { useEffect, useState } from "react";

const API_URL = "http://localhost:8080";

export function ToDo(props) {
  const [pessoas, setPessoas] = useState([]);
  const [newPessoa, setNewPessoa] = useState({ nome: "", idade: 1 });
  const [selectedPessoa, setSelectedPessoa] = useState(null);

  useEffect(() => {
    getPessoas();
  }, []);

  function getPessoas() {
    fetch(API_URL + "/getPessoas")
      .then((response) => {
        console.log(response);
        // Validar se o pedido foi feito com sucesso. Pedidos são feitos com sucesso normalmente quando o status é entre 200 e 299
        if (response.status !== 200) {
          throw new Error("There was an error finding pessoas");
        }

        return response.json();
      })
      .then((parsedResponse) => {
        console.log(parsedResponse);
        setPessoas(parsedResponse);
        //Como ele só chega aqui se tiver sucesso basta atualizar a variavel Pessoas
        //setPessoasList(parsedResponse);
        //console.log(parsedResponse);
      })
      .catch((error) => {
        alert(error);
      });
  }

  function addPessoa() {
    if (newPessoa.nome.trim().length !== 0 && newPessoa.idade > 0) {
      fetch(API_URL + "/addPessoa/2", {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: {
          nome: "Maria Joana",
          idade: 82,
        },
      })
        .then((response) => {
          // Validar se o pedido foi feito com sucesso. Pedidos são feitos com sucesso normalmente quando o status é entre 200 e 299
          if (response.status !== 200) {
            throw new Error("There was an error finding pessoas");
          }

          return response.json();
        })
        .then((parsedResponse) => {
          if (!parsedResponse.status) {
            alert(parsedResponse.message);
            return;
          }
          // Precisamos de refrescar a lista, se tivessemos o id bastava adicionar um novo com o id
          getPessoas();
        })
        .catch((error) => {
          alert(error);
        });
    }
  }

  /* function addTodo() {
    if (newToDo.trim().length !== 0) {
      //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
      let pessoasAux = pessoas;

      let newTodoAux = newToDo;

      //Adicionamos um elemento à lista temporaria
      pessoasAux = [newTodoAux, ...pessoasAux];

      //definimos o estado como a nossa nova lista
      setPessoas(pessoasAux);
    }
  } */

  function removePessoa(indice) {
    /*
    //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
    let pessoasAux = pessoas;

    //Filtramos o que não queremos
    pessoasAux = pessoasAux.filter((e, i) => i !== indice);

    //Da set do selecionado a null caso seja apagado
    if (selectedToDo === indice) {
      setSelectedToDo(null);
    }

    //definimos o estado como a nossa nova lista
    setPessoas(pessoasAux);*/
  }

  function updatePessoa() {
    //Fazer uma copia dos 'to dos' que temos atualmente para evitar estragos colaterais
    /*   let pessoasAux = pessoas;

    pessoasAux = pessoasAux.map((todo, index) => {
      if (selectedToDo === index) {
        todo = newToDo;
      }
      return todo;
    });

    setPessoas(pessoasAux);*/
  }

  return (
    <>
      <header className="App-header">
        <h3>Lista por nome da pessoa</h3>
      </header>

      {/*       {pessoas.map((e) => {
        console.log(e);
        return (
          <div key={e.id}>
            <p>{e.id}</p>
            <p>{e.name}</p>
            <p>{e.age}</p>
          </div>
        );
      })} */}

      <section className="list-container">
        {pessoas.map(function (element, index) {
          return (
            <div key={index} className="todo-card">
              <p className="todo-text" onClick={() => setSelectedPessoa(index)}>
                {element.nome}
              </p>
              <button
                className="todo-remove"
                onClick={() => removePessoa(index)}
              >
                X
              </button>
            </div>
          );
        })}
      </section>

      <div>
        <p>Pessoa selecionada: {selectedPessoa}</p>
        <input
          type="text"
          value={newPessoa}
          onChange={(e) => {
            setNewPessoa(e.target.value);
          }}
        />
        <button onClick={addPessoa}>Adicionar</button>
        <button onClick={updatePessoa}>Atualizar</button>
        <button onClick={removePessoa}>Remover</button>
      </div>
    </>
  );
}
