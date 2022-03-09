package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadFromFile {

	public ArrayList<Pessoa> obterInformacaoFicheiro(String fileName) {
		ArrayList<Pessoa> listaPessoasFicheiro = new ArrayList<>();
		
		try {
			InputStream ioStream = getFileAsIOStream(fileName);
			
			String fileContent = getFileContent(ioStream);
			
			listaPessoasFicheiro = convertStringToListPessoas(fileContent);
		}catch(Exception e) {
			System.out.print(e);
		}
		
		return listaPessoasFicheiro;
	}
	
	
	private InputStream getFileAsIOStream(String fileName) {
		InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
	}
	
	private String getFileContent(InputStream is)
    {
        String filecontent = "";
        
        try {
        	InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            while ((line = br.readLine()) != null) {
                filecontent = filecontent + line;
            }
            
            is.close();
            
        }catch(IOException e)
        {
        	System.out.print(e);
        }

        return filecontent;
    }
	
	private ArrayList<Pessoa> convertStringToListPessoas(String text) throws JSONException {
		ArrayList<Pessoa> listaPessoasFicheiroAux = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(text);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            
            Pessoa pessoaAux = new Pessoa(
            		jsonObject.getString("Primeiro_nome"), 
            		jsonObject.getString("Ultimo_nome"),
            		jsonObject.getInt("Idade"),
            		jsonObject.getDouble("Saldo")
            	);

            listaPessoasFicheiroAux.add(pessoaAux);
        }

        return listaPessoasFicheiroAux;
    }
	
	
}
