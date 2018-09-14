package projectdemo.webproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ecomProject.ecommerce.model.Product;
@Service
public class ImageUpload {

	public void uploadImage(Product product,HttpServletRequest request) {
		
		String contextPath = request.getRealPath("/");
		File file = new File(contextPath + "/resources/images/products/");

		if (!file.exists()) {
			file.mkdir();
		}

		System.out.println(file.getPath());
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file.getPath() + "/" + product.getProduct_id() + ".jpg");
			InputStream inputStream = product.getImage().getInputStream();
			byte[] imageBytes = new byte[inputStream.available()];
			inputStream.read(imageBytes);

			fileOutputStream.write(imageBytes);
			fileOutputStream.flush();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}

	}
}
