package application;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Digite sua senha: ");
		String s = sc.nextLine();
		
		//String PASSWORD_PATTERN = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\\\s)(?!.*[+\\\\-!]).{6,12})";
		//System.out.println(Pattern.matches("[a-z]", s));
		
		
		
		
		System.out.println("Teste de senha [" + s+"]");
		
		
		if (validaComplexidade(s) == 1) {
			System.out.println("Senha válida");
			System.out.println(validaComplexidade(s));
			
		}

		sc.close();

	}

	public static int validaComplexidade(String string) {
		
		int result = 1;
		
		// Validação de espaço em branco
		boolean space = false;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (Character.isSpaceChar(c))
				space = true;
		}
		if (space) {
			result = 0;
			System.out.println(result + " - Erro 1: Senha contém espaço em branco.");
		}
		
		// Validação de tamanho - entre 8 e 32 caracteres
		int tamanho = string.length();
		if (tamanho < 8) {
			result = 0;
			System.out.println(result + " - Erro 3: Senha menor que 8 caracteres.");
		}
		if (tamanho > 32) {
			result = 0;
			System.out.println(result + " - Erro 4: Senha maior que 32 caracteres.");
		}
		// Validação de caractere minusculo, maiusculo e numérico
		boolean lowerCase = false;
		boolean upperCase = false;
		boolean digit = false;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (Character.isLowerCase(c))
				lowerCase = true;
			if (Character.isUpperCase(c))
				upperCase = true;
			if (Character.isDigit(c))
				digit = true;
			
		}
		if (!lowerCase) {
			result = 0;
			System.out.println(result + " - Erro 5: Senha não contém caractere minúsculo.");
		}
		if (!upperCase) {
			result = 0;
			System.out.println(result + " - Erro 6: Senha não contém caractere maiúsculo.");
		}
		if (!digit) {
			result = 0;
			System.out.println(result + " - Erro 7: Senha não contém caractere numérico.");
		}
		
		//Validação caracteres especiais
		boolean special = false;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (!(c >= 'a' && c<= 'z' || c >= 'A'&& c<= 'Z' || c >= '0' && c <= '9' || c == ' '))
				special = true;
		}
		if (special) {
			result = 0;
			System.out.println(result + " - Erro 8: Senha contém caracteres não aceitos.");
		}


		
		
		return result;
	}
}
