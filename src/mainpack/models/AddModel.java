package mainpack.models;

public class AddModel {
	private int id;
	private String fullName;
	private String course;
	private String studentId;
	private String permitCode;
	private String permitAvailability;
	private String email;
	private String phone;
    private Object [][] cols = {{}};
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
    public void setFullName(String fullname) {
        this.fullName = fullname;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public String studentId(){
        return studentId;
    }
    public void setStudentId(String studentId){
        this.studentId = studentId;
    }
}
