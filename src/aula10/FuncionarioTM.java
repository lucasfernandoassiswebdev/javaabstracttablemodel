package aula10;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author LUCASFERNANDODEASSIS
 */
public class FuncionarioTM extends AbstractTableModel {

    private List<Funcionario> linhas;
    private String[] colunas = new String[]{"Mat.", "Nome", "CPF"};

    public FuncionarioTM() {
        linhas = new ArrayList<>();
    }

    public FuncionarioTM(List<Funcionario> lista) {
        linhas = new ArrayList(lista);
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionario f = linhas.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return f.getMatricula();
            case 1:
                return f.getNome();
            case 2:
                return f.getCPF();
            default:
                throw new IndexOutOfBoundsException("column index out of bounds");
        }
    }

    //Modifica a linha e a coluna especificada
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Funcionario f = linhas.get(rowIndex); //Carrega o item da linha que deve ser modificado

        switch (columnIndex) {
            case 0:
                f.setMatricula(aValue.toString());
                break;
            case 1:
                f.setNome(aValue.toString());
                break;
            case 2:
                f.setCPF(aValue.toString());
                break;
            default:
                //Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("column index out of bounds");
        }
        fireTableCellUpdated(rowIndex, columnIndex); //Recarrega a linha e coluna que foram alteradas na tabela
    }

    //Modifica a linha especificada
    public void setValueAt(Funcionario aValue, int rowIndex) {
        Funcionario f = linhas.get(rowIndex);

        f.setMatricula(aValue.getMatricula());
        f.setNome(aValue.getNome());
        f.setCPF(aValue.getCPF());

        //Atualiza todas as colunas
        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Funcionario getFuncionario(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    public void addFuncionario(Funcionario f) {
        //Adiciona o registro
        linhas.add(f);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    //Remove a linha especificada
    public void remove(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    //Adiciona ma lista de Cliente ao final dos registros
    public void addLista(List<Funcionario> f) {
        //Pega o tamanho antigo da tabela
        int tamanhoAntigo = getRowCount();

        //Adiciona os registros
        linhas.addAll(f);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    //Remove todos os registros
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    //Verifica se este table model está vazio
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
