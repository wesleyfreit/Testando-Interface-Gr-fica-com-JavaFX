import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class MenuController {

    // Botões de seleção do home
    @FXML
    private Button botaoCadastro;

    @FXML
    private Button botaoEdicao;

    @FXML
    private Button botaoRemocao;

    @FXML
    private Button botaoReposicao;

    @FXML
    private Button botaoVenda;

    @FXML
    private Button botaoVisualizacao;

    // Exibir o layout de cadastro
    @FXML
    private Pane menuCadastro;

    // Botao de seleção de tipo de conta no layout cadastro
    @FXML
    private MenuButton selectTipoConta;

    // Campos input do layout de cadastro
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoCpf;

    @FXML
    private TextField campoNumConta;

    @FXML
    private TextField campoSaldo;

    // Label com nome de um atributo do layout cadastro
    @FXML
    private Label textSaldo;

    // Ações de evento
    @FXML
    void cadastrarProdutos(ActionEvent event) {
        menuCadastro.setVisible(true);
    }

    @FXML
    void visualizarProdutos(ActionEvent event) {
        
    }

    @FXML
    void editarProdutos(ActionEvent event) {

    }

    @FXML
    void removerProdutos(ActionEvent event) {

    }

    @FXML
    void reporProdutos(ActionEvent event) {

    }

    @FXML
    void venderProdutos(ActionEvent event) {

    }

    @FXML
    void eventCC(ActionEvent event) {
        selectTipoConta.setText("Conta Corrente");
        textSaldo.setVisible(true);
        campoSaldo.setVisible(true);
    }

    @FXML
    void eventCP(ActionEvent event) {
        selectTipoConta.setText("Conta Poupança");
        textSaldo.setVisible(false);
        campoSaldo.setVisible(false);
    }

    @FXML
    void fazerCadastro(ActionEvent event) {
        String titular = campoNome.getText();
        String cpfTitular = campoCpf.getText();
        int numero = Integer.parseInt(campoNumConta.getText());

        if (selectTipoConta.getText().equals("Conta Poupança")) {
            ContaPoupanca cadastroPoupança = new ContaPoupanca(numero, titular, cpfTitular);
            App.accounts.add(cadastroPoupança);
        }
        if (selectTipoConta.getText().equals("Conta Corrente")) {
            double saldo = Double.parseDouble(campoSaldo.getText());
            ContaEspecial cadastroEspecial = new ContaEspecial(numero, titular, cpfTitular, saldo);
            App.accounts.add(cadastroEspecial);
        }
        fecharCadastro(event);
    }

    @FXML
    void cancelarCadastro(ActionEvent event) {
        fecharCadastro(event);
    }

    void fecharCadastro(ActionEvent event){
        selectTipoConta.setText("Selecione o tipo de Conta");

        campoNome.setText("");
        campoCpf.setText("");
        campoNumConta.setText("");
        campoSaldo.setText("");

        textSaldo.setVisible(false);
        campoSaldo.setVisible(false);

        menuCadastro.setVisible(false);
    }
}
