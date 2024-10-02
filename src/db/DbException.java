package db;

//CRIANDO MINHA CLASSE PARA TRATAR EXCEPTIONS QUE VAI HERDAR O COMPORTAMENTO DA RUNTIME EXCEPTION PARA SER OBRIGADO A TRATAR
public class DbException extends RuntimeException{
	//ACEITANDO A CORRECAO DO ECLIPSE
	private static final long serialVersionUID = 1L;
	
	//SOBRESCREVENDO A MSG DA SUPERCLASSE RUNTIME EXCEPTION
	public DbException(String msg) {
		super(msg);
	}
}
