package com.sb.basic.jpa.ex01;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class MemoRepositoryTest {
	@Autowired    
	MemoRepository memoRepository;  
	
	@GetMapping("/create")
	public void InsertDummies() {
		IntStream.rangeClosed(1, 10).forEach(i -> {
			Memo memo = Memo.builder()
					.memoText("Sample..." + i)
					.build();
			//Create!
			memoRepository.save(memo);
		});
	}
	
	@GetMapping("/read")
	public void SelectDummies() {
		Long id = 10L;
		Optional<Memo> result = memoRepository.findById(id);
		System.out.println("=============================");
		if(result.isPresent()) {
			Memo memo = result.get();
			System.out.println(memo);
		}
	}
	
	@GetMapping("/update")
	public void UpdateDummies() {
		Memo memo = Memo.builder()
				.id(10L)
				.memoText("Update Text")
				.build();
		memoRepository.save(memo);
	}
	
	@GetMapping("/delete")
	public void DeleteDummies() {
		Long id = 10L;
		memoRepository.deleteById(id);
	}
}
