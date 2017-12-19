package conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import modelo.dao.FilialDAO;
import modelo.dominio.Filial;

@FacesConverter(value="fil-converter")
public class FilialConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
			
		Long codigo;
		try {
			codigo = Long.parseLong(value);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		if (codigo != null)
		{
			FilialDAO dao = new FilialDAO();
			
			Filial fil = dao.lerPorId(codigo);
			
			return fil;  
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value instanceof Filial)
		{
			Filial fil = (Filial) value;
			return fil.getCodigo().toString();
		}
		
		return null;
	}

}
