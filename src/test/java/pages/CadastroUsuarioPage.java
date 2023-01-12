package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.Comands.*;

public class CadastroUsuarioPage extends RunCucumber {

    // elementos
    private String finalMessage = "Cadastro realizado!";
    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoFazerCadastro= By.id("btnRegister");
    private By campoCadastroSucesso = By.id("swal2-title");

    // ações / funções / métodos
    public void preencheNome(String nome){
         fillField(campoNome, nome);
    }
    public void preencheEmail(String email){
         fillField(campoEmail, email);
    }

    public void preencherSenha(String senha){
        fillField(campoSenha, senha);
    }

    public void cadastrarUsuario(){
        clickElement(botaoFazerCadastro);
    }

    public void verificaCadastroSucesso(){
        checkMessage(campoCadastroSucesso, finalMessage);
    }
}
