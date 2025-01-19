package com.training.LearningManagmentSystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.LearningManagmentSystem.student.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@SpringBootApplication
public class LearningManagmentSystemApplication {

	public static void main(String[] args) throws JsonProcessingException {
		SpringApplication.run(LearningManagmentSystemApplication.class, args);

//		Test s = new Test();
//		s.setS("ss");
//		String ss = s.getS() == null ?null : "Wassem Tenbakji";
//
//		System.out.println(ss);

//
//		String s = "[\n" +
//				"   {\n" +
//				"        \"CC Clients Reaching Sales Out of Shift\": 11 ,\n" +
//				"        \"MV Clients Reaching Sales Out of Shift\": 22 ,\n" +
//				"   }\n" +
//				"]";
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		Map<String, List<Map<String, Object>>> sourceTargetSkills;
//		sourceTargetSkills = mapper.readValue(
//				s , Map.class
//		);
//
//		Map<String, String> result = new HashMap<>();
////        String s = sourceTargetSkills.values();
//		for (List<Map<String, Object>> sourceTargetSkill : sourceTargetSkills.values()) {
//			for (Map<String, Object> targetSkill : sourceTargetSkill) {
//				System.out.println(targetSkill);
//			}
//		}

//		String s =
//				"   {\n" +
//				"        \"CC Clients Reaching Sales Out of Shift\":\"11\" ,\n" +
//				"        \"MV Clients Reaching Sales Out of Shift\": \"22\",\n" +
//				"        \"Wassem\": \"Tn\",\n" +
//				"        \"Ahmad\": \"Tn\"\n" +
//				"   }\n";

//		ObjectMapper mapper = new ObjectMapper();

		// Deserialize as List<Map<String, Object>>
//		Map<String, Object> sourceTargetSkills = mapper.readValue(
//				s, new TypeReference<>() {}
//		);

		// Iterate over the list and print each map
//		for (Map<String, Object> sourceTargetSkill : sourceTargetSkills) {
//			for(String key : sourceTargetSkills.keySet()) {
//				System.out.println(key + ": " + sourceTargetSkills.get(key));
//			}
//		}
	}
}
