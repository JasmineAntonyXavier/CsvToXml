package conversion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvToXml {
	// read the csv file and writing all the headers as an attribute of the xml file.
	// Assumptions:
	// - .csv file is not null
	// - the value of the attributes is not null
	// - .xml file is created
	
	public static void main(String[] args) throws Exception {
		
		//creating the xml file
		File file = new File("./names.xml");
		file.createNewFile();
		FileWriter writer= new FileWriter(file);
		
		String splitby = ",";
		String startfile= args[0];
		//  this will read the .csv file 
		BufferedReader reader = new  BufferedReader(new FileReader(startfile) );
		
		// this will read the first line of the .csv file and it always will be the header
		String line=reader.readLine();
		String[] header = line.split(splitby);
		
		// this will loop through the values of the rest of the csv file 
		while ((line = reader.readLine()) != null){
			String[]elements = line.split(splitby);
		
			//  this will write the values into the .xml file 	
			writer.write("<");
			for(int i = 0; i < elements.length; i++){
				writer.write(header[i]+"=\""+elements[i]+"\"");
			}
			writer.write(">\n");
		}
		reader.close();	
		writer.close();
		
	}

}
