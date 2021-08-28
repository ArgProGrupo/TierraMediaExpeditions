package controlDeExcepciones;

@SuppressWarnings("serial")
public class RequisitosInsuficientesException extends Exception {
	public RequisitosInsuficientesException() {
		super("Dinero o tiempo insuficiente para comprar esta atraccion");
	}
}
