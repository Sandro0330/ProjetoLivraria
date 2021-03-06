package br.com.projeto.infra;

import javax.servlet.http.Part;

public class FileSave {
	
	private static final String SERVER_PATH = "/ArqProjetoLivro";		

	
	public String write(Part arquivo, String path) {
		String relativePath = path + "/" + arquivo.getSubmittedFileName();
		try {
			arquivo.write(SERVER_PATH + "/" + relativePath);
			return relativePath;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
		
	}

}
