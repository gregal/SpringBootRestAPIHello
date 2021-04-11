package restapists;

import javax.persistence.EntityNotFoundException;

public class ArtigoNotFoundException extends EntityNotFoundException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2599003813661526281L;

	ArtigoNotFoundException(Long id) {
	    super("Artigo não encontrado: " + id);
	}

}
