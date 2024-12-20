package com.web.exercise.bo;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.exercise.dao.HostDAO;
import com.web.exercise.dao.StatusDAO;
import com.web.exercise.model.AliveStatus;
import com.web.exercise.model.HostInfo;

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
			
			InetAddress pingCheck = InetAddress.getByName(ip);
			isAlive = pingCheck.isReachable(10);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (isAlive) {
			return statusDAO.updateStatus(name, isAlive);			
		} else {
			return statusDAO.updateOnlyAlive(name, isAlive);
		}
	}
	
	
	public List<AliveStatus> makeList() {
		
		List<HostInfo> hostList = hostDAO.selectNameIp();
		
		for (int i = 0; i < hostList.size(); i++) {
			
			boolean isAlive = false;
			
			try {
				
				InetAddress pingCheck = InetAddress.getByName(hostList.get(i).getIp());
				isAlive = pingCheck.isReachable(10);

			} catch (Exception e) {
				e.printStackTrace();
			}
			if (isAlive) {
				statusDAO.updateStatus(hostList.get(i).getName(), isAlive);			
			} else {
				statusDAO.updateOnlyAlive(hostList.get(i).getName(), isAlive);
			}

		}
		
		
		List<AliveStatus> statusList = statusDAO.selectAllStatus();
		
		
		return statusList;
	}
}
