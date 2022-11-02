package com.web.exercise.bo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.exercise.dao.HostDAO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.AliveStatus;

@Service
public class StatusBO {

	@Autowired
	private StatusDAO statusDAO;
	
	@Autowired
	private HostDAO hostDAO;
	
	// controller에서 name 받아와서, db에서 해당하는 ip가져온다
	// 가져온 ip로 InetAddress.isReachable() 수행해서 결과(true,false)얻고
	// name과 alive여부(수행결과)를 db에 입력한다
	public int aliveCheck(String name) {
		
		String ip = hostDAO.selectIP(name);
		boolean isAlive = false;
		
		try {
			
			/*
			 * 1. InetAddress.getByName(ip 주소); : 서버 아이피 주소를 지정합니다
			 * 2. isReachable : 타임아웃 체크로 해당 서버에서 응답이 있을 경우 true 반환, 응답이 없을 경우 false 반환합니다  
			 */
			InetAddress pingCheck = InetAddress.getByName(ip);
			isAlive = pingCheck.isReachable(1000);
//			System.out.println("서버응답 : " + isAlive);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return statusDAO.updateStatus(name, isAlive);
	}
	
	
	public List<AliveStatus> makeList() {
		
		List<List<String>> nameIpList = hostDAO.selectNameIp();
		
		for (int i = 0; i < nameIpList.size(); i++) {
			
			boolean isAlive = false;
			
			try {
				
				/*
				 * 1. InetAddress.getByName(ip 주소); : 서버 아이피 주소를 지정합니다
				 * 2. isReachable : 타임아웃 체크로 해당 서버에서 응답이 있을 경우 true 반환, 응답이 없을 경우 false 반환합니다  
				 */
				InetAddress pingCheck = InetAddress.getByName(nameIpList.get(i).get(1));
				isAlive = pingCheck.isReachable(1000);
//				System.out.println("서버응답 : " + isAlive);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			statusDAO.updateStatus(nameIpList.get(i).get(0), isAlive);
		}
		
		
		List<AliveStatus> statusList = statusDAO.selectAllStatus();
		
		
		return statusList;
	}
}
