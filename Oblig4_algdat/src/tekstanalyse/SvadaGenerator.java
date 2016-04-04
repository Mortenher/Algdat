package tekstanalyse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SvadaGenerator {
	
	static BinarySearchTree bst = new BinarySearchTree();
	
	public static void main(String args[]) throws IOException{
		
		BufferedReader br = null;
		int counter = 0;

		try {

			Scanner sc = new Scanner(new File("C:\\Testmappe\\test.txt"));
			while(sc.hasNext()){
				counter++;
				String s = sc.next();
				//if(!s.equals(sc.next())){
					bst.addNode(counter, s);
					bst.inOrderTraverse(bst.root);
				//}
				
			}
			
			

		/*	
		 * String sCurrentLine;
		 * br = new BufferedReader(new FileReader("C:\\Testmappe\\test.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				String[] words = sCurrentLine.split(" ");
				counter++;
			
				bst.addNode(counter, words);
				bst.inOrderTraverse(bst.root);
				
			}*/

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
		
	}
}

