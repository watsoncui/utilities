import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Filter {

	public static final String fileName = "/Users/mac/Desktop/allResults.txt";
	public static final String outputFileName = "/Users/mac/Desktop/filtered.csv";
	public static final String gemsFiltered = "/Users/mac/Desktop/gems.csv";
	public static final String fbFiltered = "/Users/mac/Desktop/fb.csv";
	public static final String vsFiltered = "/Users/mac/Desktop/vs.csv";
	
	public static final String trueFiltered = "/Users/mac/Desktop/true.csv";
	
	public static final String gatkFiltered = "/Users/mac/Desktop/gatk.csv";

	/**
	 * @throws Exception
	 */
	public static void filterZero() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(
				new File(fileName)));
		PrintWriter pw = new PrintWriter(new FileWriter(
				new File(outputFileName)));
		PrintWriter gemspw = new PrintWriter(new FileWriter(new File(
				gemsFiltered)));
		PrintWriter fbpw = new PrintWriter(new FileWriter(new File(fbFiltered)));
		PrintWriter vspw = new PrintWriter(new FileWriter(new File(vsFiltered)));
		
		PrintWriter truepw = new PrintWriter(new FileWriter(new File(trueFiltered)));
		PrintWriter gatkpw = new PrintWriter(new FileWriter(new File(gatkFiltered)));

		String line = br.readLine();

		pw.println(line);
		gemspw.println(line);
		fbpw.println(line);
		vspw.println(line);
		
		truepw.println(line);
		gatkpw.println(line);
		
		while (null != (line = br.readLine())) {
			String[] infos = line.split("\t");
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				sum += Integer.parseInt(infos[i + 4]);
			}

			if (sum <= 3) {
				pw.println(line);
				if ((Integer.parseInt(infos[4]) == 1) && (Integer.parseInt(infos[8]) == 0)) {
					
					truepw.println(line);
					
					if (Integer.parseInt(infos[5]) == 1) {
						gemspw.println(line);
					}
					if (Integer.parseInt(infos[6]) == 1) {
						fbpw.println(line);
					}
					if (Integer.parseInt(infos[7]) == 1) {
						vspw.println(line);
					}
					if (Integer.parseInt(infos[8]) == 1) {
						gatkpw.println(line);
					}
				}
			}
		}
		
		gatkpw.close();
		truepw.close();
		gemspw.close();
		vspw.close();
		fbpw.close();
		pw.close();
		br.close();
	}

	public static void main(String[] args) throws Exception {
		filterZero();
	}
}
