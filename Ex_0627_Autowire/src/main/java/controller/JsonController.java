package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vo.PersonVO;

@Controller
public class JsonController {

	@RequestMapping("/vo_to_json")
	@ResponseBody
	public PersonVO voJson() {
		PersonVO p = new PersonVO();
		p.setAddr("인천시 부평구");
		p.setName("홍길동");
		p.setAge(30);
		return p;
	}
	
	@RequestMapping("/map_to_json")
	@ResponseBody
	public HashMap<String,Object> mapJson(){
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("name", "홍길동");
		map.put("age", 20);
		
		HashMap<String,String> tel_map = new HashMap<String,String>();
		tel_map.put("home", "032-1111-1111");
		tel_map.put("cell", "010-2222-2222");
		
		map.put("tel", tel_map);
		
		return map;
	}
	
	@RequestMapping("list_to_json")
	@ResponseBody
	public List<PersonVO> listJson(){
		List<PersonVO> list = new ArrayList<PersonVO>();
		
		PersonVO p1 = new PersonVO();
		p1.setName("홍길동");
		p1.setAge(30);
		p1.setAddr("인천시 부평구");
		
		PersonVO p2 = new PersonVO();
		p2.setName("김길동");
		p2.setAge(40);
		p2.setAddr("인천시 계양구");
		
		list.add(p1);
		list.add(p2);
		
		return list;
	}
	
	@RequestMapping("json_to_java")
	public void jsonJava() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "{\"age\": 30, \"name\" : \"Anna\", \"addr\" : \"인천시 부평구\"}";
		
		//Jackson ObjectMapper 객체 생성하기
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Json String -> Person Object
		PersonVO vo = objectMapper.readValue(jsonStr, PersonVO.class);
		
		System.out.println(vo);
	}
	
	@RequestMapping("json_to_map")
	public void jsonMap() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "{\"age\": 30, \"name\" : \"Anna\", \"addr\" : \"인천시 부평구\"}";
		
		//Jackson ObjectMapper 객체 생성하기
		ObjectMapper objectMapper = new ObjectMapper();
		
		//Json -> Map
		Map<String, Object> map = objectMapper.readValue(jsonStr, new TypeReference<Map<String,Object>>() {});
		System.out.println(map);
	}
	
	//JsonArray -> Java 배열
	@RequestMapping("json_to_array")
	public void jsonArray() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "[{\"age\": 30, \"name\" : \"Anna\", \"addr\" : \"인천시 부평구\"},{\"age\": 40, \"name\" : \"Thomas\", \"addr\" : \"서울시 관악구\"}]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		PersonVO[] personArr = objectMapper.readValue(jsonStr, PersonVO[].class);
		
		System.out.println(Arrays.toString(personArr));
	}
	
	//JsonArray -> Java List
	@RequestMapping("json_to_list")
	public void jsonList() throws JsonParseException, JsonMappingException, IOException {
		String jsonStr = "[{\"age\": 30, \"name\" : \"Anna\", \"addr\" : \"인천시 부평구\"},{\"age\": 40, \"name\" : \"Thomas\", \"addr\" : \"서울시 관악구\"}]";
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		List<PersonVO> list = objectMapper.readValue(jsonStr, new TypeReference<List<PersonVO>>() {});
		
		System.out.println(list);
	}
	
	
	
	
	
	
}
