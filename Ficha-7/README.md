# 1. Teste Empresa

## 1.1. Adicionar empresa 

Pedido ```Post``` para ```localhost:8080/addEmpresa``` com o seguinte corpo:

```
{
    "nome":"empresa 1",
    "morada":"Rua do Castanheiro"
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Sucesso ao inserir a empresa"
}
```

## 1.2. Obter todas as empresas 

Pedido ```Get``` para ```localhost:8080/getAllEmpresas```:

Exemplo de resposta:

```
[
    {
        "nome": "Empresa 1",
        "morada": "Rua do Castanheiro",
        "numeroFuncionariosAtual": 0,
        "numeroFuncionariosDesdeCriacao": 0,
        "listaPessoas": [],
        "id": "83a6f488-dbde-412c-86e6-ebca8c43c578"
    },
    {
        "nome": "Empresa 2",
        "morada": "Caminho de Santo Antonio",
        "numeroFuncionariosAtual": 0,
        "numeroFuncionariosDesdeCriacao": 0,
        "listaPessoas": [],
        "id": "54c6bbbb-c0d6-4aa2-9444-1deb6aae56ba"
    }
]

```

## 1.3. Obter empresa pelo id

Pedido ```Get``` para ```localhost:8080/geEmpresaById``` com o seguinte corpo:

```
{
    "id": "54c6bbbb-c0d6-4aa2-9444-1deb6aae56ba"
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Empresa Encontrada",
    "empresa": {
        "nome": "Empresa 2 Atualizado",
        "morada": "Caminho de Santo Antonio Atualizado",
        "numeroFuncionariosAtual": 0,
        "numeroFuncionariosDesdeCriacao": 0,
        "listaPessoas": [],
        "id": "54c6bbbb-c0d6-4aa2-9444-1deb6aae56ba"
    }
}
```

## 1.4. Remover empresa 

Pedido ```Delete``` para ```localhost:8080/addEmpresa``` com o seguinte corpo:

```
{
    "id":"83a6f488-dbde-412c-86e6-ebca8c43c578"
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Sucesso ao remover a empresa"
}
```

## 1.5. Update empresa

Pedido ```Put``` para ```localhost:8080/updateEmpresa``` com o seguinte corpo:

```
{
    "nome": "Empresa 2 Atualizado",
    "morada": "Caminho de Santo Antonio Atualizado",
    "id": "54c6bbbb-c0d6-4aa2-9444-1deb6aae56ba"
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Sucesso ao atualizar a empresa"
}
```

# 2. Teste Pessoa

## 2.1. Adicionar Pessoa
Pedido ```Post``` para ```localhost:8080/addPessoa``` com o seguinte corpo:

```
{
    "empresa":{
        "id":"54c6bbbb-c0d6-4aa2-9444-1deb6aae56ba"
    },
    "pessoa":{
        "nome":"David",
        "idade": 30,
        "email":"davidedamata@gmail.com"
    }
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Pessoa adicionada a empresa"
}
```

## 2.2. Obter todas as empresas 

Pedido ```Get``` para ```localhost:8080/getPessoas```:

Exemplo de resposta:

```
[
    {
        "nome": "David",
        "idade": 30,
        "email": "davidedamata@gmail.com",
        "id": "fac5d40e-9bb2-4315-94ad-3da069f38340"
    }
]

```


## 2.3. Obter pessoa pelo id

Pedido ```Get``` para ```localhost:8080/geEmpresaById``` com o seguinte corpo:

```
{
    "id":"fac5d40e-9bb2-4315-94ad-3da069f38340"
}
```

Exemplo de resposta:

```
{
    "statusOk": true,
    "message": "Pessoa encontrada com sucesso",
    "pessoa": {
        "nome": "David",
        "idade": 30,
        "email": "davidedamata@gmail.com",
        "id": "fac5d40e-9bb2-4315-94ad-3da069f38340"
    }
}
```
