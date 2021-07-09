# Desafio Spring

Este repositório contém o CRUD do desafio spring realizado em grupo.

### Funcionalidades Extras Desenvolvidas

#### Cadastrar um usuário

- #### POST ``` /users ```
    - body request:
    ```
    {
        "name": "usuário novo",
        "isSeller": true
    }
    ```
    | Parâmetro | Tipo | Descrição/Exemplo |
    | --------- | ---- | ----------------- |
    | name      | String| Nome do novo usuário |
    | isSeller  | boolean| Indica se um usuário é ou não um vendedor |

    - body response:
    ```
    {
        "userId": 100,
        "userName": "usuario novo"
    }
    ```
  | Parâmetro | Tipo | Descrição/Exemplo |
  | --------- | ---- | ----------------- |
  | userId    | int  | Id do novo usuário |
  | userName  | String | Nome do usuário cadastrado |

- #### GET ``` /dev/inspect ```
    - Utilizado para checar o estado da aplicação
    - Retorna uma instância do banco de dados