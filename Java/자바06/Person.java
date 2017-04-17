package ÀÚ¹Ù06;

public class Person {
		@PrintToString
		private String name;
		
		private int age;
		
		@PrintToString
		private String remark;
		
		public String toStirng(){
			return ToStringHelper.toString(this);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getRemark() {
			return remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}
}
