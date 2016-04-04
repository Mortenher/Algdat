package tekstanalyse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SvadaGenerator {
	
	static BinarySearchTree bst = new BinarySearchTree();
	public static final String PATH = "C:\\Testmappe\\churchill.txt";
	
	public static String readFile(){
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(new FileReader(PATH));
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
		String fileAsString = "";
		String sCurrentLine;
		
		try{
			while((sCurrentLine = br.readLine()) != null) {
				fileAsString += sCurrentLine.toUpperCase() + " ";
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}	
		return fileAsString;
		
	}
	
	public static String[] makeWordArray(String s){
		String[] tmp = s.split("[^\\wæøåÆØÅ]+");
		
		return tmp;
	}
	
	public static void main(String args[]) throws IOException{
	
		for(String s: makeWordArray(readFile())){
			bst.addNode(s);
		}
		
		bst.printTree();
	}
}