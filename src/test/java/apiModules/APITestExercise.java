package apiModules;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITestExercise {
//    Teste 1
//    Feature: Atualização parcial de usuário
//    Cenario: Atualizar apenas o campo "job" do usuário
//    DADO que o usuário com ID 2 existe no sistema
//    QUANDO eu envio uma requisição PATCH para "/api/users/2" com os seguintes dados:
//    | job       |
//    | Developer |
//    ENTÃO o sistema deve retornar o status code 200
//    E o campo "job" deve estar atualizado como "Developer"

    @Test
    public void updateUserPartiallyWithPatch() {
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject(map);

        request.put("job", "Developer");

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType("application/json").
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();
    }

//    Teste 2
//    Feature: Login de Usuário Existente
//    Cenario: Logar com o usuário e ver se ele é logado com sucesso no sistema
//    DADO que um usuário válido já existe
//    QUANDO ele tenta fazer login com as credenciais corretas
//    ENTÃO a api retorna um token de autenticação
    @Test
    public void loginValidatedUser() {
        Map<String, Object> map = new HashMap<String, Object>();

        JSONObject request = new JSONObject(map);

        request.put("email", "eve.holt@reqres.in");
        request.put("password", "cityslicka");

        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType("application/json").
                body(request.toJSONString()).
                when().
                post("/login").
                then().
                statusCode(200).
                body("token", notNullValue()).
                log().all();
    }

//    Teste 3
//    Feature: Obter detalhes de um usuário
//    Cenario: Obter detalhes de um usuário existente
//    DADO que um usuário com ID 4 existe
//    QUANDO eu envio uma requisição GET para "/api/users/4"
//    ENTÃO o sistema deve retornar o status code 200
//    E o campo "id" deve ser 4
    @Test
    public void getUserDetails() {
        baseURI = "https://reqres.in/api";

        given().
                when().
                get("/users/4").
                then().
                statusCode(200).
                body("data.id", equalTo(4)).
                log().all();
    }
}
