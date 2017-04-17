package 자바09;

class FileInputStream2 implements AutoCloseable{
	private String file;
	
	public FileInputStream2(String file){
		this.file=file;
	}
	
	public void read(){
		System.out.println(file+"을 읽습니다.");
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(file+"을 닫습니다.");
	}
}

public class Ex_04 {
	public static void main(String[] args) {
		try(FileInputStream2 fis=new FileInputStream2("file.txt")){
			fis.read();
			throw new Exception();
		}catch(Exception e){
			System.out.println("예외 처리 코드가 실행되었습니다.");
		}
	}
}
