package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{
	// 나만의 파일 이름 변경 규약을 만드는 클래스

	@Override
	public File rename(File originFile) {
		
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int ranNum = (int)(Math.random() * 100000);
		
		String name = originFile.getName();
		String ext = null; // 확장자
		
		int dot = name.lastIndexOf("."); // this.is.my.dog.image.png -> 가장 마지막에 있는 점이 확장자를 구분할 수 있는 점일 것이다
		// 가장 마지막에 있는 .의 위치를 추출
		if(dot != -1) {
			ext = name.substring(dot); // 확장자 추출
		} else {
			// 존재하지 않을 때, 위치를 반환할 수 없을 때
			ext = "";
		}
		
		String fileName = sdf.format(new Date(currentTime)) + ranNum + ext;
		
		File newFile = new File(originFile.getParent(), fileName);
		// 만들어 주겠다고 했기 때문에 DB에 안 가도 폴더에 저장됨, but DB에 저장된 것은 아님
		
		return newFile;
	} 

}
