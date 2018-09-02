
public class SubtractionOperationFactory implements OperationFactory{

	@Override
	public Operation getOperation() {
		return new SubtractionOperation();
	}

}
