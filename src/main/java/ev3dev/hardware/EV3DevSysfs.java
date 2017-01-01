package ev3dev.hardware;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The class responsible to interact with Sysfs on EV3Dev
 * 
 * @author Juan Antonio Breña Moral
 *
 */
public @Slf4j class EV3DevSysfs extends Device {

	/**
	 * Write a value in a file.
	 * 
	 * @param filePath File path
	 * @param value value to write
	 * @return A boolean value if the operation was written or not.
	 */
	public boolean writeString(final String filePath, final String value) {
		log.debug("echo " + value + " > " + filePath);
		try {
			File mpuFile = new File(filePath);
			if(mpuFile.canWrite()) {
				BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
				bw.write(value);
				bw.close();
			}
		} catch (IOException ex) {
			return false;
		}
		return true;
	}
	
	public boolean writeInteger(final String filePath, final int value) {
		return this.writeString(filePath, "" + value);
	}
	
	/**
	 * Read an Attribute in the Sysfs with containing String values
	 * @param filePath
	 * @return value from attribute
	 */
	public String readString(final String filePath) {
		log.debug("cat " + filePath);
		String value;
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			value = br.readLine();
			br.close();
		} catch (IOException ex) {
			return "-1";
		}
		return value;
	}
	
	/**
	 * Read an Attribute in the Sysfs with containing Integer values
	 * @param filePath
	 * @return value from attribute
	 */
	public int readInteger(final String filePath) {
		return Integer.parseInt(this.readString(filePath));
	}
	
	public float readFloat(final String filePath) {
		return Float.parseFloat(this.readString(filePath));
	}
	
	/**
	 * 
	 * @param path
	 * @return an ArrayList with options from a path
	 */
	public ArrayList<File> getElements(final String path){
		final File f = new File(path);
		ArrayList<File> files = new ArrayList<File>(Arrays.asList(f.listFiles()));
		log.debug(path);
		return files;	
	}
	
}
