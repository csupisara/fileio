package ku.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Class for copying from one file to another.
 * @author Supisara Chuthathumpitak
 *
 */
public class FileUtil {
	/**
	 * Copy the InputStream to the OutputStream one byte at a time.
	 * @param in is the input that want to read.
	 * @param out is the output that want to write.
	 */
	static void copy( InputStream in, OutputStream out ) {
		try{
			byte[] buffer = new byte[1];
			int length = in.read(buffer);
			while (length > 0) { //When there is no more data, it will return length < 0
			    out.write(buffer, 0, length);
			    length = in.read(buffer);
			}
			in.close();
			out.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using byte array of size blocksize.
	 * @param in is the input that want to read.
	 * @param out is the output that want to write.
	 * @param blocksize is the size that want the array to have.
	 */
	static void copy( InputStream in, OutputStream out, int blocksize ) {
		try{
			byte[] buffer = new byte[blocksize];
			int length = in.read(buffer);
			while (length > 0) { //When there is no more data, it will return length < 0
			    out.write(buffer, 0, length);
			    length = in.read(buffer);
			}
			in.close();
			out.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Copy the InputStream to the OutputStream using BufferedReader and PrintWriter.
	 * BufferedReader read the InputStream.
	 * PrintWriter read the OutputStream.
	 * @param in is the input that want to read.
	 * @param out is the output that want to write.
	 */
	static void bcopy( InputStream in, OutputStream out ) {
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			PrintWriter printWriter = new PrintWriter(out);
			String read = bufferedReader.readLine();
			while ( read != null ) {
				printWriter.write(read);
				read = bufferedReader.readLine();
			}
			bufferedReader.close();
			printWriter.close();
			in.close();
			out.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
