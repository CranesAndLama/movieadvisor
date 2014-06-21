package movieadvisor.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

public class ImageProcessor {
	
	private static final String IMAGE_ROOT_PATH = "E:/prog/java/webapps/movieadvisor/src/main/webapp/resources/img/";
	
	public static void validateImage(MultipartFile image) {
		if(!image.getContentType().equals("image/jpeg")) {
		throw new RuntimeException("Only JPG images accepted");
		}
	}
	public static void saveImage(String filename, MultipartFile image) throws RuntimeException{
		try {
			File file = new File(IMAGE_ROOT_PATH + filename);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		}
		catch(IOException e){
			throw new RuntimeException("Unable to save image",e);
	}
	}
}
