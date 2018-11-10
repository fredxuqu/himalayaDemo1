package com.himalaya.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
* @author: xuqu
* @E-mail: fredxuqu@163.com
* @version 
* 2018年9月14日 上午9:41:10
* Description
*/
public class FastJSON2POJO {
	
	//json字符串-简单对象型
	private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
	//json字符串-数组类型
	private static final String  JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
	//复杂格式json字符串
	private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

	@Test
	public void testJSONToJSONObject(){
		
		JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(JSON_OBJ_STR); //因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
	}
	
	@Test
	public void testJSONToJSONArray(){
		
		JSONArray jsonArray = JSON.parseArray(JSON_ARRAY_STR);
        //JSONArray jsonArray1 = JSONArray.parseArray(JSON_ARRAY_STR);//因为JSONArray继承了JSON，所以这样也是可以的

        //遍历方式1
        int size = jsonArray.size();
        for (int i = 0; i < size; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }

        //遍历方式2
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject.getString("studentName")+":"+jsonObject.getInteger("studentAge"));
        }
	}
	
	@Test
	public void testComplexJSONStrToJSONObject(){
		JSONObject jsonObject = JSON.parseObject(COMPLEX_JSON_STR);
        //JSONObject jsonObject1 = JSONObject.parseObject(COMPLEX_JSON_STR);//因为JSONObject继承了JSON，所以这样也是可以的
        
        String teacherName = jsonObject.getString("teacherName");
        Integer teacherAge = jsonObject.getInteger("teacherAge");
        JSONObject course = jsonObject.getJSONObject("course");
        JSONArray students = jsonObject.getJSONArray("students");
	}
	
	
	@Test
	public void testJSONStrToJavaBeanObj(){

        Student student = JSON.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});
        //Student student1 = JSONObject.parseObject(JSON_OBJ_STR, new TypeReference<Student>() {});//因为JSONObject继承了JSON，所以这样也是可以的

        System.out.println(student.getStudentName()+":"+student.getStudentAge());

    }
	
	@Test
	public void testJSONStrToJavaBeanList(){
        
        ArrayList<Student> students = JSON.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
        //ArrayList<Student> students1 = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});//因为JSONArray继承了JSON，所以这样也是可以的
        
        for (Student student : students) {
            System.out.println(student.getStudentName()+":"+student.getStudentAge());
        }
    }
	
	@Test
	public void testComplexJSONStrToJavaBean(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();
    }
	
	@Test
	public void testJavaBeanToJSONStr(){

        Teacher teacher = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});
        
        //Teacher teacher1 = JSON.parseObject(COMPLEX_JSON_STR, new TypeReference<Teacher>() {});//因为JSONObject继承了JSON，所以这样也是可以的
        String teacherName = teacher.getTeacherName();
        Integer teacherAge = teacher.getTeacherAge();
        Course course = teacher.getCourse();
        List<Student> students = teacher.getStudents();

        String jsonStr = JSON.toJSONString(teacher);
        System.out.println(jsonStr);
    }
	
	@Test
	public void testJSONToMap(){
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("foo", "Fred");
		map.put("baa", "1111111");
		
		String jsonStr = JSON.toJSONString(map);
		System.out.println(jsonStr);

        Map map1 = JSON.parseObject(jsonStr, new TypeReference<Map<String, String>>() {});
        
        System.out.println(map1);
    }
	
	@Test
	public void testMapToJSONStr(){
		
		Map<String, Collection<Student>> map = new HashMap<String, Collection<Student>>();
		Collection<Student> students = new ArrayList<Student>();
		students.add(new Student("Fred", 30));
		students.add(new Student("Wendy", 3));
		
		Collection<Student> students1 = new ArrayList<Student>();
		students1.add(new Student("Fred", 30));
		students1.add(new Student("Wendy", 3));
		students1.add(new Student("Lisha", 30));
		students1.add(new Student("Nobody", 30));
		map.put("12", students);
		map.put("13", students1);
		
		String jsonStr = JSON.toJSONString(map);
		System.out.println(jsonStr);

        Map map1 = JSON.parseObject(jsonStr, new TypeReference<Map<String, Collection<Student>>>() {});
        
        System.out.println(map1);
    }
}


class Student {

    private String studentName;
    private Integer studentAge;
    
    public Student() {
	}

    public Student(String studentName, Integer studentAge) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
	}

	public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }
}

class Course {

    private String courseName;
    private Integer code;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

class Teacher {

    private String teacherName;
    private Integer teacherAge;
    private Course course;
    private List<Student> students;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
