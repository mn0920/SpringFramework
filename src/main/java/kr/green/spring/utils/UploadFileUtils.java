package kr.green.spring.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {
	public static String uploadFile(String uploadPath, String originalName, byte[] fileData)throws Exception{
		UUID uid = UUID.randomUUID();
		String savedName = uid.toString() +"_" + originalName;
		//uid+기존의 이름
		String savedPath/*업로드한 날짜가 다르기에 계속 바뀐다. 계속 계산(날짜별다른 폴더에 저장*/
		 = calcPath/*경로계산 메소드*/(uploadPath/*항상 고정된 저장 경로(즉, 날짜 별로 구분되기 직전까지의 경로*/);
		
		//파일의 경로를 합쳐서 이제 알려주는 것이다.
		File target = new File(uploadPath + savedPath, savedName);
		//이제 진짜로 파일을 저장한다. 
		FileCopyUtils.copy(fileData, target);
		String uploadFileName = makeIcon(uploadPath, savedPath, savedName);
		return uploadFileName;
	}
	
	private static String calcPath(String uploadPath) {
		/* 경로(Path)설정을 하는 메소드 */
		Calendar cal = Calendar.getInstance();
		
		String yearPath = File.separator+cal.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator 
            + new DecimalFormat/*월을 두자리로 맞추겠다는 의미의 포맷설정*/("00").format(cal.get(Calendar.MONTH)+1);
		String datePath = monthPath + File.separator 
            + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		makeDir(uploadPath, yearPath, monthPath, datePath);
		
		return datePath;
 
	}
	private static void makeDir(String uploadPath, String... paths) {
		/*String... paths : 우리가 경로를 정확히 아는 것이 아니기 때문에 (배열로)묶어준 것이다.*/
		if(new File(paths[paths.length-1]).exists())/*날짜(date)를 비교하는 것 임*/
			/* 경로에 그 날짜의 폴더가 있는지 없는지 확인하고, 있으면 그냥 파일을 저장한다. */
			return;
		for(String path : paths) {
			File dirPath = new File(uploadPath/*기본 서블릿에 저장되는 경로*/ + path/*년->월->일 순으로 배열을 바꿔가며 확인을 한다*/);
			if( !dirPath.exists())/*만약 경로가 존재하지 않으면*/
				dirPath.mkdir();/*그 경로를 만들어라*/
		}
	}
	private static String makeIcon(String uploadPath, String path, String fileName)
        	throws Exception{
		String iconName = uploadPath/*기초경로*/ + path/*년월일경로*/ + File.separator + fileName;
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/'/* \\를 /로 바꾸겠다. : 우리가 URL경로를 보기위해선 / 경로가 필요하기 때문 */);
	}
}