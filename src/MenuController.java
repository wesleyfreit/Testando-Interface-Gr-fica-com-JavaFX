import java.util.List;

import classes.Conta;
import controller.DadosTest;
import controller.ListDados;
import functions.ContaCorrente;
import functions.ContaPoupanca;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class MenuController {
    ContaCorrente cc = new ContaCorrente();
    ContaPoupanca cp = new ContaPoupanca();
    List<Conta> accounts = ListDados.getAccounts();
    int id = DadosTest.create();

    // Botões de seleção do home
    @FXML private Button botaoCadastro;

    @FXML private Button botaoEdicao;

    @FXML private Button botaoRemocao;

    @FXML private Button botaoReposicao;

    @FXML private Button botaoVenda;

    @FXML private Button botaoVisualizacao;

    // Exibir o layout de cadastro
    @FXML private Pane menuCadastro;

    // Exibir o layout de visualização
    @FXML private Pane menuVisualizacao;

    // Botao de seleção de tipo de conta no layout cadastro
    @FXML private MenuButton selectTipoConta;

    // Campos input do layout de cadastro
    @FXML private TextField campoNome;

    @FXML private TextField campoCpf;

    @FXML private TextField campoNumConta;

    @FXML private TextField campoSaldo;

    // Tabela para visualização das contas cadastradas
    @FXML private TableView<Conta> table;

    @FXML private TableColumn<Conta, String> contaTable;

    @FXML private TableColumn<Conta, String> cpfTable;

    @FXML private TableColumn<Conta, Double> saldoTable;

    @FXML private TableColumn<Conta, String> tipoContaTable;

    @FXML private TableColumn<Conta, String> titularTable;

    // Label com nome de um atributo do layout cadastro
    @FXML private Label textSaldo;

    // Ações de evento
    @FXML void cadastrarProdutos(ActionEvent event) {
        menuCadastro.setVisible(true);
    }

    @FXML void visualizarProdutos(ActionEvent event) {
        menuVisualizacao.setVisible(true);
        initTable(event);
    }

    @FXML void editarProdutos(ActionEvent event) {

    }

    @FXML void removerProdutos(ActionEvent event) {

    }

    @FXML void reporProdutos(ActionEvent event) {

    }

    @FXML void venderProdutos(ActionEvent event) {

    }

    @FXML void eventCC(ActionEvent event) {
        selectTipoConta.setText(cp.getTipoConta());
        textSaldo.setVisible(true);
        campoSaldo.setVisible(true);
    }

    @FXML void eventCP(ActionEvent event) {
        selectTipoConta.setText(cc.getTipoConta());
        textSaldo.setVisible(false);
        campoSaldo.setVisible(false);
    }

    @FXML void fazerCadastro(ActionEvent event) {
        String titular = campoNome.getText();
        String cpfTitular = campoCpf.getText();
        String numero = campoNumConta.getText();
        
        if (selectTipoConta.getText().equals(cp.getTipoConta())) {

            double saldo = Double.parseDouble(campoSaldo.getText().replaceAll(",", "."));

            ContaPoupanca cadastroPoupança = new ContaPoupanca(id, numero, titular, cpfTitular, saldo);
            accounts.add(cadastroPoupança);
        }
        if (selectTipoConta.getText().equals(cc.getTipoConta())) {

            ContaCorrente cadastroCorrente = new ContaCorrente(id, numero, titular, cpfTitular);
            accounts.add(cadastroCorrente);
        }
        initTable(event);
        fecharCadastro(event);
        id++;
    }

    @FXML void cancelarCadastro(ActionEvent event) {
        fecharCadastro(event);
    }

    void fecharCadastro(ActionEvent event) {
        selectTipoConta.setText("Selecione o tipo de Conta");

        campoNome.setText("");
        campoCpf.setText("");
        campoNumConta.setText("");
        campoSaldo.setText("");

        textSaldo.setVisible(false);
        campoSaldo.setVisible(false);

        menuCadastro.setVisible(false);
    }

    @FXML void closeVisualizar(ActionEvent event) {
        menuVisualizacao.setVisible(false);
    }

    void initTable(ActionEvent event) {

        titularTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitular().getNome()));
        cpfTable.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTitular().getCpf()));
        tipoContaTable.setCellValueFactory(new PropertyValueFactory<>("tipoConta"));
        contaTable.setCellValueFactory(new PropertyValueFactory<>("numero"));
        saldoTable.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        table.setItems(alterTable());
    }

    ObservableList<Conta> alterTable() {
        return FXCollections.observableArrayList(accounts);
    }
}
