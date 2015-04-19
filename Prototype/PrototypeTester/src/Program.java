import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;


public class Program {

	public static void main(String[] args) throws IOException {
		System.setOut(new java.io.PrintStream(System.out, true, "UTF8"));
		
		if(args.length < 3)
		{
			System.out.println("A program parameterezese nem megfelelo!");
			System.out.println("program bemenetiFile elvartKimenetiFile");
			return;
		}
		
		String inputFile = args[1];
		String compFile = args[2];

		Process p;
		try {
			p = Runtime.getRuntime().exec(args[0]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Nem sikerult letrehozni a processt!");
			
			return;
		}
		
		PrintWriter procIn = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
		BufferedReader procOut = new BufferedReader(new InputStreamReader(p.getInputStream(),"UTF8"));
		
		BufferedReader inputFileReader;
		try {
			inputFileReader = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			System.out.println("Nem sikerult megnyitni a bemenetett tartalmazofilet!");
			return;
		}
		
		BufferedReader compFileReader;
		try {
			compFileReader = new BufferedReader(new FileReader(compFile));
		} catch (FileNotFoundException e) {
			System.out.println("Nem sikerult megnyitni a kimenetet tartalmazofilet!");
			return;
		}
		
		
		try {
			String inputLine = inputFileReader.readLine();
			
			while(inputLine != null)
			{
				procIn.println(inputLine);
				inputLine = inputFileReader.readLine();
			}
		} catch (IOException e) {
			procIn.println("Fuck");
		}
		procIn.flush();
		procIn.close();
		String outputLine;
		String compFileLine;
		int line = 0;
		
		do
		{
			outputLine = procOut.readLine();
			System.out.println(outputLine);
			outputLine = (outputLine != null) ? outputLine.trim().replaceAll(" +", " ") : outputLine;
			compFileLine = compFileReader.readLine();
			compFileLine = (compFileLine != null) ? compFileLine.trim().replaceAll(" +", " ") : compFileLine;
			line++;
		}while(outputLine != null && compFileLine != null &&
				outputLine.equals(compFileLine));
		
		if(outputLine == null && compFileLine == null)
		{
			System.out.println("A kiemenet megegyezik az elvart kiemenettel.");
		}
		else if(outputLine == null && compFileLine != null)
		{
			
			System.out.println("Az elvart kiemenet hosszab a kiemenetnel.");
		}
		else if(outputLine != null && compFileLine == null)
		{
			System.out.println("A kiemenet hosszab az elvart kiemenettnel.");
		}
		else
		{
			System.out.println("A következő 2 sor nem egyezik ("+line+"): ");
			System.out.println("Elvárt Kimenet: " + compFileLine);
			System.out.println("Kimenet       : " + outputLine);
		}
		
	}

}
