package tw.leonchen.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourcesController {
	
	
//	將這個resource定義清楚之後 ，然後在下面直接取得 （第三種方法)
	@Value("classpath:static/images/images02.jpg")
	private Resource resource;
	
	@GetMapping(path = "/resources2.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] prcessResourceAction() throws IOException {
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}

	

	@GetMapping(path = "/resources.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processAction() throws IOException {
//		尋找此resource的路徑
//		特別注意 這個路徑不受到 application.properties的之前設定的路徑給影響，因爲剛剛看了之後，并沒有設定路徑，單純是此類別需要輸入resources下的路徑
		Resource resource = new ClassPathResource("static/images/images02.jpg");
//		將此文件轉換成file的類別
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath());
		
//		將此文件轉換成 Input（byte的形式)
		InputStream is1 = resource.getInputStream();
//		轉換成byte陣列 （IOutil為靜態類別)
		return IOUtils.toByteArray(is1);
	}
	
	
//  與上述方式一樣，可以取得resources的物件（圖片）
//	autowire沒有定義爲什麽找得到？ 因爲内建在spring boot中
	@Autowired
	private ResourceLoader rl;
	
	@GetMapping(path = "/resourceloader.controller", produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] processResourceLoaderAction() throws IOException {
		Resource resource = rl.getResource("classpath:static/images/images02.jpg");
		File file = resource.getFile();
		System.out.println(file.getName() + " " + file.getPath());
		
		InputStream is1 = resource.getInputStream();
		return IOUtils.toByteArray(is1);
	}
	
	
}
