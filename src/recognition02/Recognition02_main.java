package recognition02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import com.ibm.watson.developer_cloud.visual_recognition.v3.VisualRecognition;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifiedImages;
import com.ibm.watson.developer_cloud.visual_recognition.v3.model.ClassifyOptions;

public class Recognition02_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VisualRecognition service = new VisualRecognition("2018-03-19");
		service.setApiKey("naisyo");

		InputStream imagesStream = null;
		try {
			imagesStream = new FileInputStream("img/fruitbowl.jpg");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassifyOptions classifyOptions = new ClassifyOptions.Builder()
		  .imagesFile(imagesStream)
		  .imagesFilename("fruitbowl.jpg")
		  .threshold((float) 0.6)
		  .owners(Arrays.asList("IBM"))
		  .build();
		ClassifiedImages result = service.classify(classifyOptions).execute();
		System.out.println(result);

	}

}
