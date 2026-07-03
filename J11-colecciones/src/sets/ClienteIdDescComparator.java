package sets;

import java.util.Comparator;

public class ClienteIdDescComparator implements Comparator<Cliente> {

	@Override
	public int compare(Cliente c1, Cliente c2) {
		return c2.getIdCliente() - c1.getIdCliente();
	}

}
