package br.com.projeto.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.projeto.model.Autor;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String id) {
		if(id == null || id.trim().isEmpty()) {
			return null;
		}
		System.out.println("Convertendo para objeto: " + id);
		Autor autor= new Autor();
		autor.setId(Integer.valueOf(id));
		return autor;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object autorObject) {
		if(autorObject == null) {
			return null;
		}
		System.out.println("Convertendo para objeto: " + autorObject);
		Autor autor = (Autor) autorObject;
		return autor.getId().toString();
	}
}
