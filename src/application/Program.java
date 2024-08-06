package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite o caminho do arquivo: ");
		File caminho = new File(sc.next());
		
		Map<String, Integer> valoresTotais = new TreeMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
		
			String line = br.readLine();
			
			while (line != null) {
				String[] dados = line.split(",");
				line = br.readLine();
				if (valoresTotais.containsKey(dados[0])) {
					valoresTotais.merge(dados[0], Integer.parseInt(dados[1]), Integer::sum);
				} else {
					valoresTotais.put(dados[0], Integer.parseInt(dados[1]));
				}
				
			}
			
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		for (String key : valoresTotais.keySet()) {
			System.out.println(key + " : " + valoresTotais.get(key));
		}
	}

}
