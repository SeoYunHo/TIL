package �ڹ�09;

class FileInputStream2 implements AutoCloseable{
	private String file;
	
	public FileInputStream2(String file){
		this.file=file;
	}
	
	public void read(){
		System.out.println(file+"�� �н��ϴ�.");
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(file+"�� �ݽ��ϴ�.");
	}
}

public class Ex_04 {
	public static void main(String[] args) {
		try(FileInputStream2 fis=new FileInputStream2("file.txt")){
			fis.read();
			throw new Exception();
		}catch(Exception e){
			System.out.println("���� ó�� �ڵ尡 ����Ǿ����ϴ�.");
		}
	}
}
